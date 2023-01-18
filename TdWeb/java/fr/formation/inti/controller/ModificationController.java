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
			request.setAttribute("user", user);
			request.setAttribute("id", user.getIduser());
			request.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/UpdateUser.jsp").forward(request, response);
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
			String date = request.getParameter("date");
			String droit = request.getParameter("droit");
			SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
			Date datecrea;
			try {
				datecrea = availDate.parse(date);
				user.setCreationDate(datecrea);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			user.setEmail(email);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setRolename(rolename);
			user.setPassword(password);
			if ("admin".equals(droit))
				user.setDroit(droit);
			else
				user.setDroit("user");
			ud.save(user);

			request.getServletContext().getRequestDispatcher("/tabu").forward(request, response);

	}

}
