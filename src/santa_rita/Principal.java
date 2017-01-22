package santa_rita;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.UIManager;

import formularios.Santa_Rita;

public class Principal
{
    public static void main(String[] args) throws Exception, Exception, Exception, Exception
    {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	getDatos();
	Monitor hilo1 = new Monitor();
	Santa_Rita hilo2 = new Santa_Rita();
	Thread waitThread = new Thread(new WaitThread());
	waitThread.start();
	hilo2.start();
	hilo1.start();
    }

    public static void getDatos() throws SQLException, IOException
    {
	Datos.getInstance().removeAll();
	DB.getInstance().getDatos();
	DB.getInstance().getAdicionales();
	DB.getInstance().crearArchivo();
    }
}
