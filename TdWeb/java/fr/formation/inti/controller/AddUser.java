package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class addemployee
 */
@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
		ud = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AjoutUser.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String rolename = request.getParameter("rolename");

		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		User user = ud.findbyemail(email);

		if (user == null) {
			User neo = new User();
			neo.setEmail(email);
			neo.setFirstname(firstname);
			neo.setLastname(lastname);
			neo.setPassword(password);
			neo.setRolename(rolename);
			neo.setCreationDate(sqlDate);

			neo.setDroit("user");

			ud.save(neo);
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

		} else {
			String message = "Utilisateur déja connu";
			request.setAttribute("erreur", message);
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}
}