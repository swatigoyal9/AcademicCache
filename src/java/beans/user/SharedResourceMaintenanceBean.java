package beans.user;
public class SharedResourceMaintenanceBean {
private String share_id,id,title,type,share_code,date_shared,comment,emails_shared_with,user_id,upload_path,resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getUpload_path() {
        return upload_path;
    }

    public void setUpload_path(String upload_path) {
        this.upload_path = upload_path;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate_shared() {
        return date_shared;
    }

    public void setDate_shared(String date_shared) {
        this.date_shared = date_shared;
    }

    public String getEmails_shared_with() {
        return emails_shared_with;
    }

    public void setEmails_shared_with(String emails_shared_with) {
        this.emails_shared_with = emails_shared_with;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShare_code() {
        return share_code;
    }

    public void setShare_code(String share_code) {
        this.share_code = share_code;
    }

    public String getShare_id() {
        return share_id;
    }

    public void setShare_id(String share_id) {
        this.share_id = share_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_id(int parseInt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
