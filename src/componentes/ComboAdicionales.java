package componentes;

import java.util.ArrayList;

import javax.swing.JComboBox;

import santa_rita.Datos;
import santa_rita.Item;

public class ComboAdicionales extends JComboBox<String>
{
    public ComboAdicionales()
    {
	ArrayList<Item> ad = Datos.getInstance().getAdicionales();
	addItem("--- - Sin adicional");
	for (Item item : ad)
	{
	    super.addItem(item.getId() + " - " + item.getDescripcion());
	}
	setMaximumRowCount(15);
    }

    public String getSelected()
    {
	return getSelectedItem().toString();
    }
}
