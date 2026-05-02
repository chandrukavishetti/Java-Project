package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/stock")
public class ProductStockChecker extends HttpServlet {

	private HashMap<Integer, String[]> products;

	@Override
	public void init() throws ServletException {

		products = new HashMap<>();
		products.put(1, new String[] { "Phone", "Yes", "10" });
		products.put(2, new String[] { "Washing Machine", "No", "0" });
		products.put(3, new String[] { "Wheat", "Yes", "100" });
		products.put(4, new String[] { "Toothpaste", "No", "0" });
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("productId");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Product Stock Details</h2>");

		if (idStr == null || idStr.trim().isEmpty()) {
			out.println("<p style='color:red;'>Product ID cannot be empty!</p>");
			return;
		}

		int id;

		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			out.println("<p style='color:red;'>Invalid ID format! Please enter number only </p>");
			return;
		}

		if (!products.containsKey(id)) {
			out.println("<p style='color:red;'>Invalid Product ID! No data found.</p>");
			return;
		}

		String[] data = products.get(id);

		out.println("<p><b>Product Name:</b> " + data[0] + "</p>");
		out.println("<p><b>Available:</b> " + data[1] + "</p>");
		out.println("<p><b>Stock Count:</b> " + data[2] + "</p>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}