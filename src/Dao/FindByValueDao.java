package Dao;

import DButil.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
public class FindByValueDao {


    public static <T> T FindByValue ( Object[] values , String ClassPath ) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
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
}