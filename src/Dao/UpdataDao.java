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
public class UpdataDao {
    public static boolean updatadao (Object object, int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = null;
        boolean flag = false;
        int count = 0;
        try {
            con = util.GetConnection ();
            if (object instanceof Staff) {
                sql = "update staff set  staff_no =? , staff_name= ?, e_mail=?, phone_no=? ,security_level=?  where staff_no = ?;";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1,((Staff) object).getStaff_no () );
                pstm.setObject ( 2,((Staff) object).getName () );
                pstm.setObject ( 3,((Staff) object).getE_mail () );
                pstm.setObject ( 4,((Staff) object).getPhone_no () );
                pstm.setObject ( 5,((Staff) object).getSecurity_level () );
                pstm.setObject ( 6,id );
            } else if (object instanceof Task) {
                sql = "update task set  task_no =? , task_name= ?, task_desc=?, task_of_item=?,task_priority=?, task_status=?, task_start_time=?, task_end_time=?, task_of_staff where task_no = ?;";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1,((Task) object).getTask_no () );
                pstm.setObject ( 2,((Task) object).getTask_name () );
                pstm.setObject ( 3,((Task) object).getTask_desc () );
                pstm.setObject ( 4,((Task) object).getTask_of_item () );
                pstm.setObject ( 5,((Task) object).getTask_priority () );
                pstm.setObject ( 6,((Task) object).getTask_status () );
                pstm.setObject ( 7,((Task) object).getTask_start_time () );
                pstm.setObject ( 8,((Task) object).getTask_end_time () );
                pstm.setObject ( 9,((Task) object).getTask_of_staff () );
                pstm.setObject ( 10,id);
            }else if (object instanceof Item) {
                sql = "update item set  item_no =? , item_name= ?, item_desc=?, item_desc=?, item_status=? where item_no = ?;";
                pstm = con.prepareStatement ( sql );
                pstm.setObject ( 1,((Item) object).getItem_no () );
                pstm.setObject ( 2,((Item) object).getItem_name () );
                pstm.setObject ( 3,((Item) object).getItem_manager () );
                pstm.setObject ( 4,((Item) object).getItem_desc () );
                pstm.setObject ( 5,((Item) object).getItem_status () );
                pstm.setObject ( 6, id);

            }
            count = pstm.executeUpdate ();
            if (count>0){
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace ( );
        }finally {
            util.CloseConnection ( pstm,con );
        }
        return flag;
    }
}
