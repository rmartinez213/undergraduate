package shoppingCart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Farms/DeleteEgg")
public class DeleteEgg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteEgg() {
        super();
           }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("The id is: " + id);
		//Session must exist in order for them to have gotten here
		ArrayList<Products> inCart = (ArrayList<Products>) session.getAttribute("productList");		
		
		double subTotal = (double) session.getAttribute("totalSum");
		double totalSum = (double) session.getAttribute("sumTax");
		
		for (Products products : inCart) { // Traverse arraylist and remove obj from arraylist
			if(products.getId() == id){
				inCart.remove(products);
				session.setAttribute("sumTax", Math.round((totalSum - products.getTotalPrice()) * 100.0) / 100.0);
				session.setAttribute("totalSum", Math.round((subTotal - products.getTotalPrice()) * 100.0) / 100.0);

				break;
			}
			session.setAttribute("productList", inCart);
		}
		
		//request.getRequestDispatcher("/WEB-INF/Farms/ShoppingCart.jsp").forward(request, response);
		response.sendRedirect("ShoppingCartController");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
