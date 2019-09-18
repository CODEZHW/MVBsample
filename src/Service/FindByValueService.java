package Service;

import Dao.DeleteByValueDao;
import Dao.FindByValueDao;

import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
public class FindByValueService {
    public static  <T> T FindByValue ( Object[] values , String classPath) {
        return FindByValueDao.FindByValue ( values ,classPath);
    }
}
