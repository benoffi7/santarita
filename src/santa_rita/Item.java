package santa_rita;

public class Item
{
    private boolean selected;
    private int codigo;
    private String descripcion;
    private int precio;
    private String categoria;
    private boolean adicional;

    public Item(int codigo, String descripcion, int precio, String categoria, boolean adicional)
    {
	this.selected = false;
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;
	this.adicional = adicional;
    }

    public Item()
    {
    }

    public boolean isSelected()
    {
	return selected;
    }

    public int getCodigo()
    {
	return codigo;
    }

    public String getDescripcion()
    {
	return descripcion;
    }

    public int getPrecio()
    {
	return precio;
    }

    public String getCategoria()
    {
	return categoria;
    }

    public boolean isAdicional()
    {
	return adicional;
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

    public void setPrecio(int precio)
    {
	this.precio = precio;
    }

    public void setCategoria(String categoria)
    {
	this.categoria = categoria;
    }

    public void setAdicional(boolean valor)
    {
	adicional = valor;
    }

    @Override
    public String toString()
    {
	return descripcion;
    }
}
