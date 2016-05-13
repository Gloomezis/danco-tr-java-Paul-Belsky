package servlets.hotelRoom;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

/**
 * Servlet implementation class hotelRoomCRUD
 */
public class HotelRoomCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainController.addRooms(request.getParameter("number"), Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("sNumber")), Integer.parseInt(request.getParameter("starCategory")));
	
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

}
