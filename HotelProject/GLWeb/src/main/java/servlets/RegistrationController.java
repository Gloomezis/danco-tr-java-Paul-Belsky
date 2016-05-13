package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

/**
 * Servlet implementation class RegistrationController
 */
// for registration2
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		

		if (name.isEmpty() || pass.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/registration.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		} else {
			mainController.addUser(name, pass);
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
		}
	}

}