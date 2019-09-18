package Servlet;

import Entity.Item;
import Entity.Staff;
import Entity.Task;
import Service.UpdataService;
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
@WebServlet( "/UpdataServlet")
public class UpdataServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        boolean flag = false;
        String obj = (String) request.getSession ( ).getAttribute ( "obj_name" );
        Object object = null;
        Object object2 = null;
        int id = 0 ;
        if (obj.equals ( "task" )){
            obj = "task";
            object = new Task (  );
            object2 = request.getSession().getAttribute ( "value_list" );
            id =  ((Task) object2).getTask_no ();
        }else if (obj.equals ( "item" )){
            obj = "item";
            object = new Item (  );
            object2 = request.getSession().getAttribute ( "value_list" );
            id =  ((Item) object2).getItem_no ();
        }else if(obj.equals ( "staff" )){
            obj = "staff";
            object = new Staff (  );
            object2 = request.getSession().getAttribute ( "value_list" );
            id =  ((Staff) object2).getStaff_no ();
        }
        Map <String, String[]> parameterMap = request.getParameterMap ( );
        try {
            BeanUtils.populate ( object,parameterMap );
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        }
         flag =  UpdataService.updataservice(object ,id);
        if (flag && obj.equals ( "staff" )){
            request.getRequestDispatcher ( "QueryAllStaffServlet" ).forward ( request,response );
        }else if (flag && obj.equals ( "item" )){
            request.getRequestDispatcher ( "QueryAllItemServlet" ).forward ( request,response );
        } else if (flag && obj.equals ( "task" )){
            request.getRequestDispatcher ( "QueryAllTaskServlet" ).forward ( request,response );
        }

    }
}
