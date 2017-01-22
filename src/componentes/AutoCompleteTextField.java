package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import com.mxrck.autocompleter.TextAutoCompleter;

import santa_rita.Datos;
import santa_rita.Item;

public class AutoCompleteTextField extends JTextField
{
    private final String hint;
    private TextAutoCompleter autocompleter;
    private Item seleccionado;

    public AutoCompleteTextField(String hint)
    {
	this.hint = hint;
	super.setColumns(30);
	autocompleter = new TextAutoCompleter(this);
	for (Item item : Datos.getInstance().getItems())
	{
	    autocompleter.addItem(item);
	}

	this.addKeyListener(new KeyListener()
	{
	    @Override
	    public void keyReleased(KeyEvent e)
	    {
		int code = e.getKeyCode();

		switch (code)
		{
		case KeyEvent.VK_ENTER:
		    seleccionado = (Item) autocompleter.getItemSelected();
		    break;
		default:
		    seleccionado = null;
		}
	    }

	    @Override
	    public void keyPressed(KeyEvent e)
	    {
	    }

	    @Override
	    public void keyTyped(KeyEvent e)
	    {
	    }
	});
    }

    public TextAutoCompleter getAutocompleter()
    {
	return autocompleter;
    }

    public int getIdSeleccionado()
    {
	if (seleccionado == null)
	{
	    return -1;
	} else
	{
	    return seleccionado.getCodigo();
	}
    }

    public String getNombreSeleccionado()
    {
	if (seleccionado == null)
	{
	    return "";
	} else
	{
	    return seleccionado.getDescripcion();
	}
    }

    public Item getItemSeleccionado()
    {
	if (seleccionado == null)
	{
	    return null;
	} else
	{
	    return seleccionado;
	}
    }

    @Override
    public void paint(Graphics g)
    {
	super.paint(g);
	if (getText().length() == 0)
	{
	    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g.setColor(new Color(135, 135, 135));
	    g.drawString(hint, 0, 0);
	}
    }
}
