package servlets.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;


public class ServiceCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainController.createService(Integer.parseInt(request.getParameter("orderId")), request.getParameter("serviceName"),Integer.parseInt( request.getParameter("servicePrice")));
		
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

}
