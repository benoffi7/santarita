package santa_rita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void getDatos() throws SQLException
    {
	ResultSet consulta = statement.executeQuery("SELECT * FROM `productos`");
	while (consulta.next())
	{
	    Item nuevo = new Item();
	    nuevo.setCodigo(consulta.getInt("codigo"));
	    nuevo.setDescripcion(consulta.getString("nombre"));
	    nuevo.setPrecio(consulta.getInt("precio"));
	    nuevo.setCategoria(consulta.getString("categoria"));
	    Datos.getInstance().addItem(nuevo);
	}
    }

}