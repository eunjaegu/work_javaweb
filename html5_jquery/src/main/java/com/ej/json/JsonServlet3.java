package com.ej.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet3
 */
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JSONObject total = new JSONObject();
		// 회원정보
		JSONArray memberArray = new JSONArray();
		JSONObject member = new JSONObject();
		member.put("name","홍길동");
		member.put("age", 100);
		member.put("gender", "남자");
		member.put("nickname", "대도");
		memberArray.add(member);
		total.put("members", memberArray);
		
		
		// 도서정보
				JSONArray bookArray = new JSONArray();
				JSONObject book = new JSONObject();
				book  = new JSONObject();	
				book.put("title","책제목");
				book.put("author", "작가");
				book.put("price", 30000);
				book.put("image", "http://localhost:9000/html5_jquery/image/image1.jpg");
				bookArray.add(book);
			
				book = new JSONObject();
				book.put("title","책제목1");
				book.put("author", "작가1");
				book.put("price", 40000);
				book.put("image", "http://localhost:9000/html5_jquery/image/image2.jpg");
				bookArray.add(book);
				
				total.put("books", bookArray);
				
				String info = total.toJSONString();
				out.print(info);
	
	}

}
