package com.test;

import DButil.util;
import Entity.Staff;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/7
 * @Description: MVBsample
 * @version: 1.0
 */
public class DruidTest {

    /**
     *根据值进行单一查询， 查询一个项目的信息，查询一个项目下所有任务的信息。
     * @param values 根据什么值查询
     * @param ClassPath 反射类路径
     * @param <T> 泛型类
     * @return 查询结果的集合
     */
    public static <T> List<T> opQueryByValue ( String[] values, String ClassPath ) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet res = null;
        ResultSetMetaData rm = null;
        Class cla = null;
        List<T>list = new ArrayList <> ();
        try {
            con = util.GetConnection ();
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        String sql =" select * from ? where ? = ?";

        pstm = con.prepareStatement ( sql );

//        pstm.setString ( 1,"47001" );
        res = pstm.executeQuery ();
        rm =res.getMetaData ();
        try {
            cla = Class.forName ( ClassPath );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }
        System.out.println (res.next () );
        while (res.next () ){
            System.out.println ("test1" );
            T m = (T) cla.getDeclaredConstructor ( ).newInstance ( );
            for (int i=0; i<rm.getColumnCount (); i++){
                String columnName = rm.getColumnName ( i + 1 );
                Object value = res.getObject ( i + 1 );
                Field field = cla.getDeclaredField ( columnName );
                field.setAccessible ( true );
                field.set ( m ,value);
            }
            list.add ( m );
        }
        System.out.println (list );
        return list;
    }
    /**
     *
     * @param sql 执行增加操作的mysql语句
     * @param values 要添加对象的值
     * @return 返回是否执行成功
     */
    public static boolean InserintoObject(String sql,Object[] values){
        Connection con = null;
        PreparedStatement pstm = null;
        int count = 0;

        try {
            con = util.GetConnection ();
            pstm = con.prepareStatement ( sql );

            for (int i =0; i<values.length-1; i++){
                pstm.setObject ( i+1, values[i+1] );
            }
            count = pstm.executeUpdate ();
            if (count > 0){
                System.out.println ("增加成功" );
                return true;
            }else {
                System.out.println ( "增加失败" );
            }
        } catch (SQLException e) {
            e.printStackTrace ( );
        } finally {
            util.CloseConnection ( pstm,con );
        }

        return false;
    }


public static int test(){
    String sql =  "update item set  item_no =17007 , item_name= 'test3', item_desc=47004, item_desc='test', item_status='执行' where item_no = 17007;";
    Connection con = null;
    PreparedStatement pstm = null;
    int count = 0;

    try {
        con = util.GetConnection ();
        pstm = con.prepareStatement ( sql );

        count = pstm.executeUpdate ();
        System.out.println (count );
    } catch (SQLException e) {
        e.printStackTrace ( );
    } finally {
        util.CloseConnection ( pstm,con );
    }
    return count;
    }


    public static <T> T FindByValue ( Object[] values , String ClassPath ) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean flag = false;
        Class cla = null;
        T m = null;
        try {
            cla = Class.forName ( ClassPath );
            con = util.GetConnection ();
            String sql = " select * from "+values[0]+" where " +values[1]+ " = ?";
            pstm = con.prepareStatement ( sql );
            pstm.setObject ( 1, values[2] );
            res = pstm.executeQuery ();
            ResultSetMetaData rm = res.getMetaData ( );
            while (res.next ()){
                m = (T) cla.getDeclaredConstructor ( ).newInstance ( );
                for (int i=0; i<rm.getColumnCount (); i++){
                    String columnName = rm.getColumnName ( i + 1 );
                    Object value = res.getObject ( i + 1 );
                    Field field = cla.getDeclaredField ( columnName );
                    field.setAccessible ( true );
                    field.set ( m ,value);
                }
            }
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace ( );
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InstantiationException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        } catch (NoSuchFieldException e) {
            e.printStackTrace ( );
        } finally {
            util.CloseConnection ( res,pstm,con );
        }
        return  m;
    }

    public static void main ( String[] args ) throws Exception {
        int count = test ();
    }
}


