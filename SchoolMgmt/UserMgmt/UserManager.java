
public class UserManager {

	public void createUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try {
			objUserDAO.insert(objUser);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try {
			objUserDAO.delete(objUser);	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void updateUser(User objUser)
	{
		UserDAO objUserDAO = null;

		try {
			objUserDAO.update(objUser);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public User findUser(String strUsername, String strPassword)
	{
		User objUser = null;
		UserDAO objUserDAO = null;

		try {
			objUser = objUserDAO.getUserByEmailAndPassword(strUsername, strPassword);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objUser;
	}

}
