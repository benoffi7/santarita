package formularios;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import santa_rita.Datos;
import santa_rita.Item;
import santa_rita.Monitor;

public class Santa_Rita extends JFrame implements Runnable
{
    private Thread hilo;
    private Adicionista panel_adicionista;
    private Settings panel_settings;
   
    public Santa_Rita() throws Exception
    {
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(d.width, d.height);
	// setUndecorated(true);

	JTabbedPane pestanias = new JTabbedPane();
	// pestanias.setFont(Fuentes.labels);

	// Primera pestaña
	panel_adicionista = new Adicionista();
	pestanias.addTab("<html><body><table width='200'>Realizar pedido</table></body></html>", null,
		panel_adicionista, "Realizar un nuevo pedido");

	// Segunda pestaña
	panel_settings = new Settings();
	pestanias.addTab("<html><body><table width='200'>Configuraciones</table></body></html>", null, panel_settings,
		"Alta, baja y modificación de productos");

	// Agregar objeto JTabbedPane al contenedor
	getContentPane().add(pestanias);
	setExtendedState(MAXIMIZED_BOTH);
	setVisible(true);
    }

    @Override
    public void run()
    {
	
    }
    
    public void start () {
	System.out.println("Iniciando aplicacion...");
	if (hilo == null) {
	    hilo = new Thread ();
	    hilo.start();
	}
    }
}
