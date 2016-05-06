
public class User {
	
	private int m_userID = 0;
	private String m_strName;
	private String m_strEmail;
	private String m_strPassword;
	
	public int getUserID() {
		return m_userID;
	}
	public void setUserID(int userID) {
		this.m_userID = userID;
	}
	public String getName() {
		return m_strName;
	}
	public void setName(String strName) {
		this.m_strName = strName;
	}
	public String getEmail() {
		return m_strEmail;
	}
	public void setEmail(String strEmail) {
		this.m_strEmail = strEmail;
	}
	public String getPassword() {
		return m_strPassword;
	}
	public void setPassword(String strPassword) {
		this.m_strPassword = strPassword;
	}
}
