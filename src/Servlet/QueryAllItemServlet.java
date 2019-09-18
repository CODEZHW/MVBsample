package Servlet;

import Entity.Item;
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
@WebServlet(urlPatterns = "/QueryAllItemServlet")
public class QueryAllItemServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String value = "item";
        String ClassPath = Item.class.getName ();
        List list = QueryAllValueService.QueryAllValue (value , ClassPath ) ;
        request.getSession ().setAttribute ( "item_list", list );
        request.getRequestDispatcher ( "Contain.jsp" ).forward ( request, response );
    }
}
