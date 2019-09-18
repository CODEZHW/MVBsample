package Dao;

import DButil.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/9
 * @Description: MVBsample
 * @version: 1.0
 */
public class QueryAllValueDao {
    /**
     *通用查询
     * @param sql 查询的sql语句
     * @param ClassPath 反射类路径
     * @param <T> 泛型类
     * @return 查询的全部结果的list集合
     */
    public static <T> List <T> opQuery ( String sql, String ClassPath ) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet res = null;
        ResultSetMetaData rm = null;
        Class cla = null;
        List<T>list = new ArrayList <> ();
        try {
            con = util.GetConnection ();
            pstm = con.prepareStatement ( sql );
            res = pstm.executeQuery ();
            rm =res.getMetaData ();
            cla = Class.forName ( ClassPath );
            while (res.next ()){
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        } finally {
            util.CloseConnection ( res,pstm,con );
        }

        return list;
    }
}
