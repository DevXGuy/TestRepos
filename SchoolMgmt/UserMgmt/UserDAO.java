import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	public void insert(User objUser) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		int					isInserted		= 0;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			objSqlStmt = objConnection.prepareStatement("INSERT INTO test_db.user (Name, Email, Password) VALUES (?, ?, ?)");
			objSqlStmt.setString(1, objUser.getName());
			objSqlStmt.setString(2, objUser.getEmail());
			objSqlStmt.setString(3, objUser.getPassword());
			isInserted = objSqlStmt.executeUpdate();
			if(isInserted != 1)
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
	
	public void update(User objUser) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		int					isUpdated = 0;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			if(objConnection == null)
			{
				throw new Exception("Failed to get database connection.");
			}
			objSqlStmt = objConnection.prepareStatement("UPDATE test_db.user SET Name = ? , Email = ? , Password = ? WHERE ID = ?");
			objSqlStmt.setString(1, objUser.getName());
			objSqlStmt.setString(2, objUser.getEmail());
			objSqlStmt.setString(3, objUser.getPassword());
			objSqlStmt.setInt(4, objUser.getUserID());
			isUpdated = objSqlStmt.executeUpdate();
			if(isUpdated < 1)
			{
				throw new Exception("Failed to update user.");
			}
		} 
		catch (Exception e) 
		{
			throw e;
		} 
	}
	
	public User getUserByEmailAndPassword(String strUsername, String strPassword) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		ResultSet			objResultSet 	= null;
		User 				objUser 		= null;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			if(objConnection == null)
			{
				throw new Exception("Failed to get database connection.");
			}
			objSqlStmt = objConnection.prepareStatement("SELECT * FROM test_db.user WHERE Email = ? AND Password = ?");
			objSqlStmt.setString(1, strUsername);
			objSqlStmt.setString(2, strPassword);
			objResultSet = objSqlStmt.executeQuery();

			if(!objResultSet.next())
			{
				throw new Exception("User does not exists.");
			}
			
			objUser = new User();
			objUser.setName(objResultSet.getString("Name"));
			objUser.setEmail(objResultSet.getString("Email"));
			objUser.setPassword(objResultSet.getString("Password"));
			objUser.setUserID(objResultSet.getInt("ID"));
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		
		return objUser;
	}

	public boolean checkUsernameExists(String strUsername) throws Exception
	{
		DBManager 			objDBManager 	= null;
		Connection 			objConnection 	= null;
		PreparedStatement 	objSqlStmt 		= null;
		ResultSet			objResultSet 	= null;
		boolean				userExists		= false;
		
		try 
		{
			objDBManager = new DBManager();
			objConnection = objDBManager.getConn();
			if(objConnection == null)
			{
				throw new Exception("Failed to get database connection.");
			}
			objSqlStmt = objConnection.prepareStatement("SELECT * FROM test_db.user WHERE Email = ?");
			objSqlStmt.setString(1, strUsername);
			objResultSet = objSqlStmt.executeQuery();
			if(objResultSet.next())
			{
				userExists = true;
			}
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		
		return userExists;
	}

	
}
