/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Entity.*;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import EJB.AdminSessionBeanLocal;
import client.AdminRestClient;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "userManageBean")
@ViewScoped
public class UserManageBean implements Serializable {

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
    String msg = "dfdffdfdfdfdfdfdfdfdfdf";
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
    User uname;
    GenericType<User> unamegeneric;
    LoginBean loginBean;

    AdminRestClient adminRestClient;
    String message = "";

    public UserManageBean() {
        adminRestClient = new AdminRestClient();
        userList = new ArrayList<>();
        gcUserList = new GenericType<Collection<User>>() {
        };
    }

    public User getUname() {
        unamegeneric = new GenericType<User>() {
        };
        resUser = adminRestClient.getUserByUsername_XML(Response.class, username);
        uname = resUser.readEntity(unamegeneric);

//        uname = asbl.getUserByUsername(username);
        return uname;
    }

    public void setUname(User uname) {
        this.uname = uname;
    }

    public Collection getSkillList() {
        rs = arc.getAllSkill_XML(Response.class);
        skillList = new ArrayList<>();
        genericSkillList = new GenericType<Collection<Skill>>() {
        };
        skillList = rs.readEntity(genericSkillList);
        return skillList;
    }

    public Collection getGroupList() {
        resGroup = arc.getAllGroup_XML(Response.class);
        groupList = new ArrayList<>();
        genericGroup = new GenericType<Collection<Grouptbl>>() {
        };
        groupList = resGroup.readEntity(genericGroup);

        return groupList;
    }

    public void setGroupList(Collection<Grouptbl> groupList) {
        this.groupList = groupList;
    }

    public Collection getUserList() {
        rs = arc.getAllUser_XML(Response.class);
        userList = new ArrayList<>();
        gcUserList = new GenericType<Collection<User>>() {
        };
        userList = rs.readEntity(gcUserList);
        return userList;
    }

    public void editUser(int userid) {
        UserManageBean UMB = null;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();
        try {
//            System.err.println("User id is " + userid);
            u = new User();
            skill = new Skill();
            genericUser = new GenericType<User>() {
            };
            resUser = arc.getUserByID_XML(Response.class, Integer.toString(userid));
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

            redirect("EditUser.jsf");

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
        redirect("UserList.jsf");

    }

    public void createUser() throws Exception {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        userManageBean = new UserManageBean();
        userManageBean.setUsername(username);
        userManageBean.setPhoto("photo.jpg");
        userManageBean.setPassword(password);
        userManageBean.setFname(fname);
        userManageBean.setLname(lname);
        userManageBean.setEmail(email);
        userManageBean.setMobno(mobno);
        userManageBean.setCreatedon(strDate);
        userManageBean.setDecr(decr);
        userManageBean.setSkillid(skillid);

        u = new User();
        u.setUsername(username);
        u.setPhoto("photo.jpg");
        u.setPassword(password);
        u.setFname(fname);
        u.setLname(lname);
        u.setEmail(email);
        u.setMobno(mobno);
        u.setCreatedon(strDate);
        u.setDescription(decr);

        adminRestClient.createUser_XML(u, Integer.toString(skillid), Integer.toString(2));
        redirect("Login.jsf");

    }

    public void createUserAdmin() throws Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);

        userManageBean = new UserManageBean();
        userManageBean.setUsername(username);
        userManageBean.setPhoto("photo.jpg");
        userManageBean.setPassword(password);
        userManageBean.setFname(fname);
        userManageBean.setLname(lname);
        userManageBean.setEmail(email);
        userManageBean.setMobno(mobno);
        userManageBean.setCreatedon(strDate);
        userManageBean.setDecr(decr);
        userManageBean.setSkillid(skillid);
        userManageBean.setGroupid(groupid);

        u = new User();
        u.setUsername(username);
        u.setPhoto("photo.jpg");
        u.setPassword(password);
        u.setFname(fname);
        u.setLname(lname);
        u.setEmail(email);
        u.setMobno(mobno);
        u.setCreatedon(strDate);
        u.setDescription(decr);

        adminRestClient.createUser_JSON(u, Integer.toString(userManageBean.getSkillid()), Integer.toString(userManageBean.getGroupid()));

        redirect("UserList.jsf");

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void createUserFile() throws IOException {

        Collection<User> user;
        int checkUsername = asbl.checkUserNameAvailability(username);
        if (checkUsername > 0) {
            userManageBean = new UserManageBean();
            message = "Username Already Exist";
        } else {
            try (InputStream input = userImage.getInputStream()) {
                String ext = userImage.getContentType();
                String imgExt = ext.substring(6);
                Integer x = 1000 + (int) (Math.random() * (10000 - 1000 + 1));
                String imgName = "UserIMG" + x + "." + imgExt;
                Files.copy(input, new File(folder, imgName).toPath());

                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
                String strDate = dateFormat.format(date);

                userManageBean = new UserManageBean();
                userManageBean.setUsername(username);
                userManageBean.setPhoto(imgName);
                userManageBean.setPassword(password);
                userManageBean.setFname(fname);
                userManageBean.setLname(lname);
                userManageBean.setEmail(email);
                userManageBean.setMobno(mobno);
                userManageBean.setCreatedon(strDate);
                userManageBean.setDecr(decr);
                userManageBean.setSkillid(skillid);

                u = new User();
                u.setUsername(username);
                u.setPhoto(photo);
                u.setPassword(password);
                u.setFname(fname);
                u.setLname(lname);
                u.setEmail(email);
                u.setMobno(mobno);
                u.setCreatedon(strDate);
                u.setDescription(decr);
                u.setPhoto(imgName);

                asbl.createUser(u, skillid, 2);
                redirect("Login.jsf");

            } catch (Exception e) {
                System.err.println("Error is in User Create With File" + e);
            }

        }

    }

    public void createUserFileTest() throws IOException {

        try (InputStream input = userImage.getInputStream()) {
            String ext = userImage.getContentType();
            String imgExt = ext.substring(6);
            Integer x = 1000 + (int) (Math.random() * (10000 - 1000 + 1));
            String imgName = "UserIMG" + x + "." + imgExt;
            Files.copy(input, new File(folder, imgName).toPath());

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String strDate = dateFormat.format(date);

            userManageBean = new UserManageBean();
            userManageBean.setUsername(username);
            userManageBean.setPhoto(imgName);
            userManageBean.setPassword(password);
            userManageBean.setFname(fname);
            userManageBean.setLname(lname);
            userManageBean.setEmail(email);
            userManageBean.setMobno(mobno);
            userManageBean.setCreatedon(strDate);
            userManageBean.setDecr(decr);
            userManageBean.setSkillid(skillid);

            u = new User();
            u.setUsername(username);
            u.setPhoto(photo);
            u.setPassword(password);
            u.setFname(fname);
            u.setLname(lname);
            u.setEmail(email);
            u.setMobno(mobno);
            u.setCreatedon(strDate);
            u.setDescription(decr);
            u.setPhoto(imgName);

            asbl.createUser(u, skillid, 2);
            redirect("Login.jsf");

        } catch (Exception e) {
            System.err.println("Error is in User Create With File" + e);
        }

    }

    public void reset() {
        username = null;
        password = null;
        cpassword = null;
        fname = null;
        lname = null;
        photo = null;
        decr = null;
        email = null;
        mobno = null;
        skillid = -1;
        groupid = - 1;
    }

    public void removeUser(int userid) {
        try {
            arc.removeUser(Integer.toString(userid));
            redirect("UserList.jsf");
        } catch (Exception e) {
            System.out.println("Error is in removeSkill " + e.getMessage());
        }
    }

    String keyword;
    String searchBy;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public void searchSwitch() {

        try {
            switch (searchBy) {
                case "fname":
                    rs = adminRestClient.getUserByFirstName_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                case "lname":
                    rs = adminRestClient.getAllUserByLastName_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                case "email":
                    rs = adminRestClient.getAllUserByEmail_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                case "username":
                    rs = adminRestClient.getUserByUsername_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                case "mobno":
                    rs = adminRestClient.getAllUserByMobNo_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                case "createdDate":
                    rs = adminRestClient.getAllUserByCreatedDate_XML(Response.class, keyword);
                    userList = rs.readEntity(gcUserList);
                    break;
                default:
                    rs = adminRestClient.getAllUser_XML(Response.class);
                    userList = rs.readEntity(gcUserList);
                    break;
            }
        } catch (ClientErrorException ex) {
            System.out.println("Error is in Search User Bean " + ex);
        }
    }

    private void redirect(String url) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(url);
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    public void setSkillList(Collection<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getDecr() {
        return decr;
    }

    public void setDecr(String decr) {
        this.decr = decr;
    }

}
