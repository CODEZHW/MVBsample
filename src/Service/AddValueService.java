package Service;

import Dao.AddValueDao;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
public class AddValueService {
    public static boolean AddValue (String ele, Object object) {
        return AddValueDao.AddValue(ele, object);
    }
}
