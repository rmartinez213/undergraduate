package Homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Homework3.CustomerBean;

@WebServlet("/Homework3/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	private CustomerBean getEntry(Integer id) {
		List<CustomerBean> CustomerList = (List<CustomerBean>) getServletContext().getAttribute("RegisteredCustomers");

		for (CustomerBean List : CustomerList)
			if (List.getId() == id)
				return List;

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the entry, so that it will be edited
		Integer id = Integer.valueOf(request.getParameter("id"));
		CustomerBean List = getEntry(id);

		// Pass the entry and redirect to jsp using a request dispatcher
		request.setAttribute("List", List);
		request.getRequestDispatcher("/WEB-INF/Homework3/EditCustomer.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Get the entry, so that it will be edited
		Integer id = Integer.valueOf(request.getParameter("id"));
		CustomerBean List = getEntry(id);

		// Edits the entry from user input
		List.setName(request.getParameter("name"));
		List.setDescription(request.getParameter("description"));

		System.out.println("Test");

		response.sendRedirect("Main");
	}

}
