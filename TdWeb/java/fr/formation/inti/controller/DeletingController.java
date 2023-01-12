package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class UpdatingController
 */
@WebServlet("/delete")
public class DeletingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletingController() {
		super();
		ud = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id = request.getParameter("id");
		if (session != null && id != null) {
			ud.deleteById(Integer.parseInt(id));
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
