package Dao;

import DButil.util;
import Entity.Staff;

import java.sql.*;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
public class LoginDao {

    public static int login( Staff staff ) {
        Connection con = null;
        int flag = 0;
        int sercurity =0;
        ResultSet res = null;
        PreparedStatement pstm = null;
        util util = new util ( );
        try {
            con = util.GetConnection ( );
            String sql ="select * from staff where log_id =? and password_id=?";
            pstm = con.prepareStatement ( sql );
            pstm.setString ( 1,staff.getLog_id () );
            pstm.setString ( 2,staff.getPassword_id () );
            res =  pstm.executeQuery ();
            ResultSetMetaData rm = res.getMetaData ( );
            int result = -1;
            if(res.next ()){
                result = res.getInt ( 1 );
                sercurity = res.getInt (7 );
            }
            if(result>0 && sercurity>1){
                flag = 2;
            }else if (result>0 ){
                flag = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace ( );
        }finally {
            util.CloseConnection ( res,pstm,con );
        }
        return flag;
    }


}
