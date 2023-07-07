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
public class UserDTO {
    private String userID;
    private String lastName;
    private boolean roleID;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userID, String lastName, boolean roleID, String password) {
        this.userID = userID;
        this.lastName = lastName;
        this.roleID = roleID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getRoleID() {
        return roleID;
    }

    public void setRoleID(boolean roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
