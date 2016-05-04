import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	public void insert(User objUser) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		ResultSet			objResultSet 	= null;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			objSqlStmt = objConnection.prepareStatement("INSERT INTO tbl_User Name = ?, Username = ?, Password = ?");
			objResultSet = objSqlStmt.executeQuery();
			objSqlStmt.setString(1, objUser.getName());
			objSqlStmt.setString(2, objUser.getUsername());
			objSqlStmt.setString(3, objUser.getPasssword());
			if(objResultSet.getRow() != 1)
			{
				throw new Exception("Failed to insert user into database.");
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	
	public void delete(User objUser)
	{
		
	}
	
	public void update(User objUser)
	{
		
	}
	
	public User getUserByEmailAndPassword(String strUsername, String strPassword) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		ResultSet			objResultSet 	= null;
		User 				objUser = null;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			if(objConnection == null)
			{
				throw new Exception("Failed to get database connection.");
			}
			objSqlStmt = objConnection.prepareStatement("SELECT * FROM tbl_User WHERE Username = ?, Password = ?");
			objSqlStmt.setString(1, strUsername);
			objSqlStmt.setString(1, strPassword);
			objResultSet = objSqlStmt.executeQuery();
			if(objResultSet.getRow() != 1)
			{
				throw new Exception("Failed to insert user into database.");
			}
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		
		return objUser;
	}

}
