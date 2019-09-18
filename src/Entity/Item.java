package Entity;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
public class Item {
    private int item_no;
    private String item_name;
    private int item_manager;
    private String item_desc;
    private String item_status;


    public int getItem_no () {
        return item_no;
    }

    public void setItem_no ( int item_no ) {
        this.item_no = item_no;
    }

    public String getItem_name () {
        return item_name;
    }

    public void setItem_name ( String item_name ) {
        this.item_name = item_name;
    }

    public int getItem_manager () {
        return item_manager;
    }

    public void setItem_manager ( int item_manager ) {
        this.item_manager = item_manager;
    }

    public String getItem_desc () {
        return item_desc;
    }

    public void setItem_desc ( String item_desc ) {
        this.item_desc = item_desc;
    }

    public String getItem_status () {
        return item_status;
    }

    public void setItem_status ( String item_status ) {
        this.item_status = item_status;
    }

    @Override
    public String toString () {
        return "Item{" +
                "item_no=" + item_no +
                ", item_name='" + item_name + '\'' +
                ", item_manager=" + item_manager +
                ", item_desc='" + item_desc + '\'' +
                ", item_status='" + item_status + '\'' +
                '}';
    }

    public Item () {
    }

    public Item ( int item_no, String item_name, int item_manager, String item_desc, String item_status ) {
        this.item_no = item_no;
        this.item_name = item_name;
        this.item_manager = item_manager;
        this.item_desc = item_desc;
        this.item_status = item_status;
    }
}
