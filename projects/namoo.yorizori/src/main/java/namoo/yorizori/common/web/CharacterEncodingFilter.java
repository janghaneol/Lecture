package namoo.yorizori.common.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(
		description = "문자 인코딩 필터", 
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingFilter extends HttpFilter implements Filter {
	private String encoding;
	
	
	public void init(FilterConfig fConfig) throws ServletException {
			encoding = fConfig.getInitParameter("encoding");
	}
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		POST 요청에 대한 문자 인코딩 설정
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset=" + encoding);
		
		chain.doFilter(request, response);
	}

	
	

}
