/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.user;

/**
 *
 * @author Aparchyanta
 */
public class AddEditMultimediaDetail {
    private String txtId, txtTitle, txtLabel, taDescription, taUsedFor, txtUsageYear, taTags, rbAccessType, ddlMediaType, txtuserId, flAudio_VideoFile;

    public String getFlAudio_VideoFile() {
        return flAudio_VideoFile;
    }

    public void setFlAudio_VideoFile(String flAudio_VideoFile) {
        this.flAudio_VideoFile = flAudio_VideoFile;
    }
private int fileSize;

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    public String getTxtuserId() {
        return txtuserId;
    }

    public void setTxtuserId(String txtuserId) {
        this.txtuserId = txtuserId;
    }

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

    public String getTxtLabel() {
        return txtLabel;
    }

    public void setTxtLabel(String txtLabel) {
        this.txtLabel = txtLabel;
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

    public String getTxtUsageYear() {
        return txtUsageYear;
    }

    public void setTxtUsageYear(String txtUsageYear) {
        this.txtUsageYear = txtUsageYear;
    }

    public String getTaTags() {
        return taTags;
    }

    public void setTaTags(String taTags) {
        this.taTags = taTags;
    }

    public String getRbAccessType() {
        return rbAccessType;
    }

    public void setRbAccessType(String rbAccessType) {
        this.rbAccessType = rbAccessType;
    }

    public String getDdlMediaType() {
        return ddlMediaType;
    }

    public void setDdlMediaType(String ddlMediaType) {
        this.ddlMediaType = ddlMediaType;
    }
}
