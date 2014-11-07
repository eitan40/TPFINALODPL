package almacenamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

	public class Persistencia {

		@SuppressWarnings({ "unchecked" })
		public static <T> T desserializar(String path) {
			T p = null;
			try {
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis);
				p = (T) ois.readObject();
				ois.close();
			} catch (Exception ex) {
				// incompatibilidad o inexistente.
//				ex.printStackTrace();
				p = null;
			}
			return p;
		}

		public static <T> void serializar(T data, String path) {
			try {
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		@SuppressWarnings({ })
		public static boolean existe(String path) {

			File file = new File(path);
			return file.exists();
		}
		
		public static boolean delete(String path){
			File file = new File(path);
			return file.delete();
		}

}
