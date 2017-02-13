package santa_rita;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.microedition.io.StreamConnection;
import javax.swing.JOptionPane;

public class ProcessConnectionThread implements Runnable
{
    private StreamConnection mConnection;

    public ProcessConnectionThread(StreamConnection connection)
    {
	mConnection = connection;
    }

    @Override
    public void run()
    {
	try
	{
	    InputStream inputStream = mConnection.openInputStream();
	    System.out.println("waiting for input");
	    BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));
	    String line = "";
	    if ((line = bReader.readLine()) != null)
	    {
		System.out.println(line);
	    }
	    String productos[] = line.split("##");
	    ArrayList<Producto> pps = new ArrayList<Producto>();
	    int i = 0;
	    for (i = 0; i < productos.length; i++)
	    {
		String campos[] = productos[i].split(";");
		Producto producto = new Producto();
		Item item = Datos.getInstance().searchItem(Integer.parseInt(campos[0]));
		producto.setItem(item);
		if (campos[1].equals("1/2"))
		{
		    producto.setCantidad(1);
		    producto.setMedia(true);
		} else
		{
		    producto.setCantidad(Integer.parseInt(campos[1]));
		}
		producto.setTiempo(false);

		if (!campos[2].equals("0"))
		{
		    String adicionales[] = campos[2].split("@");
		    int z = 0;
		    for (z = 0; z < adicionales.length; z++)
		    {
			Item adicional = Datos.getInstance().searchAdicional(Integer.parseInt(adicionales[z]));
			if (!adicional.getDescripcion().equals("Solo"))
			    producto.addAdicionales(adicional.getCodigo() + "\t" + adicional.getDescripcion());
		    }
		}
		pps.add(producto);
	    }
	    Datos.getInstance().imprimirPPS(pps);
	    try
	    {
		File fileToPrint = new File("archivoandroid.txt");
		Desktop.getDesktop().print(fileToPrint);
	    } catch (Exception e)
	    {
		JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		e.printStackTrace();
	    }
	} catch (Exception e)
	{
	    System.out.println("Error processThread. " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
