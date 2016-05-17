package servlets.hotelRoom;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;


public class SettleGuestToHotelRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
	
	private static final String SPLIT = "/";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res=mainController.settleGuestToHotelRoom(request.getParameter("guestId"), request.getParameter("hotelRoomId"), dateFromString(request.getParameter("dArrive")), dateFromString(request.getParameter("dDeparture")));
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hotelRoom/settleGuestToHotelRoomResult.jsp");

		request.setAttribute("results", res);
		dispatcher.forward(request, response);
	}
	
	public Date dateFromString(String str) {
		Date date = null;
		String[] dateMassArrive = str.split(SPLIT);
		date = new GregorianCalendar(Integer.parseInt(dateMassArrive[2]),
				Integer.parseInt(dateMassArrive[1]),
				Integer.parseInt(dateMassArrive[0])).getTime();
		return date;
	}
}
