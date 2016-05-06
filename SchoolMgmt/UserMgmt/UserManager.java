
public class UserManager {

	public void createUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try 
		{
			objUserDAO = new UserDAO();
			objUserDAO.insert(objUser);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void deleteUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try 
		{
			objUserDAO = new UserDAO();
			objUserDAO.delete(objUser);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}


	public void updateUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try 
		{
			objUserDAO = new UserDAO();
			objUserDAO.update(objUser);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


	public User findUser(String strUsername, String strPassword) throws Exception
	{
		User objUser = null;
		UserDAO objUserDAO = null;

		try 
		{
			objUserDAO = new UserDAO();
			objUser = objUserDAO.getUserByEmailAndPassword(strUsername, strPassword);	
		}
		catch (Exception e) 
		{
			throw e;
		}

		return objUser;
	}

}
