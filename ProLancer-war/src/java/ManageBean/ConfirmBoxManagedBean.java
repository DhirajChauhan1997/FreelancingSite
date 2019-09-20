/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "confirmBoxManagedBean")
@Dependent
public class ConfirmBoxManagedBean {

    /**
     * Creates a new instance of ConfirmBoxManagedBean
     */
    public ConfirmBoxManagedBean() {
    }

    public void confirm() {
        addMessage("Delete record", "Record has been deleted.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
