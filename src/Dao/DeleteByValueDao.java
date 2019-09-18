package Dao;

import DButil.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @authoer : zhw
 * @Date: 2019/9/10
 * @Description: MVBsample
 * @version: 1.0
 */
public class DeleteByValueDao {
    /**
     *
     * @param values 判断删除的对象和根据什么删除
     * @return 返回是否执行成功
     */
    public static boolean DeleteByObject(Object[] values){
        Connection con = null;
        PreparedStatement pstm = null;
        int count = 0;
        boolean flag = false;
        try {
            con = util.GetConnection ();
            String sql = " delete from "+values[0]+" where " +values[1]+ " = ?";
            pstm = con.prepareStatement ( sql );
            pstm.setObject ( 1, values[2] );
            count = pstm.executeUpdate ();
            if (count>0){
                System.out.println ( "删除成功" );
                flag = true;
            }else{
                System.out.println ( "删除失败" );
            }
        } catch (SQLException e) {
            e.printStackTrace ( );
        }finally {
            util.CloseConnection ( pstm,con );
        }
        return flag;
    }
}
