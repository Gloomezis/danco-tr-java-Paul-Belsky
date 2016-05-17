package filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;


public class AuditFilter implements Filter {

	private ServletContext context;

	private IMainController mainController = (IMainController) DependencyInjectionManager
			.getClassInstance(IMainController.class);

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuditFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		
		String userLogin = (String)request.getParameter("userLogin");
		
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			String resources = req.getRemoteAddr() + "::Request Params::{"
					+ name + "=" + value + "}";
			mainController.addHandling(userLogin, resources);
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				this.context.log(req.getRemoteAddr() + "::Cookie::{"
						+ cookie.getName() + "," + cookie.getValue() + "}");
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
		// we can close resources here
	}
}