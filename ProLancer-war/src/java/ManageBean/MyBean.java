/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

/**
 *
 * @author Dhiraj Chauhan
 */
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("myBean")
@RequestScoped
public class MyBean {

    // Init ---------------------------------------------------------------------------------------
    private String username;
    private String password;

    // Actions ------------------------------------------------------------------------------------
    public void register() {

        // Just for debug. Don't do this in real! Hash the password, save to DB and forget it ;)
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Show succes message.
        FacesContext.getCurrentInstance().addMessage("register", new FacesMessage("Succes!"));
    }

    // Getters ------------------------------------------------------------------------------------
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters ------------------------------------------------------------------------------------
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
