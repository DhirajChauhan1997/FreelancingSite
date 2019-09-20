/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dhiraj Chauhan
 */
public class Utils {

    public void redirect(String pagename) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(pagename);
    }
}
