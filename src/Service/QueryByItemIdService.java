package Service;

import Dao.QueryByItemIdDao;
import Entity.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/12
 * @Description: MVBsample
 * @version: 1.0
 */
public class QueryByItemIdService {
    public static List<Task> QueryByItemId ( int id ) throws SQLException, ClassNotFoundException {
       return   QueryByItemIdDao.QueryByItemId(id);
    }
}
