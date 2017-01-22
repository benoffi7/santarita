package santa_rita;

import java.util.ArrayList;

public class Producto
{
    private Item item;
    private int cantidad;
    private boolean media_porcion;
    private boolean para_despues;
    private ArrayList<String> adicionales;

    public Producto()
    {
	this.adicionales = new ArrayList<String>();
    }

    public Producto(Item item, int cantidad, boolean media, boolean tiempo, String categoria)
    {
	this.item = item;
	this.cantidad = cantidad;
	this.media_porcion = media;
	this.para_despues = tiempo;
	this.adicionales = new ArrayList<String>();
    }

    public int getCodigo()
    {
	return item.getCodigo();
    }

    public String getDescripcion()
    {
	return item.getDescripcion();
    }

    public float getPrecio()
    {
	return item.getPrecio();
    }

    public void setItem(Item item)
    {
	this.item = item;
    }

    public int getCantidad()
    {
	return cantidad;
    }

    public void setCantidad(int cantidad)
    {
	this.cantidad = cantidad;
    }

    public boolean isMedia()
    {
	return media_porcion;
    }

    public void setMedia(boolean media)
    {
	this.media_porcion = media;
    }

    public boolean isParaDespues()
    {
	return para_despues;
    }

    public void setTiempo(boolean para_despues)
    {
	this.para_despues = para_despues;
    }

    public ArrayList<String> getAdicionales()
    {
	return adicionales;
    }

    public void addAdicionales(String adicional)
    {
	this.adicionales.add(adicional);
    }

    public void addAdicionales(ArrayList<String> adicional)
    {
	this.adicionales.addAll(adicional);
    }
}
