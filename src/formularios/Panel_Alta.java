package formularios;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import santa_rita.DB;
import santa_rita.Datos;
import santa_rita.Item;
import santa_rita.Principal;
import utilidades.Apariencia;

public class Panel_Alta extends JPanel
{
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

    public Panel_Alta()
    {
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(d.width, d.height);
	FormLayout fl_panel = new FormLayout(
		new ColumnSpec[] { ColumnSpec.decode("right:300px"), ColumnSpec.decode("left:3dlu"),
			ColumnSpec.decode("left:300px"), },
		new RowSpec[] { RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"),
			FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC,
			RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"),
			FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC,
			RowSpec.decode("50px"), FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("50px"), });
	setLayout(fl_panel);
	setBackground(Apariencia.background_amarillo);

	btnRefrescar = new JButton("Refrescar los cambios");
	add(btnRefrescar, "3, 3");
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
		    JOptionPane.showMessageDialog(Panel_Alta.this, e1.getMessage());
		}
	    }
	});

	lblCodigo = new JLabel("Código: ");
	add(lblCodigo, "1, 5");

	codigo = new JTextField();
	add(codigo, "3, 5");
	codigo.setColumns(10);
	codigo.addKeyListener(new KeyAdapter()
	{
	    public void keyTyped(KeyEvent e)
	    {
		char caracter = e.getKeyChar();
		if (!Character.isDigit(caracter))
		{
		    e.consume();
		}
	    }
	});

	lblDescripcion = new JLabel("Descripción: ");
	add(lblDescripcion, "1, 7");

	descripcion = new JTextField();
	add(descripcion, "3, 7");
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

	lblPrecio = new JLabel("Precio: ");
	add(lblPrecio, "1, 9");

	precio = new JTextField();
	add(precio, "3, 9");
	precio.setColumns(10);
	precio.addKeyListener(new KeyAdapter()
	{
	    public void keyTyped(KeyEvent e)
	    {
		char caracter = e.getKeyChar();
		if (!Character.isDigit(caracter))
		{
		    e.consume();
		}
	    }
	});

	lblCate = new JLabel("Categoría");
	add(lblCate, "1, 11");

	String[] cate = { "Platos calientes", "Platos fríos", "Frituras", "A la plancha", "Ensaladas", "Otros platos",
		"Postres", "Salsas" };
	categoria = new JComboBox<String>(cate);
	add(categoria, "3, 11");

	adicional = new JCheckBox();
	adicional.setText("Adicional");
	add(adicional, "3, 13");

	JButton btnConfirmar = new JButton("Confirmar");
	add(btnConfirmar, "3, 15");
	btnConfirmar.addActionListener(new ActionListener()
	{

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		if (!complete())
		{
		    JOptionPane.showMessageDialog(Panel_Alta.this, "Completar todos los campos");
		} else if (!verificarCodigo(Integer.parseInt(codigo.getText())))
		{
		    insertar();
		    try
		    {
			Principal.getDatos();
		    } catch (SQLException | IOException e1)
		    {
			JOptionPane.showMessageDialog(Panel_Alta.this, "Error el actualizar la base de datos");
		    }
		    btnRefrescar.setEnabled(true);
		} else
		    JOptionPane.showMessageDialog(Panel_Alta.this, "Codigo de producto repetido");
	    }
	});

	setVisible(true);
    }

    protected void insertar()
    {
	Item nuevo = new Item();
	nuevo.setCodigo(Integer.parseInt(codigo.getText()));
	nuevo.setDescripcion(descripcion.getText());
	nuevo.setPrecio(Integer.parseInt(precio.getText()));
	nuevo.setCategoria(categoria.getSelectedItem().toString());
	nuevo.setAdicional(adicional.isSelected());
	try
	{
	    if (DB.getInstance().insert(nuevo))
	    {
		clear();
		JOptionPane.showMessageDialog(Panel_Alta.this, "Nuevo producto guardado correctamente");
	    }
	} catch (SQLException e1)
	{
	    JOptionPane.showMessageDialog(Panel_Alta.this, "Error al guardar el nuevo producto");
	}
    }

    protected void clear()
    {
	codigo.setText("");
	descripcion.setText("");
	precio.setText("");
	categoria.setSelectedIndex(0);
	adicional.setSelected(false);
    }

    protected boolean complete()
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

    private boolean verificarCodigo(int cod)
    {
	if (Datos.getInstance().searchItem(cod) == null)
	    return false;
	else
	    return true;
    }
}
