package com.ej;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHnadle(request, response);
	}			
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHnadle(request, response);
	}
	
/** doHandle() 내에서 해야할 일들
		1. request.getOutStream()를 이용하여 OutputStream 객체
		2. 배열로 버퍼 생성
		3. while() 을 이용하여 파일로부터 데이터를 한번에 ?byte만큼 읽기
		4. OutputStream의 write()로 브라우저로 출력
		
		1. 매개변수request로 전송된 파일 이름
		2. response에서 OutputStream객체
		3. 파일을 다운로드
		4. 버퍼를 이용하여 파일에 서버퍼로 데이터를 읽어 한번에 출력...

**/
	
	private void doHnadle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo="c:\\file_repo";
		// 1. 
		String fileName = (String)request.getParameter("fileName");
		System.out.println("fileName : " + fileName);
		
		// 2. 
		OutputStream out = response.getOutputStream();
		
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		
		//3.
		response.setHeader("Cache-Control", "no-cache");
		/**
		 * Content-disposition : 헤더를 사용하여 브라우저에게 파일을 어떻게 처리 할 지..
		 * attachment : 파일처리를 다운로드로.. 단, 파일이름이 필요.
		**/
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		
		FileInputStream in = new FileInputStream(f);
		
		//4. 
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
	}	//doHnadle()

}
