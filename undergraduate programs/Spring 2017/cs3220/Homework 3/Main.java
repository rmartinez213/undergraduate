package Homework3;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Homework3/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<CustomerBean> RegisteredCustomers = new ArrayList<CustomerBean>();
		RegisteredCustomers.add(new CustomerBean(1, "John", "Likes to shop"));
		RegisteredCustomers.add(new CustomerBean(2, "Francisco", "Likes to eat"));

		getServletContext().setAttribute("RegisteredCustomers", RegisteredCustomers);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Homework3/Main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get a reference to the list of ALL todos
		// HttpSession session = request.getSession();
		ArrayList<CustomerBean> listOfNames = (ArrayList<CustomerBean>) getServletContext().getAttribute("RegisteredCustomers");

		// This list contains all Todos that match the search query
		ArrayList<CustomerBean> filteredListOfNames = new ArrayList<CustomerBean>();

		// Get the search query that the user submitted
		String searchNameQuery = request.getParameter("searchNameQuery");
		System.out.println("You searched: " + searchNameQuery);
		// Search all todos to see if their descriptions match the search query
		for (CustomerBean todo : listOfNames) {
			// If the description contains the search query, add it to the filtered list
			if (todo.getName().toLowerCase().contains(searchNameQuery.toLowerCase())) {
				System.out.println(todo.getName());
				filteredListOfNames.add(todo);
			}
		}

		request.setAttribute("RegisteredCustomers", filteredListOfNames);
		doGet(request, response);
	}

}
