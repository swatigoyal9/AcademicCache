/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.user;

/**
 *
 * @author Aparchyanta
 */
public class AddEditNewBookBean {
    private String txtId, txtTitle, txtAuthor, txtPublicationYear, taDescription, txtCategory, taTags, taBookUsedFor, txtUsageYear, rbAccessType, flBook, txtuserId;

    public String getTxtuserId() {
        return txtuserId;
    }

    public void setTxtuserId(String txtuserId) {
        this.txtuserId = txtuserId;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    private int fileSize;
    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtAuthor() {
        return txtAuthor;
    }

    public void setTxtAuthor(String txtAuthor) {
        this.txtAuthor = txtAuthor;
    }

    public String getTxtPublicationYear() {
        return txtPublicationYear;
    }

    public void setTxtPublicationYear(String txtPublicationYear) {
        this.txtPublicationYear = txtPublicationYear;
    }

    public String getTaDescription() {
        return taDescription;
    }

    public void setTaDescription(String taDescription) {
        this.taDescription = taDescription;
    }

    public String getTxtCategory() {
        return txtCategory;
    }

    public void setTxtCategory(String txtCategory) {
        this.txtCategory = txtCategory;
    }

    public String getTaTags() {
        return taTags;
    }

    public void setTaTags(String taTags) {
        this.taTags = taTags;
    }

    public String getTaBookUsedFor() {
        return taBookUsedFor;
    }

    public void setTaBookUsedFor(String taBookUsedFor) {
        this.taBookUsedFor = taBookUsedFor;
    }

    public String getTxtUsageYear() {
        return txtUsageYear;
    }

    public void setTxtUsageYear(String txtUsageYear) {
        this.txtUsageYear = txtUsageYear;
    }

    public String getRbAccessType() {
        return rbAccessType;
    }

    public void setRbAccessType(String rbAccessType) {
        this.rbAccessType = rbAccessType;
    }

    public String getFlBook() {
        return flBook;
    }

    public void setFlBook(String flBook) {
        this.flBook = flBook;
    }
}
