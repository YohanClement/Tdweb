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
			String message = "Problème de connection ! Vérifiez votre émail et votre mot de passe";
			request.setAttribute("message", message);
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;

		} else {
			HttpSession mysession = request.getSession();
			mysession.setMaxInactiveInterval(30 * 60); // 30 min inactif
			request.getSession().setAttribute("message",
					"<p> Bonjour " + user.getFirstname() + " " + user.getLastname() + "<p>");
			mysession.setAttribute("me", user);
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);
			return;
		}

	}
}
