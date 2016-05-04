import java.sql.*;


public class DBManager {
	private Connection objConn = null;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/test_db";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "123456";


	public Connection getConn()
	{
		try
		{  
			if(objConn != null)
			{
				return objConn;
			}
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			objConn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return objConn;
	}
}
