package Entity;

import java.sql.Date;

/**
 * @authoer : zhw
 * @Date: 2019/9/8
 * @Description: MVBsample
 * @version: 1.0
 */
public class Task {
    private int task_no;
    private String task_name;
    private String task_desc;
    private int task_of_item;
    private int task_priority;
    private String task_status;
    private Date task_start_time;
    private Date task_end_time;
    private Integer task_of_staff;

    public Task ( int task_no, String task_name, String task_desc, int task_of_item, int task_priority, String task_status, Date task_start_time, Date task_end_time, int task_of_staff ) {
        this.task_no = task_no;
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.task_of_item = task_of_item;
        this.task_priority = task_priority;
        this.task_status = task_status;
        this.task_start_time = task_start_time;
        this.task_end_time = task_end_time;
        this.task_of_staff = task_of_staff;
    }

    @Override
    public String toString () {
        return "Task{" +
                "task_no=" + task_no +
                ", task_name='" + task_name + '\'' +
                ", task_desc='" + task_desc + '\'' +
                ", task_of_item=" + task_of_item +
                ", task_priority=" + task_priority +
                ", task_status='" + task_status + '\'' +
                ", task_start_time=" + task_start_time +
                ", task_end_time=" + task_end_time +
                ", task_of_staff=" + task_of_staff +
                '}';
    }

    public int getTask_no () {
        return task_no;
    }

    public void setTask_no ( int task_no ) {
        this.task_no = task_no;
    }

    public String getTask_name () {
        return task_name;
    }

    public void setTask_name ( String task_name ) {
        this.task_name = task_name;
    }

    public String getTask_desc () {
        return task_desc;
    }

    public void setTask_desc ( String task_desc ) {
        this.task_desc = task_desc;
    }

    public int getTask_of_item () {
        return task_of_item;
    }

    public void setTask_of_item ( int task_of_item ) {
        this.task_of_item = task_of_item;
    }

    public int getTask_priority () {
        return task_priority;
    }

    public void setTask_priority ( int task_priority ) {
        this.task_priority = task_priority;
    }

    public String getTask_status () {
        return task_status;
    }

    public void setTask_status ( String task_status ) {
        this.task_status = task_status;
    }

    public Date getTask_start_time () {
        return task_start_time;
    }

    public void setTask_start_time ( Date task_start_time ) {
        this.task_start_time = task_start_time;
    }

    public Date getTask_end_time () {
        return task_end_time;
    }

    public void setTask_end_time ( Date task_end_time ) {
        this.task_end_time = task_end_time;
    }

    public int getTask_of_staff () {
        return task_of_staff;
    }

    public void setTask_of_staff ( int task_of_staff ) {
        this.task_of_staff = task_of_staff;
    }

    public Task () {
    }
}
