package com.freeflux.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


//@WebFilter(description = "한글 인코딩 기능을 구현", 
//			urlPatterns = { "/*" })	// WebFilter 애너테이션을 이용해 모든 요청이 필터를 거친다.
public class CharacterEncoderFilter implements Filter {
	ServletContext context;

    public CharacterEncoderFilter() {
    	System.out.println("EncoderFilter 생성자......");
    }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩............");
	    context = fConfig.getServletContext();
	}

	

	/** doFilter() 안에서 실제 필터 기능을 구현 **/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter 호출");
		
	    request.setCharacterEncoding( "utf-8" ); // 한글 인코딩 설정 작업
	    
	    String context= ((HttpServletRequest)request).getContextPath(); //  애플리케이션의 컨텍스트 이름
	    String pathinfo = ((HttpServletRequest)request).getRequestURI(); // 웹 브라우저에서 요청한 요청 URI
	    String realPath = request.getRealPath( pathinfo); //  요청 URI의 실제 경로
	    
//	    String mesg = " Context 정보:" + context + "\n URI 정보 : " + pathinfo  + "\n 물리적 경로: " + realPath;
	    String mesg = " Context 정보:" + context;
	    		
	    System.out.println(mesg);
	    
	    // 요청 필터에서 요청 처리 전의 시각
	    long begin = System.currentTimeMillis();
	    /** doFilter() 메서드를 기준 위쪽에 위치한 코드는 요청 필터 기능을 수행 **/
	    
	    chain.doFilter(request, response);  // 다음 필터로 넘기는 작업을 수행
//		chain.doFilter(request, response);
		
		/** doFilter() 메서드를 기준 아래에 위치한 코드는 응답 필터 기능을 수행 **/
	    response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    // 응답 필터에서 요청 처리 후의 시각
		long end = System.currentTimeMillis(); 
		
		// 작업 요청 전과 후의 시각 차를 구해 작업 수행 시간
	    System.out.println("작업 시간:"+(end-begin)+"ms");
	}
	
	

	public void destroy() {
		System.out.println("EncoderFilter 소멸......");
	}


}
