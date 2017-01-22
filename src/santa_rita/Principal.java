package santa_rita;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.UIManager;

import formularios.Santa_Rita;

public class Principal
{
    private static Monitor hilo1;
    private static Santa_Rita hilo2;
    private static Thread hilo3;

    public static void main(String[] args) throws Exception, Exception, Exception, Exception
    {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	getDatos();
	hilo1 = new Monitor();
	hilo2 = new Santa_Rita();
	hilo3 = new Thread(new WaitThread());
	hilo3.start();
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

    public static void restart() throws Exception
    {
	hilo2.dispose();
	hilo2 = new Santa_Rita();
    }
}
