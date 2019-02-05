package beans.user;
public class HomeBean {
private String plan_name,start_date,end_date,user_id,plan_id;
private int space,free_space,used_space;

    public int getFree_space() {
        return free_space;
    }

    public void setFree_space(int free_space) {
        this.free_space = free_space;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getUsed_space() {
        return used_space;
    }

    public void setUsed_space(int used_space) {
        this.used_space = used_space;
    }

 
    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
  public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
