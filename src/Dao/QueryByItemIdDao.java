package Dao;

import DButil.util;
import Entity.Item;
import Entity.Task;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/12
 * @Description: MVBsample
 * @version: 1.0
 */
public class QueryByItemIdDao {
    public static List<Task> QueryByItemId ( int id ) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        int count = 0;

        ResultSetMetaData rm = null;
        Class cla = Class.forName ( Task.class.getName () );
        List <Task> list = new ArrayList <Task> (  );
        try {
            con = util.GetConnection ();
            String sql = "select * from task where task_of_item = ? ;";
            pstm = con.prepareStatement ( sql );
            pstm.setObject ( 1, id );
            res = pstm.executeQuery ();
            rm = res.getMetaData ( );
            while (res.next ()){
                Task task = new Task ( );
                for (int i=0; i<rm.getColumnCount (); i++){
                    String columnName = rm.getColumnName ( i + 1 );
                    Object value = res.getObject ( i + 1 );
                    Field field = cla.getDeclaredField ( columnName );
                    field.setAccessible ( true );
                    field.set ( task ,value);
                }
                list.add ( task );
            }
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace ( );
        }finally {
            util.CloseConnection ( pstm,con );
        }
        return list;
    }
}
