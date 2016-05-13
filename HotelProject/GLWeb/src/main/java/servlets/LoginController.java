package servlets;


/**
 * Servlet implementation class LoginController
 */
import java.io.IOException;
import java.io.PrintWriter;
 


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.User;
 
/**
 * Servlet implementation class LoginServlet
 */

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";
    private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("name");
        String pwd = request.getParameter("password");
        User userFromBase= mainController.getUser(user,pwd);
         
         
        if(userFromBase.getName().equals(user) && userFromBase.getPassword().equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", userFromBase.getName());
            session.setAttribute("userId", userFromBase.getId());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("/success.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
 
    }
 
}


