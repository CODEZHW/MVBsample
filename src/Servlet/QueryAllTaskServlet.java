package Servlet;

import Entity.Task;
import Service.QueryAllValueService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/10
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/QueryAllTaskServlet")
public class QueryAllTaskServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String value = "task";
        String ClassPath = Task.class.getName ();
        List list = QueryAllValueService.QueryAllValue (value , ClassPath ) ;
        request.setAttribute ( "task_list", list );
        request.getRequestDispatcher ( "Contain_task.jsp" ).forward ( request, response );
    }
}
