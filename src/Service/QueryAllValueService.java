package Service;

import Dao.QueryAllValueDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/9
 * @Description: MVBsample
 * @version: 1.0
 */
public class QueryAllValueService {
    public static List QueryAllValue ( String value, String ClassPath ) {
        String sql = "select * from " + value;

        List list = null;
        try {
            list = QueryAllValueDao.opQuery ( sql, ClassPath );
        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (NoSuchMethodException e) {
            e.printStackTrace ( );
        } catch (IllegalAccessException e) {
            e.printStackTrace ( );
        } catch (InvocationTargetException e) {
            e.printStackTrace ( );
        } catch (InstantiationException e) {
            e.printStackTrace ( );
        } catch (NoSuchFieldException e) {
            e.printStackTrace ( );
        }
        return list;
    }
}
