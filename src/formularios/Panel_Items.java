package formularios;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import componentes.Item_De_Compra;
import santa_rita.Datos;
import santa_rita.Item;
import utilidades.Apariencia;

public class Panel_Items extends JPanel
{
    private ArrayList<Item_De_Compra> items_adicionista;
    private String propiedad_categoria;

    public Panel_Items(String categoria)
    {
	items_adicionista = new ArrayList<Item_De_Compra>();
	propiedad_categoria = categoria;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(d.width, d.height);
	setLayout(new GridLayout(25, 3, 0, 0));
	setBackground(Apariencia.background_amarillo);
	setVisible(true);

	addComponents();
    }

    private void addComponents()
    {
	for (Item cada_producto : Datos.getInstance().getItems())
	{
	    if (cada_producto.getCategoria().equals(propiedad_categoria))
	    {
		Item_De_Compra item_panel = new Item_De_Compra(cada_producto);
		items_adicionista.add(item_panel);
		add(item_panel);
	    }
	}
    }

    public void getPedidos()
    {
	for (Item_De_Compra item : items_adicionista)
	{
	    if (item.isSelected())
	    {
		Datos.getInstance().addProducto_Pedido(item.getSelected());
	    }
	}
    }
}