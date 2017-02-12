package formularios;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import santa_rita.Datos;
import utilidades.Apariencia;

public class Adicionista extends JPanel
{
    private Panel_Items platos_calientes;
    private Panel_Items platos_frios;
    private Panel_Items platos_plancha;
    private Panel_Items platos_frituras;
    private Panel_Items platos_ensaladas;
    private Panel_Items platos_otros;
    private Panel_Items platos_celiacos;
    private Panel_Items platos_postres;
    private JButton btnConfirmar;

    public Adicionista()
    {
	setBackground(Apariencia.background_amarillo);
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	JTabbedPane pestanias = new JTabbedPane(JTabbedPane.LEFT);
	// pestanias.setFont(Fuentes.labels);

	platos_calientes = new Panel_Items("Platos calientes");
	pestanias.addTab("<html><body><table width='200'>Platos calientes</table></body></html>", null,
		platos_calientes, "Platos calientes");

	platos_frios = new Panel_Items("Platos fríos");
	pestanias.addTab("<html><body><table width='200'>Platos fríos</table></body></html>", null, platos_frios,
		"Platos fríos");

	platos_plancha = new Panel_Items("A la plancha");
	pestanias.addTab("<html><body><table width='200'>Platos a la plancha</table></body></html>", null,
		platos_plancha, "Platos a la plancha");

	platos_frituras = new Panel_Items("Frituras");
	pestanias.addTab("<html><body><table width='200'>Frituras</table></body></html>", null, platos_frituras,
		"Frituras");

	platos_ensaladas = new Panel_Items("Ensaladas");
	pestanias.addTab("<html><body><table width='200'>Ensaladas</table></body></html>", null, platos_ensaladas,
		"Ensaladas");

	platos_otros = new Panel_Items("Otros platos");
	pestanias.addTab("<html><body><table width='200'>Otros platos</table></body></html>", null, platos_otros,
		"Otros platos");

	platos_celiacos = new Panel_Items("Celiaco");
	pestanias.addTab("<html><body><table width='200'>Platos para celíacos</table></body></html>", null,
		platos_celiacos, "Platos para celíacos");

	platos_postres = new Panel_Items("Postres");
	pestanias.addTab("<html><body><table width='200'>Postres</table></body></html>", null, platos_postres,
		"Postres");

	btnConfirmar = new JButton("Confirmar pedido");
	btnConfirmar.setFont(btnConfirmar.getFont().deriveFont(Font.BOLD));
	btnConfirmar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		platos_calientes.getPedidos();
		platos_frios.getPedidos();
		platos_plancha.getPedidos();
		platos_frituras.getPedidos();
		platos_ensaladas.getPedidos();
		platos_otros.getPedidos();
		platos_celiacos.getPedidos();
		platos_postres.getPedidos();
		print();
	    }
	});
	add(btnConfirmar);
	// Agregar objeto JTabbedPane al contenedor
	add(pestanias);
    }

    public void print()
    {
	Datos.getInstance().imprimirPedido();
	try
	{
	    File fileToPrint = new File("archivo.txt");
	    Desktop.getDesktop().print(fileToPrint);
	} catch (Exception e)
	{
	    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
	    e.printStackTrace();
	}
	Datos.getInstance().remove();
	clear();
    }

    private void clear()
    {
	platos_calientes.clear();
	platos_frios.clear();
	platos_plancha.clear();
	platos_frituras.clear();
	platos_ensaladas.clear();
	platos_otros.clear();
	platos_celiacos.clear();
	platos_postres.clear();
    }
}
