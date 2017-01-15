package componentes;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel
{
    public Panel()
    {
	setSize(500, 500);
	setLayout(new GridLayout(20, 1, 1, 1));

	JLabel lblProducto = new JLabel("Producto 1");
	super.add(lblProducto);
	JComboBox comboBox = new JComboBox();
	add(comboBox);
	JLabel lblProducto_1 = new JLabel("Producto 2");
	add(lblProducto_1);
	setVisible(true);
    }
}
