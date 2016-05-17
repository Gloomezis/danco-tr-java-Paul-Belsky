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

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);

	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		RequestDispatcher rd;
		if (login.isEmpty() || pass.isEmpty()) {
			 rd = request
					.getRequestDispatcher("/main/registration.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		} else {
			if(mainController.getUserByLogin(login) !=null){
				 rd = request.getRequestDispatcher("/sorryThatLoginUsed.jsp");	
			}else{
			mainController.addUser(login, pass);
			 rd = request.getRequestDispatcher("/main/success.jsp");
			rd.forward(request, response);
		}
	}
}
}
