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
 * Servlet implementation class ModificationController
 */
@WebServlet("/update")
public class ModificationControllerEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private employeeService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificationControllerEmp() {
		super();
		ud = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String iduser = request.getParameter("id");
		Integer id = Integer.parseInt(iduser);
		Employee emp = ud.findById(id);
		request.setAttribute("emp", emp);
		request.setAttribute("id", emp.getEmpId());
		request.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/Update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String iduser = request.getParameter("id");
		Integer id = Integer.parseInt(iduser);
		Employee emp = ud.findById(id);

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String rolename = request.getParameter("rolename");
		String date = request.getParameter("date");

		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date datecrea;
		try {
			datecrea = availDate.parse(date);
			emp.setStartDate(datecrea);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setTitle(rolename);

		ud.save(emp);

		request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

	}
}
