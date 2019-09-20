/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Entity.*;
import client.AdminRestClient;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    Response res;
    User u;
    GenericType<User> usergeneric;
    LoginBean loginBean;
    String username;
    String password;
    AdminRestClient adminRestClient = new AdminRestClient();
    String message;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            .getExternalContext().getRequest();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {

    }

    public String login() {
        try {
            message = "";
//            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
//                    .getExternalContext().getRequest();

            HttpSession session = request.getSession();

            //Get All Data Of User 
           
            if (request.isUserInRole("admin")) {
                 u = new User();//entity class
            usergeneric = new GenericType<User>() {
            };
            res = adminRestClient.getUserByUsername_XML(Response.class, username);
            u = res.readEntity(usergeneric);

            request.login(username, password);

            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("fname", u.getFname());
            session.setAttribute("lname", u.getLname());
            session.setAttribute("email", u.getEmail());
            session.setAttribute("mobno", u.getMobno());
            session.setAttribute("photo", u.getPhoto());
            session.setAttribute("userid", u.getUserid());
            session.setAttribute("cdate", u.getCreatedon());
            session.setAttribute("skill", u.getSkillid().getSkill());
            session.setAttribute("skillid", u.getSkillid().getSkillid());
            session.setAttribute("descr", u.getDescription());
                return "/Admin/index.jsf?faces-redirect=true";
            } else if (request.isUserInRole("user")) {
                 u = new User();//entity class
            usergeneric = new GenericType<User>() {
            };
            res = adminRestClient.getUserByUsername_XML(Response.class, username);
            u = res.readEntity(usergeneric);

            request.login(username, password);

            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("fname", u.getFname());
            session.setAttribute("lname", u.getLname());
            session.setAttribute("email", u.getEmail());
            session.setAttribute("mobno", u.getMobno());
            session.setAttribute("photo", u.getPhoto());
            session.setAttribute("userid", u.getUserid());
            session.setAttribute("cdate", u.getCreatedon());
            session.setAttribute("skill", u.getSkillid().getSkill());
            session.setAttribute("skillid", u.getSkillid().getSkillid());
            session.setAttribute("descr", u.getDescription());
                return "/User/index.jsf?faces-redirect=true";
            } else {
                message = "Either Login or Password is wrong";
                return "/Login.jsf?faces-redirect=true";
            }
        } catch (Exception e) {
            message = "Either Login or Password is wrong" + e;
        }
        return null;
    }

    public String loginTest() {
        try {
            message = "";

            HttpSession session = request.getSession();

            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.login(username, password);

            if (request.isUserInRole("admin")) {
                return "/Admin/index.jsf?faces-redirect=true";
            } else if (request.isUserInRole("user")) {
                return "/User/index.jsf?faces-redirect=true";
            } else {
                message = "Either Login or Password is wrong";
                return "/Login.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            message = "Either Login or Password is wrong" + e;
        }
        return null;
    }

    public void goAdmin() throws IOException {
        redirect("/Admin/index.jsf");
    }

    public void goUser() throws IOException {
        redirect("/User/index.jsf");
    }

    public void goProfile() throws IOException {
        redirect("/Admin/Profile.jsf");
    }

    public void goUserProfile() throws IOException {
        redirect("/User/Profile.jsf");
    }

    public String Logout() throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
//                .getExternalContext().getRequest();

        request.logout();

        return "/Login.xhtml?faces-redirect=true";
    }

    private void redirect(String pagename) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(pagename);
    }

}
