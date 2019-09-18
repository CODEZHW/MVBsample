package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @authoer : zhw
 * @Date: 2019/9/9
 * @Description: MVBsample
 * @version: 1.0
 */
@WebFilter(filterName = "CharactorFilter" ,urlPatterns = {"/*"})
public class CharactorFilter implements Filter {
    public void destroy () {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding ( "utf-8" );
        response.setCharacterEncoding ( "utf-8" );
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter ( request, response );
}

    public void init ( FilterConfig config ) throws ServletException {
    }

}
