

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.sun.corba.se.spi.activation.Repository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String 		strUsername = null;
		String 		strPassword = null;
		UserManager objUserManager = null;
		User 		objUser = null;
		HttpSession objSession = null;

		try
		{

			strUsername = request.getParameter("txtUsername");
			strPassword = request.getParameter("txtPassword");

			if(strUsername == null || strUsername.isEmpty())
			{
				throw new Exception("Username cannot be empty.");
			}

			if(strPassword == null || strPassword.isEmpty())
			{
				throw new Exception("Password cannot be empty.");
			}
			
			objUser = objUserManager.findUser(strUsername, strPassword);
			
			objSession = request.getSession();
			if(objSession == null)
			{
				throw new Exception("Failed to create a session for user.");
			}
			objSession.setAttribute("User", objUser);
			
			response.sendRedirect("Profile.jsp");
		}
		catch(Exception ex)
		{
			ex.toString();
			response.sendRedirect("Register.jsp");
		}
	}

}
