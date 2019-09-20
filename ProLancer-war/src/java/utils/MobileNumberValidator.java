/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Dhiraj Chauhan
 */
@FacesValidator("mobnovalidator")
public class MobileNumberValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String mobNo=(String) value;
        int mobNoLength=mobNo.length();
        if(mobNoLength < 10 && mobNoLength > 10){
            ((UIInput)component).setValid(false);
        }
        FacesMessage msg=new FacesMessage("In Valid Mobile No");
        context.addMessage(component.getClientId(context), msg);
    }
    
}
