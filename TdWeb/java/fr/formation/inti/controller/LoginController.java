package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		ud = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(request.getContextPath());

		} else {
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = ud.findbylog(email, password);

		if (user == null) {
			request.getSession().setAttribute("message", "Incorrect login. Please check your email ans password.");
			response.sendRedirect(request.getContextPath());
			return;
		} else {

			HttpSession mysession = request.getSession();
			mysession.setAttribute("email", email);
			mysession.setMaxInactiveInterval(30*60);
			request.setAttribute("message",
					"<h1> Bonjour " + user.getFirstname() + " " + user.getLastname() + "<h1>");
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);
			return;
		}
	}
}
