package Servlet;

import Entity.Item;
import Entity.Staff;
import Entity.Task;
import Service.AddValueService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        boolean flag = false;
        String element = (String) request.getSession ( ).getAttribute ( "element" );
        Object object = null;
        try {
            if (element.equals ( "item" )){
                object = new Item ( );
            } else if (element.equals ( "task")) {
                object = new Task ( );
            }else if (element.equals ( "staff")) {
                object = new Staff ( );
            }
            Map <String, String[]> parameterMap = request.getParameterMap ( );
            BeanUtils.populate ( object,parameterMap );
            flag = AddValueService.AddValue(element, object);
            if (flag && element.equals ( "staff" )){
                request.getRequestDispatcher ( "QueryAllStaffServlet" ).forward ( request,response );
            }else if (flag && element.equals ( "item" )){
                request.getRequestDispatcher ( "QueryAllItemServlet" ).forward ( request,response );
            } else if (flag && element.equals ( "task" )){
                request.getRequestDispatcher ( "QueryAllTaskServlet" ).forward ( request,response );
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace ( );
        }


    }
}
