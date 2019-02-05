/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.user;

/**
 *
 * @author Aparchyanta
 */
public class AddEditWebLinkBean {
    private String  txtId,txtTitle, txtLink, taDescription, taUsedFor, txtCategory, rbAccessType, taTags, txtuserId;

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }
    public String getTxtTitle() {
        return txtTitle;
    }

    public String getTxtuserId() {
        return txtuserId;
    }

    public void setTxtuserId(String txtuserId) {
        this.txtuserId = txtuserId;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtLink() {
        return txtLink;
    }

    public void setTxtLink(String txtLink) {
        this.txtLink = txtLink;
    }

    public String getTaDescription() {
        return taDescription;
    }

    public void setTaDescription(String taDescription) {
        this.taDescription = taDescription;
    }

    public String getTaUsedFor() {
        return taUsedFor;
    }

    public void setTaUsedFor(String taUsedFor) {
        this.taUsedFor = taUsedFor;
    }

    public String getTxtCategory() {
        return txtCategory;
    }

    public void setTxtCategory(String txtCategory) {
        this.txtCategory = txtCategory;
    }

    public String getRbAccessType() {
        return rbAccessType;
    }

    public void setRbAccessType(String rbAccessType) {
        this.rbAccessType = rbAccessType;
    }

    public String getTaTags() {
        return taTags;
    }

    public void setTaTags(String taTags) {
        this.taTags = taTags;
    }
}
