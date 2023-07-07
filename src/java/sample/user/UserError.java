/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author flami
 */
public class UserError {
    private String userIDError;
    private String lastNameError;
    private String passwordError;
    private String roleIDError;
    private String confirmError;
    private String messageError;
    
    public UserError(){        
        this.userIDError = "";
        this.lastNameError = "";
        this.passwordError = "";
        this.roleIDError = "";
        this.confirmError = "";
        this.messageError="";
    }

    public UserError(String userIDError, String lastNameError, String passwordError, String roleIDError, String cinfirmError, String messageError) {
        this.userIDError = userIDError;
        this.lastNameError = lastNameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.confirmError = cinfirmError;
        this.messageError = messageError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String cinfirmError) {
        this.confirmError = cinfirmError;
    }
}
