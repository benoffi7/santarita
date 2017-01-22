package formularios;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import utilidades.Apariencia;

public class Settings extends JPanel
{
    private Panel_Alta aProducto;
    private Panel_Baja bmProducto;

    public Settings()
    {
	setBackground(Apariencia.background_amarillo);
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	JTabbedPane pestanias = new JTabbedPane(JTabbedPane.LEFT);
	// pestanias.setFont(Fuentes.labels);

	// Primera pestaña
	aProducto = new Panel_Alta();
	pestanias.addTab("<html><body><table width='200'>Insertar un nuevo producto</table></body></html>", aProducto);

	// Segunda pestaña
	bmProducto = new Panel_Baja();
	pestanias.addTab("<html><body><table width='200'>Modificar o eliminar un producto</table></body></html>",
		bmProducto);

	add(pestanias);
	setVisible(true);
    }
}
