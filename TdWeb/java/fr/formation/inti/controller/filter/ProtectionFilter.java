package fr.formation.inti.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ProtectionFilter
 */
@WebFilter("/*") // servelts affected by the filter urlPatterns
public class ProtectionFilter implements Filter {

	enum url {
		addemp, delete, deleteE, logout, change, update, tab, tabu, login, add
	}

	/**
	 * Default constructor.
	 */
	public ProtectionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		boolean urlExist = false;
		boolean nosession = false;
		for (url i : url.values()) {
			String j = "/" + i;
			if (j.equals(req.getServletPath())) {
				urlExist = true;
			}
		}

		if ("/login".equals(req.getServletPath()) || "/add".equals(req.getServletPath())
				|| "/index.jsp".equals(req.getServletPath()) || req.getServletPath().endsWith(".css") ) {
			nosession = true;
		}

		if ((urlExist && session != null) || nosession) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath());
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
