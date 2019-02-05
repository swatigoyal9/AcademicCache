/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.common;

/**
 *
 * @author Aparchyanta
 */
public class SignUpBean {
    private String txtUsername, txtPassword, txtConfirmationCode,user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTxtConfirmationCode() {
        return txtConfirmationCode;
    }

    public void setTxtConfirmationCode(String txtConfirmationCode) {
        this.txtConfirmationCode = txtConfirmationCode;
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

   
}
