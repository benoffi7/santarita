package santa_rita;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Datos
{
    private static Datos instancia;
    // Cargados de la base de datos
    private ArrayList<Item> items;
    // Cargados desde la base de datos
    private ArrayList<Item> adicionales;
    // Seleccionados en el panel
    private ArrayList<Producto> pedido_cliente;

    public Datos()
    {
	items = new ArrayList<Item>();
	adicionales = new ArrayList<Item>();
	pedido_cliente = new ArrayList<Producto>();
    }

    public static Datos getInstance()
    {
	if (instancia == null)
	    instancia = new Datos();
	return instancia;
    }

    public void addItem(Item item)
    {
	items.add(item);
    }

    public ArrayList<Item> getItems()
    {
	return items;
    }

    public Item searchItem(int codigo)
    {
	Item retorno = null;
	for (Item item : items)
	{
	    if (item.getId() == codigo)
	    {
		retorno = item;
	    }
	}
	return retorno;
    }

    public Item searchAdicional(int codigo)
    {
	Item retorno = null;
	for (Item item : items)
	{
	    if (item.getId() == codigo)
	    {
		retorno = item;
	    }
	}
	return retorno;
    }

    public void addAdicional(Item item)
    {
	adicionales.add(item);
    }

    public ArrayList<Item> getAdicionales()
    {
	return adicionales;
    }

    public void addProducto_Pedido(Producto producto_pedido)
    {
	pedido_cliente.add(producto_pedido);
    }

    public ArrayList<Producto> getProductos_Pedidos()
    {
	return pedido_cliente;
    }

    public void remove()
    {
	pedido_cliente.clear();
    }

    public void imprimirPedido()
    {
	Date fecha = new Date();
	PrintWriter print = null;
	File fichero = new File("archivo.txt");
	try
	{
	    print = new PrintWriter(new FileWriter(fichero));
	    print.write("\tMARISQUERIA SANTA RITA\r\n");
	    print.write("\t" + fecha.toLocaleString() + "\r\n\r\n");
	    print.write(" Cant\tCod\tDescripci�n\r\n\r\n");
	    for (Producto producto : pedido_cliente)
	    {
		if (producto.isMedia())
		{
		    print.write("  1/2 ");
		    print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		} else
		{
		    print.write("  " + producto.getCantidad() + " ");
		    print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		    int cant = 0;
		    while (cant < producto.getCantidad())
		    {
			print.write("\r\n\t\t" + producto.getAdicionales().get(cant));
			cant++;
		    }
		}
		if (producto.isParaDespues())
		{
		    print.write("\r\n\t\tPARA DESPUES");
		}
		print.write("\r\n----------------------------------\r\n");
	    }
	} catch (IOException e)
	{
	    e.printStackTrace();
	} finally
	{
	    print.close();
	}
    }

    public void imprimirPPS(ArrayList<Producto> pedido_cliente)
    {
	Date fecha = new Date();
	PrintWriter print = null;
	File fichero = new File("archivoandroid.txt");
	try
	{
	    print = new PrintWriter(new FileWriter(fichero));
	    print.write("\tMARISQUERIA SANTA RITA\r\n");
	    print.write("\t" + fecha.toLocaleString() + "\r\n\r\n");
	    print.write(" Cant\tCod\tDescripci�n\r\n\r\n");
	    for (Producto producto : pedido_cliente)
	    {
		if (producto.isMedia())
		{
		    print.write("  1/2 ");
		    print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		} else
		{
		    print.write("  " + producto.getCantidad() + " ");
		    print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		    int cant = 0;
		    while (cant < producto.getCantidad())
		    {
			print.write("\r\n\t\t" + producto.getAdicionales().get(cant));
			cant++;
		    }
		}
		if (producto.isParaDespues())
		{
		    print.write("\r\n\t\tPARA DESPUES");
		}
		print.write("\r\n----------------------------------\r\n");
	    }
	} catch (IOException e)
	{
	    e.printStackTrace();
	} finally
	{
	    print.close();
	}
    }
}