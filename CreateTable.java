import java.sql.*;
public class CreateTable
{

	public static void main( String args[] )
	{
		Connection c = null;
		Statement stmt = null;

		try 
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
			System.out.println("database Connected...\n");
			stmt = c.createStatement();
			String sql = "CREATE TABLE Movies" +
			"(Movid INTEGER PRIMARY KEY AUTOINCREMENT," +
			"MovName TEXT NOT NULL," +
			"Actor VARCHAR(15)," +
			"Actress VARCHAR(15)," +
			"Yearofrelease INTEGER," +
			"Director VARCHAR(15))";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		}
		catch ( Exception e ) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table Movies Created with the given query Successfully!!!");
	}

}