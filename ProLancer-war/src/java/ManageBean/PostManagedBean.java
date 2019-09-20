/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import EJB.AdminSessionBeanLocal;
import Entity.Post;
import Entity.*;
import client.AdminRestClient;
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
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "postManagedBean")
@ViewScoped
public class PostManagedBean implements Serializable {

    @EJB
    AdminSessionBeanLocal asbl;
    int postid, posterid, skillid, categid, userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    String title, price, duration, hmworker, jobdescr, postedon;

    Collection<Post> postList;

    AdminRestClient adminRestClient = new AdminRestClient();
    GenericType<Collection<Post>> genericPostList;
    Response rs;

    /**
     * Get All List Of Skill ,Categores,Users
     *
     */
    Collection<User> userList;
    Collection<Skill> skillList;
    Collection<Categ> categList;

    GenericType<Collection<User>> genericUserList;
    Response rsUser;

    GenericType<Collection<Skill>> genericSkillList;
    Response rsSkill;

    GenericType<Collection<Categ>> genericCategList;
    Response rsCateg;

    // For Add New Racord
    //Get single Record of Post
    Post p;
    Response resPost;
    GenericType<Post> genericPost;
    PostManagedBean postManagedBean;

    public Collection getPostList() {
        rs = adminRestClient.getAllPost_XML(Response.class);
        postList = new ArrayList<>();
        genericPostList = new GenericType<Collection<Post>>() {
        };
        postList = rs.readEntity(genericPostList);
        return postList;
    }

    //Using Rest Full APIs
    public void createPost() {
        //Get Current Date And Time And Convert into String
        try {

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String strDate = dateFormat.format(date);

            postManagedBean = new PostManagedBean();
            postManagedBean.setTitle(title);
            postManagedBean.setPrice(price);
            postManagedBean.setDuration(duration);
            postManagedBean.setHmworker(hmworker);
            postManagedBean.setJobdescr(jobdescr);
            postManagedBean.setPostedon(strDate);
            postManagedBean.setPosterid(posterid);
            postManagedBean.setSkillid(skillid);
            postManagedBean.setCategid(categid);

            p = new Post();
            p.setTitle(title);
            p.setPrice(price);
            p.setDuration(duration);
            p.setHmworker(hmworker);
            p.setJobdescr(jobdescr);
            p.setPostedOn(strDate);
            adminRestClient.createPost_XML(p,
                    Integer.toString(posterid),
                    Integer.toString(skillid),
                    Integer.toString(categid));

            redirect("PostList.jsf");
            postManagedBean = null;
        } catch (Exception e) {
            System.out.println("Error is Postmanage bean create post method " + e);
        }

    }

    public void reSet() {
        title = null;
        price = null;
        duration = null;
        hmworker = null;
        jobdescr = null;
        posterid = -1;
        skillid = -1;
        categid = -1;
    }

    public void editPost(int postid) {
        PostManagedBean PMB;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();

        try {
            System.err.println("Post id from editPost Method " + postid);

            p = new Post();
            genericPost = new GenericType<Post>() {
            };
            resPost = adminRestClient.getAllPostByPostID_XML(Response.class, Integer.toString(postid));
            p = resPost.readEntity(genericPost);

            PMB = new PostManagedBean();
            PMB.setPostid(p.getPostid());
            PMB.setPosterid(p.getPosterid().getUserid());
            PMB.setSkillid(p.getSkillid().getSkillid());
            PMB.setCategid(p.getCategId().getCategid());
            PMB.setTitle(p.getTitle());
            PMB.setPrice(p.getPrice());
            PMB.setDuration(p.getDuration());
            PMB.setHmworker(p.getHmworker());
            PMB.setJobdescr(p.getJobdescr());
            PMB.setPostedon(p.getPostedOn());
            System.err.println("Duration in " + PMB.getDuration());
            sessionMap.put("editPostDetail", PMB);

            redirect("EditPost.jsf");

        } catch (IOException | ClientErrorException e) {
            System.out.println("Error is in " + e);
        }
    }

    public void updatePost(PostManagedBean postManagedBean) throws Exception {

        p = new Post();
        p.setPostid(postManagedBean.getPostid());
        p.setTitle(postManagedBean.getTitle());
        p.setPrice(postManagedBean.getPrice());
        p.setDuration(postManagedBean.getDuration());
        p.setHmworker(postManagedBean.getHmworker());
        p.setJobdescr(postManagedBean.getJobdescr());
        p.setPostedOn(postManagedBean.getPostedon());
//            adminRestClient.updatePost_JSON(p, Integer.toString(posterid),
//                    Integer.toString(skillid), Integer.toString(categid));
        asbl.updatePost(postManagedBean.getPosterid(),
                postManagedBean.getSkillid(),
                postManagedBean.getCategid(), p);
        redirect("PostList.jsf");

    }

    public void cancelUpdate() throws Exception {
        redirect("PostList.jsf");
    }

    public void removePost(int postid) throws Exception {
        try {
            adminRestClient.removePost(Integer.toString(postid));
            redirect("PostList.jsf");

        } catch (Exception e) {
            System.out.println("Error is in removeSkill " + e.getMessage());
        }
    }

    public Collection getUserList() {
//        userList = asbl.getAllUser();
        rsUser = adminRestClient.getAllUser_XML(Response.class);
        userList = new ArrayList<>();
        genericUserList = new GenericType<Collection<User>>() {
        };
        userList = rsUser.readEntity(genericUserList);
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    public Collection getSkillList() {
//        skillList = asbl.getAllSkill();

        rsSkill = adminRestClient.getAllSkill_XML(Response.class);
        skillList = new ArrayList<>();
        genericSkillList = new GenericType<Collection<Skill>>() {
        };
        skillList = rsSkill.readEntity(genericSkillList);
        return skillList;
    }

    public void setSkillList(Collection<Skill> skillList) {
        this.skillList = skillList;
    }

    public Collection getCategList() {

        rsCateg = adminRestClient.getAllCetegores_XML(Response.class);
        categList = new ArrayList<>();
        genericCategList = new GenericType<Collection<Categ>>() {
        };
        categList = rsCateg.readEntity(genericCategList);
        return categList;
    }

    private void redirect(String pagename) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(pagename);
    }

    public void setCategList(Collection<Categ> categList) {
        this.categList = categList;
    }

    public void setPostList(Collection<Post> postList) {
        this.postList = postList;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getPosterid() {
        return posterid;
    }

    public void setPosterid(int posterid) {
        this.posterid = posterid;
    }

    public int getSkillid() {
        return skillid;
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }

    public int getCategid() {
        return categid;
    }

    public void setCategid(int categid) {
        this.categid = categid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHmworker() {
        return hmworker;
    }

    public void setHmworker(String hmworker) {
        this.hmworker = hmworker;
    }

    public String getJobdescr() {
        return jobdescr;
    }

    public void setJobdescr(String jobdescr) {
        this.jobdescr = jobdescr;
    }

    public String getPostedon() {
        return postedon;
    }

    public void setPostedon(String postedon) {
        this.postedon = postedon;
    }

    public PostManagedBean() {
    }

}
