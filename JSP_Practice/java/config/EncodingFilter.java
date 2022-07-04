package config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")									// 필터의 url mapping, 필터와 url pattern 매핑
public class EncodingFilter implements Filter {
	// /* 모든 url
	// init() 필터초기화
	// destroy()  필터제거 (서버가 shutdown될 때)
	// doFilter() 필터실행 (서버가 start될 때)
	private String charset="utf-8";
	
	public void destroy() {
		System.out.println("필터종료");
	}

	// 요청이 들어올 때 거쳐가는 코드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);		// 선처리할 코드
		// System.out.println("필터실행");
		chain.doFilter(request, response);
	}

	// 필터를 초기화시킴
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 초기화");
	}
}
