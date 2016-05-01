
public class User {
	
	private int m_userID = 0;
	private String m_strName;
	private String m_strUsername;
	private String m_strPasssword;
	
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
	public String getUsername() {
		return m_strUsername;
	}
	public void setUsername(String strUsername) {
		this.m_strUsername = strUsername;
	}
	public String getPasssword() {
		return m_strPasssword;
	}
	public void setPasssword(String strPasssword) {
		this.m_strPasssword = strPasssword;
	}
}
