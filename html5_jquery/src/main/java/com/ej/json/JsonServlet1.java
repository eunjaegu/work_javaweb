package com.ej.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class JsonServlet1
 */
@WebServlet("/json1")
public class JsonServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String jsonInfo = request.getParameter("jsonInfo");
		// JSON.parrse() 를 사용 못함!!!
		// JSONPaser parser = new JSOParser();
		try {
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject)parser.parse(jsonInfo);
			
			System.out.println(object.get("name"));
			System.out.println(object.get("age"));
			System.out.println(object.get("gender"));
			System.out.println(object.get("nickname"));
		} catch (Exception e) {
			System.out.println("JSONParser ERR" + e.getMessage());
		}
		
	}

}
