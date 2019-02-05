/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin;

/**
 *
 * @author student
 */
public class ManageReportAbuseBean {
    
    private String txtType,reportDate,txtName,userStatus,txtTitle,txtDescription,txtFileName,taResponse,txtReportUser;
    private int txtId,txtSize,txtResourceId,txtReportId;

    public int getTxtReportId() {
        return txtReportId;
    }

    public String getTxtReportUser() {
        return txtReportUser;
    }

    public void setTxtReportUser(String txtReportUser) {
        this.txtReportUser = txtReportUser;
    }

    public void setTxtReportId(int txtReportId) {
        this.txtReportId = txtReportId;
    }

    public String getTaResponse() {
        return taResponse;
    }

    public void setTaResponse(String taResponse) {
        this.taResponse = taResponse;
    }
    
    
    
    public String getTxtFileName() {
        return txtFileName;
    }

    public int getTxtResourceId() {
        return txtResourceId;
    }

    public void setTxtResourceId(int txtResourceId) {
        this.txtResourceId = txtResourceId;
    }

    public void setTxtFileName(String txtFileName) {
        this.txtFileName = txtFileName;
    }
    

    public int getTxtSize() {
        return txtSize;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

    public void setTxtSize(int txtSize) {
        this.txtSize = txtSize;
    }

    public int getTxtId() {
        return txtId;
    }

    public void setTxtId(int txtId) {
        this.txtId = txtId;
    }

   

    public String getTxtType() {
        return txtType;
    }

    public void setTxtType(String txtType) {
        this.txtType = txtType;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }
    
}
