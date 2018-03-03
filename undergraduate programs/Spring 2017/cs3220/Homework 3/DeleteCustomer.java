package Homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	private void removeCustomer(Integer id) {
		List<CustomerBean> CustomerList = (List<CustomerBean>) getServletContext().getAttribute("RegisteredCustomers");

		for (CustomerBean List : CustomerList) {
			if (List.getId() == id) {
				CustomerList.remove(List);
				break;
			}
		}
		return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		removeCustomer(Integer.valueOf(request.getParameter("id")));
		response.sendRedirect("Main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
