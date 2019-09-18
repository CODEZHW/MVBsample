package DButil;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.test.DruidTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @authoer : zhw
 * @Date: 2019/9/7
 * @Description: MVBsample
 * @version: 1.0
 */
public  class util {
    private static  DataSource ds = null;

    static {
        init ();
    }

    public static void init(){
        try {
            Properties pp = new Properties (  );
            pp.load ( DruidTest.class.getClassLoader ().getResourceAsStream ( "DRUID.properties" ) );
            ds = DruidDataSourceFactory.createDataSource ( pp );
        } catch (IOException e) {
            e.printStackTrace ( );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }


    public static Connection GetConnection() throws SQLException {
        return ds.getConnection ();
    }


    public static void CloseConnection(ResultSet res ,PreparedStatement pstm,  Connection con){
        if(res!=null){
            try {
                res.close ();
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }
        if(pstm!=null){
            try {
                pstm.close ();
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }

        if(con!=null){
            try {
                con.close ();
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }
    }


    /**
     *
     * @param pstm
     * @param con
     */
    public static void CloseConnection(PreparedStatement pstm,  Connection con){
        if(pstm!=null){
            try {
                pstm.close ();
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }

        if(con!=null){
            try {
                con.close ();
            } catch (SQLException e) {
                e.printStackTrace ( );
            }
        }
    }


    public static void main ( String[] args ) {


    }
}
