package Dao;

import DButil.util;
import Entity.Item;
import Entity.Staff;
import Entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
public class AddValueDao {
    public static boolean AddValue (String ele, Object object) {
        boolean falg = false;
        String sql = null;
        Connection con = null;
        PreparedStatement pstm = null;
        int count = 0;
        boolean flag = false;
        try {
            con = util.GetConnection ();

            if (ele.equals ( "item" )){
                sql = "insert into item (item_no, item_name, item_manager, item_desc, item_status) values (?,?,?,?,?);";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1, ((Item)object).getItem_no () );
                pstm.setObject ( 2, ((Item)object).getItem_name () );
                pstm.setObject ( 3, ((Item)object).getItem_manager () );
                pstm.setObject ( 4, ((Item)object).getItem_desc () );
                pstm.setObject ( 5, ((Item)object).getItem_status () );
            }else if (ele.equals ( "staff" )){
                sql ="insert into staff (staff_no, staff_name, e_mail, phone_no, security_level) values (?,?,?,?,?);";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1, ((Staff)object).getStaff_no () );
                pstm.setObject ( 2, ((Staff)object).getName () );
                pstm.setObject ( 3, ((Staff)object).getE_mail () );
                pstm.setObject ( 4, ((Staff)object).getPhone_no () );
                pstm.setObject ( 5, ((Staff)object).getSecurity_level () );
            }else if (ele.equals ( "task" )){
                sql = "insert into task (task_no, task_name, task_desc, task_of_item, task_priority, task_status, task_start_time, task_end_time, task_of_staff) values (?,?,?,?,?,?,?,?,?);";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1, ((Task)object).getTask_no () );
                pstm.setObject ( 2, ((Task)object).getTask_name () );
                pstm.setObject ( 3, ((Task)object).getTask_desc () );
                pstm.setObject ( 4, ((Task)object).getTask_of_item () );
                pstm.setObject ( 5, ((Task)object).getTask_priority () );
                pstm.setObject ( 6, ((Task)object).getTask_status () );
                pstm.setObject ( 7, ((Task)object).getTask_start_time () );
                pstm.setObject ( 8, ((Task)object).getTask_end_time () );
                pstm.setObject ( 9, ((Task)object).getTask_of_staff () );
            }
            count = pstm.executeUpdate ();
            if (count>0) flag = true;
        } catch (SQLException e) {
            e.printStackTrace ( );
        }finally {
            util.CloseConnection ( pstm,con );
        }
        return flag;
}
}
