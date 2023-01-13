package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeServiceImpl;
import fr.formation.inti.service.employeeService;

/**
 * Servlet implementation class addemployee
 */
@WebServlet("/addemp")
public class Addemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private employeeService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addemployee() {
		super();
		ud = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AppEmp.html").forward(request, response);

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

		HttpSession session = request.getSession(false);

		if (session != null) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String rolename = request.getParameter("rolename");
			String date = request.getParameter("date");
			SimpleDateFormat startdate = new SimpleDateFormat("yyyy-MM-dd");
			Date datecrea;

			Employee neo = new Employee();
			try {
				datecrea = startdate.parse(date);

				neo.setFirstName(firstname);
				neo.setLastName(lastname);
				neo.setTitle(rolename);
				neo.setStartDate(datecrea);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ud.save(neo);
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
