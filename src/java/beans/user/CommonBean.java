package beans.user;
public class CommonBean {
 private String txtTitle,taComment,taEmailId,txtAuthor,txtType,txtDescription,txtLink,txtFileName;
    private int txtResourceId,txtUserId,txtSize;

    public String getTxtLink() {
        return txtLink;
    }

    public String getTxtFileName() {
        return txtFileName;
    }

    public void setTxtFileName(String txtFileName) {
        this.txtFileName = txtFileName;
    }

    public String getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }

    public void setTxtLink(String txtLink) {
        this.txtLink = txtLink;
    }

   
    public String getTxtType() {
        return txtType;
    }

    

    public int getTxtSize() {
        return txtSize;
    }

    public void setTxtSize(int txtSize) {
        this.txtSize = txtSize;
    }

    public void setTxtType(String txtType) {
        this.txtType = txtType;
    }

    public int getTxtUserId() {
        return txtUserId;
    }

    public void setTxtUserId(int txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtAuthor() {
        return txtAuthor;
    }

    public void setTxtAuthor(String txtAuthor) {
        this.txtAuthor = txtAuthor;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTaComment() {
        return taComment;
    }

    public void setTaComment(String taComment) {
        this.taComment = taComment;
    }

    public String getTaEmailId() {
        return taEmailId;
    }

    public void setTaEmailId(String taEmailId) {
        this.taEmailId = taEmailId;
    }

    public int getTxtResourceId() {
        return txtResourceId;
    }

    public void setTxtResourceId(int txtResourceId) {
        this.txtResourceId = txtResourceId;
    }
        
}
