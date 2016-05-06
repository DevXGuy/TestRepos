

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strName;
		String strEmail;
		String strPassword;
		HttpSession objSession = null;
		User		objUser = null;
		UserDAO		objUserDAO = null;

		try 
		{
			strName = request.getParameter("txtName");
			strEmail = request.getParameter("txtEmail");
			strPassword = request.getParameter("txtPassword");
			if(strName.isEmpty())
			{
				throw new Exception("Name cannot be empty.");
			}
			if(strEmail.isEmpty())
			{
				throw new Exception("Email cannot be empty.");
			}
			if(strPassword.isEmpty())
			{
				throw new Exception("Password cannot be empty.");
			}
			objSession = request.getSession(false);
			if(objSession == null)
			{
				throw new Exception("Session was not found.");
			}
			objUser = (User) objSession.getAttribute("User");
			if(objUser == null)
			{
				throw new Exception("Failed to get user from session.");
			}
			
			objUser.setName(strName);
			objUser.setEmail(strEmail);
			objUser.setPassword(strPassword);
			objUserDAO = new UserDAO();
			objUserDAO.update(objUser);
			objSession.setAttribute("User", objUser);
			request.getSession().setAttribute("ProfileInfo", objUser);
			request.getRequestDispatcher("Profile.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}



	}

}
