

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO objUserDAO = null;
		User	objUser = null;
		String strName = null;
		String strEmail = null;
		String strPassword = null;
		HttpSession objSession = null;
		
		try 
		{
			objUserDAO = new UserDAO();
			strName = request.getParameter("txtName").toString();
			strEmail = request.getParameter("txtEmail").toString();
			strPassword = request.getParameter("txtPassword").toString();
			
			if(objUserDAO.checkUsernameExists(strEmail))
			{
				throw new Exception("Username already exists.");
			}

			objUser = new User();
			objUser.setEmail(strEmail);
			objUser.setName(strName);
			objUser.setPassword(strPassword);
			objUserDAO.insert(objUser);
			
			objSession = request.getSession(true);
			if(objSession == null)
			{
				throw new Exception("Failed to create a session for user.");
			}
			objSession.setAttribute("User", objUser);
			request.getSession().setAttribute("ProfileInfo", objUser);
			
			request.getRequestDispatcher("Profile.jsp").forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
	}
}
