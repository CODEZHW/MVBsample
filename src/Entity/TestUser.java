package Entity;

/**
 * @authoer : zhw
 * @Date: 2019/9/7
 * @Description: MVBsample
 * @version: 1.0
 */
public class TestUser {
    private int id;
    private String name;
    private int source;
    private String password;

    @Override
    public String toString () {
        return "TestUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source=" + source +
                ", password='" + password + '\'' +
                '}';
    }

    public TestUser () {
    }

    public TestUser ( int id, String name, int source, String password ) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.password = password;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getSource () {
        return source;
    }

    public void setSource ( int source ) {
        this.source = source;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }
}
