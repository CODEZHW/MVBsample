package Entity;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
public class TestProduct {
    private int id;
    private String name;
    private float price;

    public TestProduct () {
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

    public float getPrice () {
        return price;
    }

    public void setPrice ( float price ) {
        this.price = price;
    }

    @Override
    public String toString () {
        return "TestProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public TestProduct ( int id, String name, float price ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
