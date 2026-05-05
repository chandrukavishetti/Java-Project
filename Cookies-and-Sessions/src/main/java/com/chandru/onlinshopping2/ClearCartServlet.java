package com.chandru.onlinshopping2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/clear-cart")
public class ClearCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session != null) {
			session.removeAttribute("cart");
		}

		resp.sendRedirect("onlineshopping2/viewCart.jsp");
	}
}