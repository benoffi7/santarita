package santa_rita;

import java.util.ArrayList;

public class ProductoPedido
{
    private String cantidad;
    private String descripcion = new String();
    private ArrayList<String> adicionalesPedidos = new ArrayList<String>();
    private String tiempo = new String();
    private String categoria = new String();
    private String media = new String();

    public String getMedia()
    {
	return media;
    }

    public void setMedia(String media)
    {
	this.media = media;
    }

    public String getCategoria()
    {
	return categoria;
    }

    public void setCategoria(String categoria)
    {
	this.categoria = categoria;
    }

    public ProductoPedido()
    {
	descripcion = "";
	cantidad = "1";
	tiempo = "";
    }

    public String getDescripcion()
    {
	return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
	this.descripcion = descripcion;
    }

    public String getCantidad()
    {
	return cantidad;
    }

    public void setCantidad(String cantidad)
    {
	this.cantidad = cantidad;
    }

    public String getTiempo()
    {
	return tiempo;
    }

    public void setTiempo(String tiempo)
    {
	this.tiempo = tiempo;
    }

    public boolean tieneOpcional()
    {
	if (adicionalesPedidos.size() == 0)
	{
	    return false;
	} else
	{
	    return true;
	}
    }

    public ArrayList<String> getAdicionalesPedidos()
    {
	return adicionalesPedidos;
    }

    public void setAdicionalesPedidos(ArrayList<String> adicionalesPedidos)
    {
	this.adicionalesPedidos = adicionalesPedidos;
    }
}
