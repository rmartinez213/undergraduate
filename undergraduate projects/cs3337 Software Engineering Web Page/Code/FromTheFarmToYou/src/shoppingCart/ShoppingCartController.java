package shoppingCart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/Farms/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoppingCartController() {
        super();
        
    }
    
    //Helper method to see if arraylist is in session already
    public boolean isInList(ArrayList<Products> inCart, String name, double price, int quantity, int id){
    	for (Products products : inCart) {
			if(products.getName().equals(name)){ // already selected, this item before, so just update quantity
				products.setName(name);
				products.setPrice(price);
				products.setQuantity(quantity);
				products.setTotalPrice(price*quantity);
				products.setId(id);
				return true; //return true, if item selected, has already been selected.
			}
		}
    	return false; //Item selected is not inside the session
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/Farms/ShoppingCart.jsp").forward(request, response);		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set session, and get param values
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity")); 
		double price = Double.parseDouble(request.getParameter("price"));
		int id = Integer.parseInt(request.getParameter("id")); 
		
		if(session.getAttribute("productList") == null){ //The first item to get selected, so create a new product obj
			Products product = new Products();
			ArrayList<Products> inCart = new ArrayList<Products>(); //Create a new list, and eventually store selected prod objects here
			product.setName(name);
			product.setQuantity(quantity);
			product.setPrice(price);
			double rounded = Math.round(price*quantity * 100.0) / 100.0;
			System.out.println("This is rounded: " + rounded);
			product.setTotalPrice(rounded);
			product.setId(id);
			inCart.add(product);
			//Math.round(totalSum * 100.0) / 100.0);
			
			
			session.setAttribute("productList", inCart); //Store the arraylist inside session
			
			double totalSum = 0;
			for(Products p: inCart){
				totalSum += p.getTotalPrice(); //This gives total price of everything in the list. 
				
			}
			
			session.setAttribute("totalSum", Math.round(totalSum * 100.0) / 100.0);	//Set total price in session
			session.setAttribute("sumTax", Math.round((totalSum + 5) * 100.0) / 100.0);	//Set the total with added 5 dollar shipping
			
		}
		else if (session.getAttribute("productList") != null){ //Arraylist is already in session
			ArrayList<Products> inCart = (ArrayList<Products>) session.getAttribute("productList"); //Get arraylist from session
			
			if(isInList(inCart, name, price, quantity, id) == true){ // found in list
				session.setAttribute("productList", inCart); // update session scope, since if found, helper method updates value
				double totalSum = 0;
				for(Products p: inCart){
					totalSum += p.getTotalPrice(); //This gives total price of everything in the list. 	
				}
				session.setAttribute("totalSum", Math.round(totalSum * 100.0) / 100.0);
				session.setAttribute("sumTax", Math.round((totalSum + 5) * 100.0) / 100.0);
			}
			else if(isInList(inCart, name, price, quantity, id) == false){ //Product selected not inside the arraylist, so create new prod obj 
				Products product = new Products();
				
				product.setName(name);
				product.setQuantity(quantity);
				product.setPrice(price);
				double rounded = Math.round(price*quantity * 100.0) / 100.0;
				System.out.println("This is rounded: " + rounded);
				product.setTotalPrice(rounded);
				product.setId(id);
				
				inCart.add(product);
				session.setAttribute("productList", inCart); //Set updated list in session
				
				double totalSum = 0;
				for(Products p: inCart){
					totalSum += p.getTotalPrice(); //This gives total price of everything in the list. 	
				}
				session.setAttribute("totalSum", Math.round(totalSum * 100.0) / 100.0);
				session.setAttribute("sumTax", Math.round((totalSum + 5) * 100.0) / 100.0);
			}
		}
		
	
		String previousURL = request.getHeader("Referer");
		session.setAttribute("previousURL", previousURL);
		System.out.println("\n\n" + request.getHeader("Referer") );
		request.getRequestDispatcher("/WEB-INF/Farms/ShoppingCart.jsp").forward(request, response);
		

	}

}
