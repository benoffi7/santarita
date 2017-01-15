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
}
