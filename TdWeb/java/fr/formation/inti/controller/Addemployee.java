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

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class addemployee
 */
@WebServlet("/add")
public class Addemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ud;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addemployee() {
		super();
		ud = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
		String date = request.getParameter("date");
		SimpleDateFormat startdate = new SimpleDateFormat("yyyy-MM-dd");
		Date datecrea;
		User user = ud.findbylog(email, password);
		if (user == null) {
			User neo = new User();
		try {
			datecrea = startdate.parse(date);
			neo.setEmail(email);
			neo.setFirstname(firstname);
			neo.setLastname(lastname);
			neo.setPassword(password);
			neo.setRolename(rolename);
			neo.setCreationDate(datecrea);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
			

			ud.save(neo);
			request.getServletContext().getRequestDispatcher("/tab").forward(request, response);

		} else {
			String message = "Utilisateur déja connu";
			HttpSession mysession = request.getSession();
			mysession.setAttribute("dejaco", message);
			request.getServletContext().getRequestDispatcher("/").forward(request, response);
		}

	}

}
