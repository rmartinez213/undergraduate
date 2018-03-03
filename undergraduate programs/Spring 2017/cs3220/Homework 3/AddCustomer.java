package Homework3;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id = 100;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Hello");
		request.getRequestDispatcher("/WEB-INF/Homework3/AddCustomer.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Variables that store information that was passed from the jsp
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		System.out.println(name);
		System.out.println(description);
		// Creates booleans to validate if new customer has required information
		boolean validName = name != null && name.trim().length() > 0;
		boolean descriptionName = description != null && description.trim().length() > 0;

		if (validName && descriptionName) {
			// Creates an object for arraylist
			CustomerBean EntryObj = new CustomerBean(id++, name, description);

			// Creates an arraylist
			List<CustomerBean> EntryList = (List<CustomerBean>) getServletContext().getAttribute("RegisteredCustomers");

			// Add the student to the arraylist
			EntryList.add(EntryObj);

			response.sendRedirect("Main");
		}

		else {

			if (!validName)
				request.setAttribute("nameError", "Please enter your name");

			if (!descriptionName)
				request.setAttribute("descriptionError", "Please enter a message");

			doGet(request, response);
		}
	}

}
