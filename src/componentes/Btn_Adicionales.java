package componentes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utilidades.Apariencia;

public class Btn_Adicionales extends JButton
{
    private JFrame panel;
    private ArrayList<JComboBox<String>> combos;
    private ArrayList<String> adicionales;

    public Btn_Adicionales()
    {
	setText("Seleccionar adicionales..");
    }

    public void showPanel(int cantidad)
    {
	combos = new ArrayList<>();
	adicionales = new ArrayList<String>();
	panel = new JFrame();
	panel.setSize(700, 700);
	panel.getContentPane().setBackground(Apariencia.background_amarillo);
	panel.setLocationRelativeTo(null);
	panel.setLayout(new GridLayout(10, 1, 1, 1));

	for (int i = 1; i <= cantidad; i++)
	{
	    panel.add(new JLabel("Producto " + Integer.toString(i)));
	    JComboBox combo = new JComboBox<String>();
	    combo.setModel(new DefaultComboBoxModel(new String[] { "Salsa de verdeo", "Manteca" }));
	    combos.add(combo);
	    panel.add(combo);
	}
	JButton confirmar = new JButton("Confirmar adicionales");
	confirmar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		for (int i = 0; i < combos.size(); i++)
		{
		    adicionales.add(combos.get(i).getSelectedItem().toString());
		}
		panel.dispose();
	    }
	});
	panel.add(confirmar);
	panel.setVisible(true);
    }

    public ArrayList<String> getAdicionales()
    {
	return adicionales;
    }
}
