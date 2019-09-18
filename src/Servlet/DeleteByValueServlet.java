package Servlet;

import Service.DeleteByValueService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @authoer : zhw
 * @Date: 2019/9/10
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet( "/DeleteByValueServlet")
public class DeleteByValueServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        String object = null;
        String filed = null;
        String obj = request.getParameter ( "obj" );
        if (obj.contains ( "task" )){
            object = "task";
            filed = "task_no";
        }else if (obj.contains ( "item" )){
            object = "item";
            filed = "item_no";

        }else if(obj.contains ( "staff" )){
            object = "staff";
            filed = "staff_no";
        }
        String id =   request.getParameter ( "id" ) ;
        Object []values = {object, filed ,id};
        boolean flag = DeleteByValueService.DeleteByValue ( values );
        if (flag && object.equals ( "item" )){
            response.sendRedirect ( "QueryAllItemServlet" );
        }else if (flag && object.equals ( "task" )){
            response.sendRedirect ( "QueryAllTaskServlet" );
        }else if (flag && object.equals ( "staff" )){
            response.sendRedirect ( "QueryAllStaffServlet" );
        }
    }
}
