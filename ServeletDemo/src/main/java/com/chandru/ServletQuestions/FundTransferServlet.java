package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/fundtransfer")
public class FundTransferServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String sourceStr = req.getParameter("source");
		String destinationStr = req.getParameter("destination");
		String amountStr = req.getParameter("amount");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Fund Transfer System </h2>");

		boolean isValid = true;

		int source = 0;
		try {
			source = Integer.parseInt(sourceStr);
			if (source < 0) {
				out.println("<p style='color:red'>source must be positive!</p>");
				isValid = false;
			}
		} catch (NumberFormatException e) {
			out.println("<p style='color:red'>enter positive account number only</p>");
			isValid = false;
		}

		int destination = 0;
		try {
			destination = Integer.parseInt(sourceStr);
			if (destination < 0) {
				out.println("<p style='color:red'>destination must be positive account number</p>");
				isValid = false;
			}
		} catch (NumberFormatException e) {
			out.println("<p style='color:red'>enter positive account number only</p>");
			isValid = false;
		}
		int amount = 0;
		try {
			amount = Integer.parseInt(amountStr);
			if (amount < 0 || amount <= 50000) {
				out.println("<p style='color:orange'> amount should be positive and below 50000</p>");
				isValid = false;
			}
		} catch (NumberFormatException e) {
			out.println("<p style='color:red'> enter correct input");
			isValid = false;
		}
		if (!isValid) {
			out.println("Transaction is Failed");
		} else {
			out.println("Transaction is Successful");
		}

		out.println("Source Account is : " + source);
		out.println("Destination Account is : " + destination);
		out.println("Amount is  : " + amount);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

}