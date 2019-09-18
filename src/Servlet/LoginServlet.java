package Servlet;


import Entity.Staff;
import Service.LoginService;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Map;

/**
 * @authoer : zhw
 * @Date: 2019/9/9
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet(name = "LoginServlet" ,value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    boolean flag = false;

    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        int flag = 0;
        Staff staff = new Staff ( );
        try {
            Map <String, String[]> parameterMap = request.getParameterMap ( );
            BeanUtils.populate ( staff,parameterMap );
            flag =  LoginService.login ( staff );
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        }
        if (flag == 2 ){
            response.sendRedirect ( "frame.jsp" );
            request.getSession ().setAttribute ( "user" ,staff);
        }
        else if (flag ==1){
            request.setAttribute ( "login_msg" ,"登录权限不够");
            request.getRequestDispatcher ( "login.jsp" ).forward ( request,response );
        }else {
            request.setAttribute ( "login_msg" ,"用户名或密码错误");
            request.getRequestDispatcher ( "login.jsp" ).forward ( request,response );
        }
    }
}
