/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean.User;

import EJB.AdminSessionBeanLocal;
import Entity.Grouptbl;
import Entity.Skill;
import Entity.User;
import ManageBean.UserManageBean;
import client.AdminRestClient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "userMB")
@ViewScoped
public class UserMB implements Serializable {

    @EJB
    AdminSessionBeanLocal asbl;
    String username, password, cpassword, fname, lname, photo, decr, createdon, email, mobno;
    int skillid, userid, groupid;
    User u;
    private Part userImage;

    private final String folder = "D://ICT_Sem1/ProLancer/ProLancer-war/web/userimg";

    public Part getUserImage() {
        return userImage;
    }

    public void setUserImage(Part userImage) {
        this.userImage = userImage;
    }

    AdminRestClient arc = new AdminRestClient();
    Response rs;
    Collection<User> userList;
    GenericType<Collection<User>> gcUserList;

    Collection<Skill> skillList;
    GenericType<Collection<Skill>> genericSkillList;

    Collection<Grouptbl> groupList;
    GenericType<Collection<Grouptbl>> genericGroup;
    Response resGroup;

// get Single object of user
    Skill skill;
    UserManageBean userManageBean;
    Response resUser;
    GenericType<User> genericUser;

    //    Response resUser;
    Response res;

    AdminRestClient adminRestClient;
    String message = "";
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            .getExternalContext().getRequest();

    HttpSession session = request.getSession();
    int uid = (int) session.getAttribute("userid");

    public UserMB() {
        adminRestClient = new AdminRestClient();
        userList = new ArrayList<>();
        gcUserList = new GenericType<Collection<User>>() {
        };

    }

    public void editData() {
        UserManageBean UMB = null;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();
        try {

            u = new User();
            skill = new Skill();
            genericUser = new GenericType<User>() {
            };
            resUser = arc.getUserByID_XML(Response.class, Integer.toString(uid));
            u = resUser.readEntity(genericUser);

            UMB = new UserManageBean();
            UMB.setUsername(u.getUsername());
            UMB.setPhoto(u.getPhoto());
            UMB.setFname(u.getFname());
            UMB.setLname(u.getLname());
            UMB.setEmail(u.getEmail());
            UMB.setMobno(u.getMobno());
            UMB.setCreatedon(u.getCreatedon());
            UMB.setDecr(u.getDescription());
            UMB.setUserid(u.getUserid());
            UMB.setCreatedon(u.getCreatedon());
            UMB.setPhoto(u.getPhoto());
            UMB.setSkillid(u.getSkillid().getSkillid());

            sessionMap.put("editUserDetail", UMB);

            redirect("EditProfile.jsf");

        } catch (IOException | ClientErrorException e) {
            System.out.println("Error is in edit user method " + e);
        }

    }

    public void updateUser(UserManageBean userManageBean) throws Exception {

        u = new User();
        u.setFname(userManageBean.getFname());
        u.setLname(userManageBean.getLname());
        u.setUsername(userManageBean.getUsername());
        u.setUserid(userManageBean.getUserid());
        u.setMobno(userManageBean.getMobno());
        u.setEmail(userManageBean.getEmail());
        u.setPassword(userManageBean.getPassword());
        u.setCreatedon(userManageBean.getCreatedon());
        u.setDescription(userManageBean.getDecr());
        u.setPhoto(userManageBean.getPhoto());

        arc.updateUser_XML(u, Integer.toString(userManageBean.getSkillid()));

        final int id = u.getUserid();
        User u1 = new User();
        u1 = asbl.getUserByID(id);

        session.setAttribute("username", u1.getUsername());
        session.setAttribute("password", u1.getPassword());
        session.setAttribute("fname", u1.getFname());
        session.setAttribute("lname", u1.getLname());
        session.setAttribute("email", u1.getEmail());
        session.setAttribute("mobno", u1.getMobno());
        session.setAttribute("photo", u1.getPhoto());
        session.setAttribute("userid", u1.getUserid());
        session.setAttribute("cdate", u1.getCreatedon());
        session.setAttribute("skill", u1.getSkillid().getSkill());
        session.setAttribute("descr", u1.getDescription());

        redirect("Profile.jsf");

    }

    private void redirect(String url) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(url);
    }

    public void changephoto() {
        try (InputStream input = userImage.getInputStream()) {
            String ext = userImage.getContentType();
            String imgExt = ext.substring(6);
            Integer x = 1000 + (int) (Math.random() * (10000 - 1000 + 1));
            String imgName = "UserIMG" + x + "." + imgExt;
            Files.copy(input, new File(folder, imgName).toPath());

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String strDate = dateFormat.format(date);

            u = new User();
            u.setUsername((String) session.getAttribute("username"));
            u.setPassword((String) session.getAttribute("password"));
            u.setFname((String) session.getAttribute("fname"));
            u.setLname((String) session.getAttribute("lname"));
            u.setEmail((String) session.getAttribute("email"));
            u.setMobno((String) session.getAttribute("mobno"));
            u.setCreatedon((String) session.getAttribute("cdate"));
            u.setDescription((String) session.getAttribute("descr"));
            u.setUserid((int) session.getAttribute("userid"));
            u.setPhoto(imgName);

            asbl.updateUser(u, skillid);

            final int id = u.getUserid();
            User u1 = new User();
            u1 = asbl.getUserByID(id);

            session.setAttribute("username", u1.getUsername());
            session.setAttribute("password", u1.getPassword());
            session.setAttribute("fname", u1.getFname());
            session.setAttribute("lname", u1.getLname());
            session.setAttribute("email", u1.getEmail());
            session.setAttribute("mobno", u1.getMobno());
            session.setAttribute("photo", u1.getPhoto());
            session.setAttribute("userid", u1.getUserid());
            session.setAttribute("cdate", u1.getCreatedon());
            session.setAttribute("skill", u1.getSkillid().getSkill());
            session.setAttribute("skillid", u1.getSkillid().getSkillid());
            session.setAttribute("descr", u1.getDescription());

            redirect("Profile.jsf");

        } catch (Exception e) {
            System.err.println("Error is in User Create With File" + e);
        }
    }

    String oldpass, newPass;

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public void changePassword() {

    }

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

    public Collection<Skill> getSkillList() {
        rs = arc.getAllSkill_XML(Response.class);
        skillList = new ArrayList<>();
        genericSkillList = new GenericType<Collection<Skill>>() {
        };
        skillList = rs.readEntity(genericSkillList);
        return skillList;
    }

    public void setSkillList(Collection<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
