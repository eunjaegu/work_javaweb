package com.ej;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/Upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} //doGet()


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}	//doPost()
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// 파일 객체
		File currentPath = new File("c:/file_repo");
		
		// 파일 업로드를 위한 설정 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentPath);
		factory.setSizeThreshold(1024*1024);
		
		// 서블릿 파일 업로드 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 외부 자원 다루기
		try {
			List items = upload.parseRequest(request);
			
			for(int i=0; i<items.size(); i++) {
				System.out.println("업로드 할 데이터 추출 시작");
				
				FileItem fileitem = (FileItem)items.get(i);	// 형변환
				
				/**FileItem.isFormField() : boolean
				 * FileItem오브젝트에 저장되어 있는 값이 파일데이터인지
				 * 그외의 <form> 데이터인지를 판단.
				 * 그 밖의 <form> 데이터의 경우는 true을 반환하고,
				 * 파일데이터의 경우는 false을 반환
				 **/
				
				if(fileitem.isFormField()) {
					System.out.println(fileitem.getFieldName() + "" + fileitem.getString("utf-8"));
					
				}else {
					System.out.println("==>매개변수명" + fileitem.getFieldName());
					System.out.println("==>파일명" + fileitem.getName());
					System.out.println("==>파일의 크기" + fileitem.getSize() + "byte");
					
				if(fileitem.getSize()>0) {
					int idx = fileitem.getName().lastIndexOf("\\");
					System.out.println("==>\\의 index 번호 : " + idx);
					
					if(idx == -1) {
						idx = fileitem.getName().lastIndexOf("/");
						System.out.println("==>/의 index 번호 : " + idx);
					}
					
					String fileName = fileitem.getName().substring(idx+1);
					System.out.println("==>파일 이름 : " + fileitem.getName().substring(idx+1));
					System.out.println("==>저장될 파일 : " + currentPath + "\\" + fileName);
					File uploadFile = new File(currentPath + "\\" + fileName);
					fileitem.write(uploadFile);
					
				}// if(fileitem.getSize()) {}else{} END
				}// if(fileitem.isFormField()) {}else{} END
			}
			
		}catch (Exception e) {
			System.err.println("FILE UPLOAD FAIL!!!!!!");
		}
		
		
	} //doHandle()

}
