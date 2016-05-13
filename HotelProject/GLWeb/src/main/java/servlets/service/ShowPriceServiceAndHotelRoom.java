package servlets.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;


public class ShowPriceServiceAndHotelRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res= mainController.showPriceServiceAndHotelRoom();
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

		request.setAttribute("results", res);
		dispatcher.forward(request, response);
	}


}