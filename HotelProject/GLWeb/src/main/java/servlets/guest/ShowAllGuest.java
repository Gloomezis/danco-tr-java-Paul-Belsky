package servlets.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;


public class ShowAllGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Guest> res=mainController.showAllGuests(request.getParameter("sortCondition"));
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("guest/showAllGuestResult.jsp");

		request.setAttribute("results", res);
		dispatcher.forward(request, response);
	}

	

}
