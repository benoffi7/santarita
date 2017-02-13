package componentes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utilidades.Apariencia;

public class Btn_Adicionales extends JButton
{
    private JFrame panel;
    private ArrayList<ComboAdicionales> combos;
    private ArrayList<String> adicionales;

    public Btn_Adicionales()
    {
	setText("Seleccionar adicionales..");
	adicionales = new ArrayList<String>();
    }

    public void showPanel(int cantidad)
    {
	combos = new ArrayList<>();
	adicionales.clear();
	panel = new JFrame();
	panel.setSize(500, 700);
	panel.getContentPane().setBackground(Apariencia.background_amarillo);
	panel.setLocationRelativeTo(null);
	panel.setLayout(new GridLayout(10, 1, 1, 1));

	for (int i = 1; i <= cantidad; i++)
	{
	    panel.add(new JLabel("Producto " + Integer.toString(i)));
	    ComboAdicionales combo = new ComboAdicionales();
	    combos.add(combo);
	    panel.add(combo);
	}
	JButton confirmar = new JButton("Confirmar adicionales");
	confirmar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		for (ComboAdicionales combo : combos)
		{
		    if (!combo.getSelected().equals("--- - Sin adicional"))
			adicionales.add(combo.getSelected());
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

    public void clear()
    {
	adicionales.clear();
    }
}
