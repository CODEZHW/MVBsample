package Service;

import Dao.LoginDao;
import Entity.Staff;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.sql.SQLException;

/**
 * @authoer : zhw
 * @Date: 2019/9/9
 * @Description: MVBsample
 * @version: 1.0
 */
public class LoginService {
    public static int login( Staff staff ) {
        return LoginDao.login ( staff );
    }
}
