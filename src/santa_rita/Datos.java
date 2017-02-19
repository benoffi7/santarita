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
    // Pedido para llevar
    private boolean paraLlevar;

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
	    if (item.getCodigo() == codigo)
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

    public Item searchAdicional(int codigo)
    {
	Item retorno = null;
	for (Item item : items)
	{
	    if (item.getCodigo() == codigo)
	    {
		retorno = item;
	    }
	}
	return retorno;
    }

    public void addProducto_Pedido(Producto producto_pedido)
    {
	pedido_cliente.add(producto_pedido);
    }

    public ArrayList<Producto> getProductos_Pedidos()
    {
	return pedido_cliente;
    }

    public boolean isParaLlevar()
    {
	return paraLlevar;
    }

    public void setParaLlevar(boolean paraLlevar)
    {
	this.paraLlevar = paraLlevar;
    }

    public void remove()
    {
	pedido_cliente.clear();
    }

    public void removeAll()
    {
	items.clear();
	adicionales.clear();
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
	    if (paraLlevar)
		print.write("\tPEDIDO PARA LLEVAR\r\n");
	    print.write("\t" + fecha.toLocaleString() + "\r\n\r\n");
	    print.write(" Cant\tCod\tDescripción\r\n\r\n");
	    for (Producto producto : pedido_cliente)
	    {
		if (producto.isMedia())
		    print.write(" $" + producto.getPrecio_media());
		else
		    print.write("  " + producto.getCantidad() + " ");

		print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		for (String ad : producto.getAdicionales())
		{
		    print.write("\r\n\t" + ad);
		}
		if (producto.isParaDespues())
		{
		    print.write("\r\n\t\tPARA DESPUES");
		}
		if (producto.isCeliaco())
		{
		    print.write("\r\n\t\tCELIACO");
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
	    print.write(" Cant\tCod\tDescripción\r\n\r\n");
	    for (Producto producto : pedido_cliente)
	    {
		if (producto.isMedia())
		    print.write(" $" + producto.getPrecio_media());
		else
		    print.write("  " + producto.getCantidad() + " ");

		print.write("\t" + producto.getCodigo() + "\t" + producto.getDescripcion());
		for (String ad : producto.getAdicionales())
		{
		    print.write("\r\n\t" + ad);
		}
		if (producto.isParaDespues())
		{
		    print.write("\r\n\t\tPARA DESPUES");
		}
		if (producto.isCeliaco())
		{
		    print.write("\r\n\t\tCELIACO");
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
