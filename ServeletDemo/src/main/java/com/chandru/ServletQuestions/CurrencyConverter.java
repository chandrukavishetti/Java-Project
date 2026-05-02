package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/convert")
public class CurrencyConverter extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String amtStr = req.getParameter("amount");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h2> currency converter </h2>");

		int amt;

		try {
			amt = Integer.parseInt(amtStr);
		} catch (NumberFormatException ne) {
			System.out.println("please enter number only");
			return;
		}

		if (amt < 0) {
			System.out.println("please enter positve number ");
			return;
		}

		int inr;
		inr = amt * 95;

		out.println("You entered USD amount is : " + amt + "$ and coverted to INR : " + inr);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

}
