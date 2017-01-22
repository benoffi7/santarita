package santa_rita;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Apariencia;

public class DB
{
    private static DB instancia;
    public static Connection connection;
    public static Statement statement;
    public static ResultSet result;

    public DB()
    {
	try
	{
	    // Register and set up the Driver
	    Class.forName("com.mysql.jdbc.Driver");
	    // Connect to the database
	    connection = DriverManager.getConnection("jdbc:mysql://localhost/SantaRita", "root", "");
	    // Create a statement
	    statement = connection.createStatement();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    public void closeConnection() throws Exception
    {
	connection.close();
    }

    public static DB getInstance()
    {
	if (instancia == null)
	{
	    instancia = new DB();
	}
	return instancia;
    }

    public boolean insert(Item item) throws SQLException
    {
	int ad;
	if (item.isAdicional())
	    ad = 1;
	else
	    ad = 0;
	int respuesta = statement
		.executeUpdate("INSERT INTO `productos` (codigo, nombre, precio, adicional, categoria) " + "VALUES ('"
			+ item.getCodigo() + "', '" + item.getDescripcion() + "', '" + item.getPrecio() + "', " + ad
			+ ", '" + item.getCategoria() + "')");
	if (respuesta == 1)
	{
	    return true;
	} else
	    return false;
    }

    public boolean delete(int codigo) throws SQLException
    {
	int respuesta = statement.executeUpdate("DELETE FROM `productos` WHERE `codigo` = " + codigo);
	if (respuesta == 1)
	{
	    return true;
	} else
	    return false;
    }

    public boolean modify(Item item, int cod_anterior) throws SQLException
    {
	int ad;
	if (item.isAdicional())
	    ad = 1;
	else
	    ad = 0;
	int respuesta = statement
		.executeUpdate("UPDATE `productos` SET `codigo` = '" + item.getCodigo() + "', `nombre` = '"
			+ item.getDescripcion() + "', `precio` = '" + item.getPrecio() + "', `adicional` = '" + ad
			+ "', `categoria` = '" + item.getCategoria() + "' WHERE `codigo` =" + cod_anterior);
	if (respuesta == 1)
	{
	    return true;
	} else
	    return false;
    }

    public void getDatos() throws SQLException
    {
	ResultSet consulta = statement.executeQuery("SELECT * FROM `productos`");
	while (consulta.next())
	{
	    Item nuevo = new Item();
	    nuevo.setCodigo(consulta.getInt("codigo"));
	    nuevo.setDescripcion(Apariencia.capitalizeString(consulta.getString("nombre")));
	    nuevo.setPrecio(consulta.getInt("precio"));
	    nuevo.setCategoria(consulta.getString("categoria"));
	    if (consulta.getInt("adicional") == 1)
		nuevo.setAdicional(true);
	    else
		nuevo.setAdicional(false);
	    Datos.getInstance().addItem(nuevo);
	}
    }

    public void getAdicionales() throws SQLException
    {
	ResultSet consulta = statement.executeQuery("SELECT * FROM `productos` WHERE `adicional` = 1");
	while (consulta.next())
	{
	    Item nuevo = new Item();
	    nuevo.setCodigo(consulta.getInt("codigo"));
	    nuevo.setDescripcion(Apariencia.capitalizeString(consulta.getString("nombre")));
	    nuevo.setPrecio(consulta.getInt("precio"));
	    nuevo.setCategoria(consulta.getString("categoria"));
	    nuevo.setAdicional(true);
	    Datos.getInstance().addAdicional(nuevo);
	}
    }

    public void crearArchivo() throws SQLException, IOException
    {
	String salida = "";
	ResultSet consulta = statement.executeQuery("SELECT * FROM `productos`");
	while (consulta.next())
	{
	    salida += consulta.getInt("adicional") + ";";
	    salida += consulta.getString("codigo") + ";";
	    salida += consulta.getString("nombre") + ";";
	    salida += consulta.getInt("precio") + ";";
	    salida += "##";
	}
	Writer out = new BufferedWriter(
		new OutputStreamWriter(new FileOutputStream("C:\\xampp\\htdocs\\productos.txt"), "UTF-8"));
	try
	{
	    out.write(salida);
	} finally
	{
	    out.close();
	}
    }
}
