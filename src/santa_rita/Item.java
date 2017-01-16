package santa_rita;

public class Item
{
    private boolean selected;
    private int codigo;
    private String descripcion;
    private float precio;
    private String categoria;

    public Item(int codigo, String descripcion, float precio, String categoria)
    {
	this.selected = false;
	this.codigo = codigo;
	this.descripcion = descripcion;
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
