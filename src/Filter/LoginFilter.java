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
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy () {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String url = request.getRequestURI ();
        Object user = request.getSession ().getAttribute ( "user" );
        if(url.contains ( "/login.jsp" ) || url.contains ( "/LoginServlet" )||user!=null){
            chain.doFilter ( req, resp );
        }else {
                request.setAttribute ( "login_msg" ,"您目前尚未登录!");
                request.getRequestDispatcher ( "/login.jsp" ).forward ( request,resp );
        }

    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
