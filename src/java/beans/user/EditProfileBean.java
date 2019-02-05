/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.User;

/**
 *
 * @author nb
 */
public class EditProfileBean {
    private String txtName,ddlQualification,txtCountry,txtState,txtCity;
    private int ddlCountry,ddlState,ddlCity;

    public String getTxtCountry() {
        return txtCountry;
    }

    public void setTxtCountry(String txtCountry) {
        this.txtCountry = txtCountry;
    }

    public String getTxtState() {
        return txtState;
    }

    public void setTxtState(String txtState) {
        this.txtState = txtState;
    }

    public String getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(String txtCity) {
        this.txtCity = txtCity;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getDdlQualification() {
        return ddlQualification;
    }

    public void setDdlQualification(String ddlQualification) {
        this.ddlQualification = ddlQualification;
    }

    public int getDdlCountry() {
        return ddlCountry;
    }

    public void setDdlCountry(int ddlCountry) {
        this.ddlCountry = ddlCountry;
    }

    public int getDdlState() {
        return ddlState;
    }

    public void setDdlState(int ddlState) {
        this.ddlState = ddlState;
    }

    

   

    public int getDdlCity() {
        return ddlCity;
    }

    public void setDdlCity(int ddlCity) {
        this.ddlCity = ddlCity;
    }
    
    
    
}
