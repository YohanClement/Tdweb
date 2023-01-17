package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.service.EmployeeServiceImpl;
import fr.formation.inti.service.employeeService;

/**
 * Servlet implementation class UpdatingController
 */
@WebServlet("/deleteE")
public class DeletingControllerEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	employeeService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletingControllerEmp() {
		super();
		ud = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		ud.deleteById(Integer.parseInt(id));
		request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
