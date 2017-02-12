package formularios;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import componentes.AutoCompleteTextField;
import santa_rita.DB;
import santa_rita.Datos;
import santa_rita.Item;
import santa_rita.Principal;
import utilidades.Apariencia;

public class Panel_Baja extends JPanel
{
    private AutoCompleteTextField busqueda;
    private JLabel lblCodigo;
    private JTextField codigo;
    private JLabel lblDescripcion;
    private JTextField descripcion;
    private JLabel lblPrecio;
    private JTextField precio;
    private JLabel lblCate;
    private JComboBox<String> categoria;
    private JCheckBox adicional;
    private JButton btnRefrescar;
    private JButton btnModificar;
    private JButton btnEliminar;

    public Panel_Baja()
    {
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(d.width, d.height);
	setLayout(new GridLayout(25, 3, 0, 0));
	setBackground(Apariencia.background_amarillo);
	FormLayout fl_panel = new FormLayout(
		new ColumnSpec[] { ColumnSpec.decode("right:300px"), ColumnSpec.decode("left:3dlu"),
			ColumnSpec.decode("left:300px"), ColumnSpec.decode("left:3dlu"),
			ColumnSpec.decode("left:300px"), },
		new RowSpec[] { RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"),
			FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC,
			RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"),
			FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC,
			RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"),
			FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), });
	setLayout(fl_panel);

	busqueda = new AutoCompleteTextField("Por ejemplo: Arroz con Mejillones");
	add(busqueda, "1, 1");

	JButton btnCancelar = new JButton("Cancelar");
	add(btnCancelar, "3, 1");
	btnCancelar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		clear();
		busqueda.setText("");
		busqueda.setEnabled(true);
	    }
	});

	btnRefrescar = new JButton("Refrescar los cambios");
	add(btnRefrescar, "5,1");
	btnRefrescar.setEnabled(false);
	btnRefrescar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    Principal.restart();
		} catch (Exception e1)
		{
		    JOptionPane.showMessageDialog(Panel_Baja.this, e1.getMessage());
		}
	    }
	});

	lblCodigo = new JLabel("Código: ");
	add(lblCodigo, "1, 3");
	lblCodigo.setVisible(false);

	codigo = new JTextField(6);
	codigo.setVisible(false);
	codigo.addKeyListener(new KeyAdapter()
	{
	    public void keyTyped(KeyEvent e)
	    {
		char caracter = e.getKeyChar();
		if (!Character.isDigit(caracter) || (codigo.getText().length() > 6))
		{
		    e.consume();
		}
	    }
	});
	add(codigo, "3, 3");
	codigo.setVisible(false);

	lblDescripcion = new JLabel("Descripción: ");
	lblDescripcion.setVisible(false);
	add(lblDescripcion, "1, 5");

	descripcion = new JTextField();
	descripcion.setColumns(20);
	descripcion.addKeyListener(new KeyAdapter()
	{
	    public void keyTyped(KeyEvent e)
	    {
		char caracter = e.getKeyChar();
		if (Character.isDigit(caracter))
		{
		    e.consume();
		}
	    }
	});
	add(descripcion, "3, 5");
	descripcion.setVisible(false);

	lblPrecio = new JLabel("Precio: ");
	add(lblPrecio, "1, 7");
	lblPrecio.setVisible(false);

	precio = new JTextField(10);
	precio.addKeyListener(new KeyAdapter()
	{
	    public void keyTyped(KeyEvent e)
	    {
		char caracter = e.getKeyChar();
		if ((!Character.isDigit(caracter)) || (precio.getText().length() > 6))
		{
		    e.consume();
		}
	    }
	});
	add(precio, "3, 7");
	precio.setVisible(false);

	lblCate = new JLabel("Categoría");
	add(lblCate, "1, 9");
	lblCate.setVisible(false);

	String[] cate = { "Platos calientes", "Platos fríos", "Frituras", "A la plancha", "Ensaladas", "Otros platos",
		"Postres", "Salsas" };
	categoria = new JComboBox<String>(cate);
	add(categoria, "3, 9");
	categoria.setVisible(false);

	adicional = new JCheckBox();
	adicional.setText("Adicional");
	add(adicional, "3, 11");
	adicional.setVisible(false);

	busqueda.addKeyListener(new KeyListener()
	{
	    @Override
	    public void keyReleased(KeyEvent e)
	    {
		int code = e.getKeyCode();

		switch (code)
		{
		case KeyEvent.VK_ENTER:
		    busqueda.setEnabled(false);
		    Item nuevo = busqueda.getItemSeleccionado();
		    codigo.setText(Integer.toString(nuevo.getCodigo()));
		    descripcion.setText(nuevo.getDescripcion());
		    precio.setText(Integer.toString(nuevo.getPrecio()));
		    categoria.setSelectedItem(nuevo.getCategoria());
		    adicional.setSelected(nuevo.isAdicional());
		    lblCodigo.setVisible(true);
		    codigo.setVisible(true);
		    lblDescripcion.setVisible(true);
		    descripcion.setVisible(true);
		    lblPrecio.setVisible(true);
		    precio.setVisible(true);
		    lblCate.setVisible(true);
		    categoria.setVisible(true);
		    adicional.setVisible(true);
		    btnModificar.setVisible(true);
		    btnEliminar.setVisible(true);
		    break;
		}
	    }

	    @Override
	    public void keyPressed(KeyEvent e)
	    {
	    }

	    @Override
	    public void keyTyped(KeyEvent arg0)
	    {
	    }
	});

	btnModificar = new JButton("Modificar");
	add(btnModificar, "1, 13");
	btnModificar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		if (!complete())
		{
		    JOptionPane.showMessageDialog(Panel_Baja.this, "Completar todos los campos");
		} else if (busqueda.getIdSeleccionado() != Integer.parseInt(codigo.getText()))
		{
		    if (!verificarCodigo(Integer.parseInt(codigo.getText())))
		    {
			modificar();
			btnRefrescar.setEnabled(true);
			try
			{
			    Principal.getDatos();
			} catch (SQLException | IOException e1)
			{
			    JOptionPane.showMessageDialog(Panel_Baja.this, "Error el actualizar la base de datos");
			}

		    } else
			JOptionPane.showMessageDialog(Panel_Baja.this, "Codigo de producto repetido");
		} else
		{
		    modificar();
		    btnRefrescar.setEnabled(true);
		    try
		    {
			Principal.getDatos();
		    } catch (SQLException | IOException e1)
		    {
			JOptionPane.showMessageDialog(Panel_Baja.this, "Error el actualizar la base de datos");
		    }
		}
	    }
	});
	btnModificar.setVisible(false);

	btnEliminar = new JButton("Eliminar");
	add(btnEliminar, "3, 13");
	btnEliminar.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		eliminar();
		try
		{
		    Principal.getDatos();
		} catch (SQLException | IOException e1)
		{
		    JOptionPane.showMessageDialog(Panel_Baja.this, "Error el actualizar la base de datos");
		}
	    }
	});
	btnEliminar.setVisible(false);

	setVisible(true);
    }

    protected void eliminar()
    {
	try
	{
	    if (DB.getInstance().delete(busqueda.getIdSeleccionado()))
	    {
		clear();
		JOptionPane.showMessageDialog(Panel_Baja.this, "Producto eliminado correctamente");
	    }
	} catch (SQLException e1)
	{
	    JOptionPane.showMessageDialog(Panel_Baja.this, "Error al eliminar el producto");
	}
    }

    protected void modificar()
    {
	Item nuevo = new Item();
	nuevo.setCodigo(Integer.parseInt(codigo.getText()));
	nuevo.setDescripcion(descripcion.getText());
	nuevo.setPrecio(Integer.parseInt(precio.getText()));
	nuevo.setCategoria(categoria.getSelectedItem().toString());
	nuevo.setAdicional(nuevo.isAdicional());
	try
	{
	    if (DB.getInstance().modify(nuevo, busqueda.getIdSeleccionado()))
	    {
		clear();
		JOptionPane.showMessageDialog(Panel_Baja.this, "Producto modificado correctamente");
	    }
	} catch (SQLException e1)
	{
	    JOptionPane.showMessageDialog(Panel_Baja.this, "Error al modificar el producto");
	}
    }

    private boolean complete()
    {
	if (codigo.getText().equals(""))
	{
	    return false;
	}
	if (descripcion.getText().equals(""))
	{
	    return false;
	}
	if (precio.getText().equals(""))
	{
	    return false;
	}
	return true;
    }

    private void clear()
    {
	codigo.setText("");
	descripcion.setText("");
	precio.setText("");
	categoria.setSelectedIndex(0);
	adicional.setSelected(false);
	lblCodigo.setVisible(false);
	codigo.setVisible(false);
	lblDescripcion.setVisible(false);
	descripcion.setVisible(false);
	lblPrecio.setVisible(false);
	precio.setVisible(false);
	lblCate.setVisible(false);
	categoria.setVisible(false);
	adicional.setVisible(false);
	btnModificar.setVisible(false);
	btnEliminar.setVisible(false);
	busqueda.setText("");
	busqueda.setEnabled(true);
    }

    private boolean verificarCodigo(int cod)
    {
	if (Datos.getInstance().searchItem(cod) == null)
	    return false;
	else
	    return true;
    }
}
