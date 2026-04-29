package com.chandru.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/home")
public class ServletLifecycle extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// super.init();
		System.out.println("servlet is initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		System.out.println("request handled successfully");
		PrintWriter out = resp.getWriter();
		out.println("request handled successfully");
		System.out.println("request handled2 successfully");
		out.println("req2 handled successfully");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		PrintWriter out = resp.getWriter();
		out.println("request3 handled successfully");
		System.out.println("request3 handled successfully");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// super.destroy();
		System.out.println("servlet destroyed");
	}

}
