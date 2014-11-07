package odpgl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import almacenamiento.Persistencia;
import pedidos.Pedido;
import pedidos.Pedido.Estado;
import miEmpresa.Camiones;
import miEmpresa.Persona;
import clientes.Cliente;
import clientes.Historial;
import clientes.listaPedidosOrdenados;


public class Implementacion 
{
	
	private Set<Persona> BaseDeDatosPersonas;
	private Set<Camiones> BaseDeDatosCamiones;
	private Historial historialClientes;
	private String rutaBasePersonas = "Datos/personas.txt";
	private String rutaBaseCamiones= "Datos/camiones.txt";
	private String rutaBaseClientes = "Datos/clientes.txt";

	
	public Implementacion ()
	{
		this.BaseDeDatosPersonas = recuperarBasePersonas(this.rutaBasePersonas);
		this.BaseDeDatosCamiones = recuperarBaseCamiones(this.rutaBaseCamiones);
		this.historialClientes = recuperarBaseClientes(this.rutaBaseClientes);	
	}
	
	public Set<Persona> recuperarBasePersonas(String rutaBasePersonas )
	{
		if(Persistencia.existe(rutaBasePersonas))
			return Persistencia.desserializar(rutaBasePersonas);
		else
			return new HashSet<Persona>();	
	}
	
	public Set<Camiones> recuperarBaseCamiones(String rutaBaseCamiones)
	{
		if(Persistencia.existe(rutaBaseCamiones))
			return Persistencia.desserializar(rutaBaseCamiones);
		else
			return new HashSet<Camiones>();	
	}
	
	public Historial recuperarBaseClientes(String rutaBaseCamiones)
	{
		if(Persistencia.existe(rutaBaseClientes))
			return Persistencia.desserializar(rutaBaseClientes);
		else
			return new Historial();	
	}
	
//Metodos de ABM de los empleados de la empresa (alta/baja/modificacion) 
		
	//agrego una persona a la base de mi empresa
	public void agregarPersona(Persona nueva)
	{
		this.BaseDeDatosPersonas.add(nueva);
		Persistencia.serializar(this.BaseDeDatosPersonas, this.rutaBasePersonas);
	}
	

	
	//elimino una persona
	public void borrarPersona(Persona borrar)
	{
		this.BaseDeDatosPersonas.remove(borrar);
		Persistencia.serializar(this.BaseDeDatosPersonas, this.rutaBasePersonas);
	}
	
	
	//edita una persona
	public void editarPersona(Persona edit, String nombre, String foto, String legajo, String licencia)
	{
		//notar que el dni no se puedee editar, pues define la igualdad entre 2 personas
		edit.setFoto(foto);
		edit.setLegajo(legajo);
		edit.setLicencia(licencia);
		edit.setNombre(nombre);
		Persistencia.serializar(this.BaseDeDatosPersonas, this.rutaBasePersonas);
	}
	
	
	
	//buscar una persona
	
	public boolean buscarPersona(String DNI)
	{
		Persona nueva = new Persona("",DNI,"","","");
		if(this.BaseDeDatosPersonas.contains(nueva))
			return true;
		return false;
	}

//Metodos de ABM de los camiones de la empresa (alta/baja/modificacion)


	//agregar un camion a la base mi empresa
	public void agregarCamion(Camiones nuevo)
	{
		this.BaseDeDatosCamiones.add(nuevo);
		Persistencia.serializar(this.BaseDeDatosCamiones, this.rutaBaseCamiones);
	}
	
	//editar camion de la base mi empresa - no se permite editar patente
	public void editarCamion(Camiones edit, int anio, String color, String marca, String modelo)
	{
		//notar que el patente no se puede editar, pues define la igualdad entre 2 Camiones
		edit.setAnio(anio);
		edit.setColor(color);;
		edit.setMarca(marca);
		edit.setModelo(modelo);
		Persistencia.serializar(this.BaseDeDatosCamiones, this.rutaBaseCamiones);
	}
	
	//borrar camion de la base mi empresa
	public void borrarCamion(Camiones borrar)
	{
		this.BaseDeDatosCamiones.remove(borrar);
		Persistencia.serializar(this.BaseDeDatosCamiones, this.rutaBaseCamiones);
	}
	
	//borrar camion de la base a partir de su patente
	public void borrarCamiones(String patente)
	{
		Camiones nuevo = new Camiones(patente, "","","",0);
		this.BaseDeDatosCamiones.remove(nuevo);
		Persistencia.serializar(this.BaseDeDatosCamiones, this.rutaBaseCamiones);
		
	}
	
	public boolean buscarCamiones(String patente)
	{
		Camiones nuevo = new Camiones(patente,"","","",0);
		if(this.BaseDeDatosCamiones.contains(nuevo))
			return true;
		return false;
	}
		
//*********************************************************************************
		
//********
//METODOS SOBRE LOS CLIENTES

	//agregar un nuevo cliente
	public void agregarCliente(Cliente nuevo)
	{
		this.historialClientes.agregarCliente(nuevo);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
	}
	
	
	//borrar un cliente
	public void borrarCliente(Cliente eliminar)
	{
		this.historialClientes.borrarCliente(eliminar);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
		
	}
	
	
	//borrar un cliente a partir de su cuit
	public void borrarCliente(String cuit)
	{
		this.historialClientes.borrarCliente(cuit);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
	}
	
	
	//Editar un cliente
	public void editarCliente(Cliente AEditar, String nombre, String telefono, String nombre_Contacto)
	{
		this.historialClientes.editarCliente(AEditar, nombre, telefono, nombre_Contacto);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
		
	}
	
	
	//devuelve la cantidad de clientes
	public int cantidadClientes()
	{
		return this.historialClientes.cantidadClientes();
	}
	
	
	//Devuelve todos los pedidos del cliente
	public listaPedidosOrdenados getPedidos(Cliente cliente)
	{
		return this.historialClientes.getPedidos(cliente);
		
	}
	
	//Devuelve todos los pedidos solicitados del cliente
	public Set<Pedido> getPedidosSolicitados(Cliente cliente)
	{
		return this.historialClientes.getPedidosSolicitados(cliente);
	}
	
	
	//Devuelve todos los pedidos Asignados del cliente
	public Set<Pedido> getPedidosAsignados(Cliente cliente)
	{
		return this.historialClientes.getPedidosAsignados(cliente);
	}
	
	
	//Devuelve todos los pedidos cerrados del cliente
	public Set<Pedido> getPedidosCerrados(Cliente cliente)
	{
		return this.historialClientes.getPedidosCerrados(cliente);
	}
		
		
	//Devuelve todos los pedidos anulados del cliente
	public Set<Pedido> getPedidosAnulados(Cliente cliente)
	{
		return this.historialClientes.getPedidosAnulados(cliente);
	}

	
	
	
	
//METODOS SOBRE LOS PEDIDOS
	
	//agregar un pedido
	public void crearPedido(Pedido nuevo)
	{
		this.historialClientes.agregarPedido(nuevo);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
			
	}
	
	
	//editar un pedido
	public void editarPedido(Pedido nuevo, Camiones camion, String contacto,Persona chofer, Estado estado, String observaciones, String telefono_contacto)
	{
		this.historialClientes.editarPedido(nuevo, camion, chofer,contacto,estado, observaciones, telefono_contacto);
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
			
	}
	
	
	//borrar un pedido - los pedidos no se borrar - se anulan 
	public void cancelarPedido(Pedido nuevo)
	{
		this.historialClientes.editarPedido(nuevo,nuevo.getCamion(),nuevo.getChofer(),nuevo.getContacto_pedido(),Estado.Anulado,nuevo.getObservaciones(),nuevo.getContacto_pedido());
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
	}


	//cambiar estado de un pedido
	public void cambiarEstadoPedido(Pedido nuevo, Estado estado)
	{
		this.historialClientes.editarPedido(nuevo,nuevo.getCamion(),nuevo.getChofer(),nuevo.getContacto_pedido(),estado,nuevo.getObservaciones(),nuevo.getContacto_pedido());
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
	}

	
	//asignar chofer
	public void asignarChoferPedido(Pedido nuevo,Persona chofer)
	{
		this.historialClientes.editarPedido(nuevo,nuevo.getCamion(),chofer,nuevo.getContacto_pedido(),nuevo.getEstado(),nuevo.getObservaciones(),nuevo.getContacto_pedido());
		Persistencia.serializar(this.historialClientes, this.rutaBaseClientes);
	
	}
	
	
	//falta implementar
	//Dada una lista de pedidos seleccionados, calcula el mejor recorrido
	
	public void calcularMejorRecorrido(Set<Pedido> pedidosSeleccionados)
	{
		//Dado el Set de pedidos solicitados asignados se debe calcular su mejor recorrido
		//hay que utilizar lo de lucas
	}


	//genera un Set con los clientes
	public Set <Cliente> getListaClientes() 
	{
		return this.historialClientes.getClientes();
		
	}

	@Override
	public String toString()
	{
		return "imprime";
	}

}
