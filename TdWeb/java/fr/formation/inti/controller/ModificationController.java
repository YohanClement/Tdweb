package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class ModificationController
 */
@WebServlet("/change")
public class ModificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificationController() {
		super();
		ud = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iduser = request.getParameter("id");
		Integer id = Integer.parseInt(iduser);
		User user = ud.findById(id);
		
		request.setAttribute("id", id);
		request.setAttribute("user", user);

		request.getServletContext().getRequestDispatcher("/Update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iduser = request.getParameter("id");
		Integer id = Integer.parseInt(iduser);
		User user = ud.findById(id);

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String rolename = request.getParameter("rolename");

		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setRolename(rolename);
		user.setPassword(password);
		ud.save(user);
		
		request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

	}

}
