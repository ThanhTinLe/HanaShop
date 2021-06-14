/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.dtos;

import java.io.Serializable;

/**
 *
 * @author Ray Khum
 */
public class UserErrorDTO implements Serializable{

    String userNameError;
    String fullNameError;
    String passwordError;
    boolean roleError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userNameError, String fullNameError, String passwordError, boolean roleError) {
        this.userNameError = userNameError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.roleError = roleError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public boolean isRoleError() {
        return roleError;
    }

    public void setRoleError(boolean roleError) {
        this.roleError = roleError;
    }
    
    
}
