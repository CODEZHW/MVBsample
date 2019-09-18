package Servlet;

import Entity.Item;
import Entity.Staff;
import Entity.Task;
import Service.DeleteByValueService;
import Service.FindByValueService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet( "/FindByValueServlet")
public class FindByValueServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String object = null;
        String filed = null;
        String classPath = null;
        String id = request.getParameter ( "id" );
        String obj = request.getParameter ( "obj" );
        if (obj.contains ( "task" )){
            object = "task";
            filed = "task_no";
            classPath = Task.class.getName ();
        }else if (obj.contains ( "item" )){
            object = "item";
            filed = "item_no";
            classPath = Item.class.getName ();
        }else if(obj.contains ( "staff" )){
            object = "staff";
            filed = "staff_no";
            classPath = Staff.class.getName ();
        }
        Object [] values = {object,filed, id };
        Object bean = FindByValueService.FindByValue (values ,classPath);
        request.getSession ().setAttribute ( "value_list", bean );
        if (bean instanceof Staff) {
            request.getRequestDispatcher ( "Updata_Staff.jsp" ).forward ( request,response );
        } else if (bean instanceof Task) {
            request.getRequestDispatcher ( "Updata_Task.jsp" ).forward ( request,response );
        }else if (bean instanceof Item) {
            request.getRequestDispatcher ( "Updata.jsp" ).forward ( request,response );
        }

    }
}
