package beans.admin;
public class ManagePlansAdminBean {
private String plan_id,plan_name,space_allowed,cost,validity_months,status,creation_date;

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
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

    public String getSpace_allowed() {
        return space_allowed;
    }

    public void setSpace_allowed(String space_allowed) {
        this.space_allowed = space_allowed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidity_months() {
        return validity_months;
    }

    public void setValidity_months(String validity_months) {
        this.validity_months = validity_months;
    }

}
