package santa_rita;

import java.util.ArrayList;

public class Item
{
    private boolean selected;
    private int codigo;
    private String descripcion;
    private ArrayList<String> adicionales;
    private float precio;
    private String categoria;

    public Item(int codigo, String descripcion, float precio, String categoria)
    {
	this.selected = false;
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.adicionales = new ArrayList<String>();
	this.precio = precio;
	this.categoria = categoria;
    }

    public Item()
    {
    }

    public boolean isSelected()
    {
	return selected;
    }

    public int getId()
    {
	return codigo;
    }

    public String getDescripcion()
    {
	return descripcion;
    }

    public ArrayList<String> getAdicionales()
    {
	return adicionales;
    }

    public void addAdicionales(String adicional)
    {
	this.adicionales.add(adicional);
    }

    public void addAdicionales(ArrayList<String> adicionales)
    {
	this.adicionales.addAll(adicionales);
    }

    public float getPrecio()
    {
	return precio;
    }

    public String getCategoria()
    {
	return categoria;
    }

    public void setSelected(boolean valor)
    {
	this.selected = valor;
    }

    public void setCodigo(int codigo)
    {
	this.codigo = codigo;
    }

    public void setDescripcion(String descripcion)
    {
	this.descripcion = descripcion;
    }

    public void setAdicionales(ArrayList<String> adicionales)
    {
	this.adicionales = adicionales;
    }

    public void setPrecio(float precio)
    {
	this.precio = precio;
    }

    public void setCategoria(String categoria)
    {
	this.categoria = categoria;
    }

    @Override
    public String toString()
    {
	return descripcion;
    }
}
