package fr.formation.inti.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeServiceImpl;
import fr.formation.inti.service.employeeService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/tab")
public class TabController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private employeeService ed;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TabController() {
		super();
		ed = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			List<Employee> emps = ed.findAll();

			request.setAttribute("emp", emps);
			request.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/listEmp.jsp").forward(request, response);
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
