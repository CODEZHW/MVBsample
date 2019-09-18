package Entity;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
public class Staff {
    private int staff_no;
    private String staff_name;
    private String log_id;
    private String password_id;
    private String e_mail;
    private String phone_no;
    private int security_level;

    public Staff () {
    }

    public Staff ( int staff_no, String staff_name, String log_id, String password_id, String e_mail, String phone_no, int security_level ) {
        this.staff_no = staff_no;
        this.staff_name = staff_name;
        this.log_id = log_id;
        this.password_id = password_id;
        this.e_mail = e_mail;
        this.phone_no = phone_no;
        this.security_level = security_level;
    }

    @Override
    public String toString () {
        return "Staff{" +
                "staff_no=" + staff_no +
                ", name='" + staff_name + '\'' +
                ", log_id='" + log_id + '\'' +
                ", password_id='" + password_id + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", security_level=" + security_level +
                '}';
    }

    public int getStaff_no () {
        return staff_no;
    }

    public void setStaff_no ( int staff_no ) {
        this.staff_no = staff_no;
    }

    public String getName () {
        return staff_name;
    }

    public void setName ( String staff_name ) {
        this.staff_name = staff_name;
    }

    public String getLog_id () {
        return log_id;
    }

    public void setLog_id ( String log_id ) {
        this.log_id = log_id;
    }

    public String getPassword_id () {
        return password_id;
    }

    public void setPassword_id ( String password_id ) {
        this.password_id = password_id;
    }

    public String getE_mail () {
        return e_mail;
    }

    public void setE_mail ( String e_mail ) {
        this.e_mail = e_mail;
    }

    public String getPhone_no () {
        return phone_no;
    }

    public void setPhone_no ( String phone_no ) {
        this.phone_no = phone_no;
    }

    public int getSecurity_level () {
        return security_level;
    }

    public void setSecurity_level ( int security_level ) {
        this.security_level = security_level;
    }
}