package componentes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import santa_rita.Item;
import santa_rita.Producto;
import utilidades.Apariencia;

public class Item_De_Compra extends JPanel
{
    private Item item;
    private JCheckBox descripcion;
    private JComboBox<Integer> cantidad;
    private JRadioButton btn_media_porcion;
    private Btn_Adicionales btn_adicionales;
    private JRadioButton btn_despues;

    public Item_De_Compra(Item prod)
    {
	setBackground(Apariencia.background_amarillo);

	item = prod;
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 250, 40, 40, 75, 100 };
	gridBagLayout.rowHeights = new int[] { 30, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
	gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	setLayout(gridBagLayout);
	descripcion = new JCheckBox();
	descripcion.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		item.setSelected(descripcion.isSelected());
	    }
	});
	descripcion.setHorizontalAlignment(SwingConstants.LEFT);
	descripcion.setText(item.getId() + " - " + item.getDescripcion());
	GridBagConstraints gbc_descripcion = new GridBagConstraints();
	gbc_descripcion.fill = GridBagConstraints.BOTH;
	gbc_descripcion.insets = new Insets(0, 0, 0, 5);
	gbc_descripcion.gridx = 0;
	gbc_descripcion.gridy = 0;
	add(descripcion, gbc_descripcion);

	cantidad = new JComboBox<Integer>();
	cantidad.setMaximumRowCount(12);
	cantidad.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	cantidad.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		descripcion.setSelected(true);
		item.setSelected(descripcion.isSelected());
	    }
	});
	GridBagConstraints gbc_cantidad = new GridBagConstraints();
	gbc_cantidad.fill = GridBagConstraints.VERTICAL;
	gbc_cantidad.insets = new Insets(0, 0, 0, 5);
	gbc_cantidad.gridx = 1;
	gbc_cantidad.gridy = 0;
	add(cantidad, gbc_cantidad);

	btn_media_porcion = new JRadioButton("1/2");
	GridBagConstraints gbc_btn_media_porcion = new GridBagConstraints();
	gbc_btn_media_porcion.fill = GridBagConstraints.BOTH;
	gbc_btn_media_porcion.insets = new Insets(0, 0, 0, 5);
	gbc_btn_media_porcion.gridx = 2;
	gbc_btn_media_porcion.gridy = 0;
	add(btn_media_porcion, gbc_btn_media_porcion);

	btn_despues = new JRadioButton("Despu\u00E9s");
	btn_despues.setHorizontalAlignment(SwingConstants.LEFT);
	GridBagConstraints gbc_btn_despues = new GridBagConstraints();
	gbc_btn_despues.fill = GridBagConstraints.BOTH;
	gbc_btn_despues.insets = new Insets(0, 0, 0, 5);
	gbc_btn_despues.gridx = 3;
	gbc_btn_despues.gridy = 0;
	add(btn_despues, gbc_btn_despues);

	btn_adicionales = new Btn_Adicionales();
	btn_adicionales.setText("Adicionales..");

	btn_adicionales.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		btn_adicionales.showPanel((Integer) cantidad.getSelectedItem());
	    }
	});

	GridBagConstraints gbc_btn_adicionales = new GridBagConstraints();
	gbc_btn_adicionales.fill = GridBagConstraints.BOTH;
	gbc_btn_adicionales.insets = new Insets(0, 0, 0, 5);
	gbc_btn_adicionales.gridx = 4;
	gbc_btn_adicionales.gridy = 0;
	add(btn_adicionales, gbc_btn_adicionales);
    }

    public boolean isSelected()
    {
	return item.isSelected();
    }

    public void setSelected(boolean valor)
    {
	item.setSelected(valor);
    }

    public Producto getSelected()
    {
	Producto seleccionado = new Producto();
	seleccionado.setItem(item);
	seleccionado.setCantidad((Integer) cantidad.getSelectedItem());
	seleccionado.setMedia(btn_media_porcion.isSelected());
	seleccionado.setTiempo(btn_despues.isSelected());
	seleccionado.addAdicionales(btn_adicionales.getAdicionales());
	return seleccionado;
    }
}
