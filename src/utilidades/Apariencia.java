package utilidades;

import java.awt.Color;

public abstract class Apariencia
{
    public static Color background_paneles;
    public static Color background_amarillo;
    public static Color fuentes;
    static
    {
	background_paneles = new Color(0, 0, 0, 0);
	background_amarillo = new Color(255, 212, 37);
    }

    public static String capitalizeString(String string)
    {
	char[] chars = string.toLowerCase().toCharArray();
	boolean found = false;
	for (int i = 0; i < chars.length; i++)
	{
	    if (!found && Character.isLetter(chars[i]))
	    {
		chars[i] = Character.toUpperCase(chars[i]);
		found = true;
	    } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'')
	    { // You can add other chars here
		found = false;
	    }
	}
	return String.valueOf(chars);
    }
}
