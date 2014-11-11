package pedidos;
//Comentario!!!!!!!
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha implements Serializable
{
	private Calendar fecha = GregorianCalendar.getInstance();
	private String f;;
	
	public Fecha()
	{
		f=fecha.getTime().toLocaleString(); 
		
	}
	
	@Override
	public String toString()
	{
		return f.toString();
	}
}
