import java.sql.Connection;


public class DBManager {
	private Connection objConn = null;
	
	
	public Connection getConn()
	{
		if(objConn != null)
		{
			return objConn;
		}
		
		// open db connection
		
		
		
		return objConn;
	}
}
