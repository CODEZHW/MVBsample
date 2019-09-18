package Service;

import Dao.UpdataDao;

/**
 * @authoer : zhw
 * @Date: 2019/9/11
 * @Description: MVBsample
 * @version: 1.0
 */
public class UpdataService {
    public static boolean updataservice (Object object, int id) {
        return UpdataDao.updatadao(object, id);
    }
}
