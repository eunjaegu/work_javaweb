package filters;

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

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter(description = "한글 인코딩 필터", urlPatterns = { "/*" })
public class EncoderFilter implements Filter {
	ServletContext context;
	
    public EncoderFilter() {
    }

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		
		//디버깅 용
		String context = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String msg = "Context 정보 : " + context + " \nURI 정보 : " + pathInfo;
		System.out.println(msg);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see init : doFilter 전 호출
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩 준비");
		context = fConfig.getServletContext();
	}

}
