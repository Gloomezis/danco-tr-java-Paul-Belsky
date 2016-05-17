package servlets.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

/**
 * Servlet implementation class ShowAllGuestNumber
 */
public class ShowAllGuestNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
      String res=mainController.showAllGuestNumber();
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hotelRoom/showAllGuestNumberResult.jsp");

		request.setAttribute("results", res);
		dispatcher.forward(request, response);
	}

	
}
