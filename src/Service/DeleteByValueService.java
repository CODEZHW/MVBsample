package Service;

import Dao.DeleteByValueDao;

/**
 * @authoer : zhw
 * @Date: 2019/9/10
 * @Description: MVBsample
 * @version: 1.0
 */
public class DeleteByValueService {
    public static boolean DeleteByValue(Object[] values){
        return DeleteByValueDao.DeleteByObject ( values );
    }
}
