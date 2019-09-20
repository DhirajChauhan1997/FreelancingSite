/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Entity.*;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "headerMB")
@RequestScoped
public class HeaderMB {

    int userid;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            .getExternalContext().getRequest();
    HttpSession session = request.getSession();

    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    String email = (String) session.getAttribute("email");
    String mobno = (String) session.getAttribute("mobno");
    String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String photo = (String) session.getAttribute("photo");
    String cdate = (String) session.getAttribute("cdate");
    String skill = (String) session.getAttribute("skill");
    String descr = (String) session.getAttribute("descr");
//    String uname = (String) session.getAttribute("username");

    public HeaderMB() {

    }

}
