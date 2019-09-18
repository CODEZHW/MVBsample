package Servlet;

import Entity.Task;
import Service.QueryByItemIdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @authoer : zhw
 * @Date: 2019/9/12
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet( "/QueryByItemIdServlet")
public class QueryByItemIdServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Map <String, String[]> parameterMap = request.getParameterMap ( );
        System.out.println (parameterMap );
        String[] string_id = parameterMap.get ( "id" );
        List<Task> list = new ArrayList <Task> (  );
        int id = Integer.parseInt (  string_id[0] ) ;
        System.out.println (id );
        try {
           list = QueryByItemIdService. QueryByItemId( id);
        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }
        request.getSession ().setAttribute ( "task_list" ,list);
        request.getRequestDispatcher ( "contain_value.jsp" ).forward ( request,response );
    }
}
