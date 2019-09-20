/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import EJB.AdminSessionBeanLocal;
import Entity.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yogi_gmt
 */
@Named(value = "changepass")
@RequestScoped
public class Changepass {

    @EJB
    AdminSessionBeanLocal asbl;
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession session = request.getSession();

    String username = (String) session.getAttribute("username");
    String password, cpassword, fname, lname, photo, decr, createdon, email, mobno;
    int skillid, userid, groupid;

    Changepass c;
    User u;

    public void changeUserPassword() throws IOException {
        c = new Changepass();
        u = new User();
        u = asbl.getOldpassData(username, password);

        u.setFname(c.getFname());
        u.setLname(c.getLname());
        u.setUserid(c.getUserid());
        u.setMobno(c.getMobno());
        u.setEmail(c.getEmail());
        u.setPassword(c.getPassword());
        u.setCreatedon(c.getCreatedon());
        u.setDescription(c.getDecr());
        u.setPhoto(c.getPhoto());
        asbl.updateUser(u, skillid);
        redirect("Profile.jsf");

    }

    private void redirect(String url) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(url);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDecr() {
        return decr;
    }

    public void setDecr(String decr) {
        this.decr = decr;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public int getSkillid() {
        return skillid;
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public Changepass() {
    }

}
