package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherInfoServlet extends HttpServlet {

	private static final Map<String, String[]> weatherData = new HashMap<>();

	static {
		weatherData.put("delhi", new String[] { "40°C", "60%", "Sunny" });
		weatherData.put("mumbai", new String[] { "32°C", "80%", "Rainy" });
		weatherData.put("bengaluru", new String[] { "28°C", "70%", "Cloudy" });
		weatherData.put("chennai", new String[] { "35°C", "75%", "Hot" });
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h2>Weather Report</h2>");

		if (city == null || city.trim().isEmpty()) {
			out.println("<p style='color:red;'>City name cannot be empty!</p>");
			return;
		}

		city = city.toLowerCase();

		// Check city exists
		if (!weatherData.containsKey(city)) {
			out.println("<p style='color:red;'>Invalid city! No data available.</p>");
			return;
		}

		String[] data = weatherData.get(city);

		out.println("<p>City: " + city.toUpperCase() + "</p>");
		out.println("<p>Temperature: " + data[0] + "</p>");
		out.println("<p>Humidity: " + data[1] + "</p>");
		out.println("<p>Forecast: " + data[2] + "</p>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}

// @Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String city = request.getParameter("city");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Weather Info - " + city + "</title>");
//		out.println("<style>");
//		out.println(
//				"body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #00b4db, #0083b0); height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0; }");
//		out.println(
//				".card { background: white; padding: 2rem; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); width: 350px; text-align: center; }");
//		out.println("h2 { color: #333; margin-bottom: 0.5rem; }");
//		out.println(".city-name { color: #0083b0; font-size: 1.5rem; font-weight: bold; margin-bottom: 1.5rem; }");
//		out.println(
//				".stat { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #eee; color: #555; }");
//		out.println(".stat:last-child { border-bottom: none; }");
//		out.println(".value { font-weight: bold; color: #222; }");
//		out.println(
//				".btn { margin-top: 20px; display: inline-block; text-decoration: none; background: #0083b0; color: white; padding: 8px 20px; border-radius: 5px; transition: 0.3s; }");
//		out.println(".btn:hover { background: #005f7a; }");
//		out.println("</style>");
//		out.println("</head>");
//		out.println("<body>");
//
//		out.println("<div class='card'>");
//		out.println("  <h2>Weather Teller</h2>");
//		out.println("  <div class='city-name'>" + city + "</div>");
//
//		out.println("  <div class='stat'><span>Humidity</span> <span class='value'>100%</span></div>");
//		out.println("  <div class='stat'><span>Temperature</span> <span class='value'>45°C</span></div>");
//		out.println("  <div class='stat'><span>Rain Chance</span> <span class='value'>89%</span></div>");
//
//		out.println("</div>");
//
//		out.println("</body>");
//		out.println("</html>");
//	}
