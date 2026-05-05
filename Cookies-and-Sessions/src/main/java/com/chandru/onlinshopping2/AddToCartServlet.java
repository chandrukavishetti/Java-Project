package com.chandru.onlinshopping2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] selectedProducts = req.getParameterValues("product");

		HttpSession session = req.getSession();

		List<String> cart = (List<String>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<>();
		}

		if (selectedProducts != null) {
			for (String p : selectedProducts) {
				cart.add(p);
			}
		}

		session.setAttribute("cart", cart);//storing the updated cart to session

		resp.sendRedirect("onlineshopping2/viewCart.jsp");
	}
}