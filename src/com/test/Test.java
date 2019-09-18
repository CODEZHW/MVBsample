package com.test;

import DButil.util;
import Entity.TestUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
@WebServlet(name = "Test", urlPatterns = "/Test")
public class Test extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.doGet ( request,response );
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.getWriter().write("你好hello");

        TestUser testUser = new TestUser ( );
        request.setAttribute ( "name", "李四" );
        request.setAttribute ( "id" ,1);
        request.setAttribute ( "password","abc" );
        request.setAttribute ( "source", 50 );

        Map <String, String[]> parameterMap = request.getParameterMap ( );
        System.out.println (parameterMap );
        try {
            BeanUtils.populate ( testUser, parameterMap );
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        }
        System.out.println (testUser );
        response.getWriter().write("test");



    }
}
