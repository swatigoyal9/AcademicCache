/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin;

/**
 *
 * @author Aparchyanta
 */
public class AddEditPlansAdminBean {
    private String plan_id, txtPlanName, txtSpaceAllowed, txtValidity, txtCost, rbStatus;

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getTxtPlanName() {
        return txtPlanName;
    }

    public void setTxtPlanName(String txtPlanName) {
        this.txtPlanName = txtPlanName;
    }

    public String getTxtSpaceAllowed() {
        return txtSpaceAllowed;
    }

    public void setTxtSpaceAllowed(String txtSpaceAllowed) {
        this.txtSpaceAllowed = txtSpaceAllowed;
    }

    public String getTxtValidity() {
        return txtValidity;
    }

    public void setTxtValidity(String txtValidity) {
        this.txtValidity = txtValidity;
    }

    public String getTxtCost() {
        return txtCost;
    }

    public void setTxtCost(String txtCost) {
        this.txtCost = txtCost;
    }

    public String getRbStatus() {
        return rbStatus;
    }

    public void setRbStatus(String rbStatus) {
        this.rbStatus = rbStatus;
    }
}
