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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "postManagedBean1234")
@ViewScoped
public class PostManagedBean1234 implements Serializable {

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
//        postList = asbl.getAllPost();
        rs = adminRestClient.getAllPost_XML(Response.class);
        postList = new ArrayList<>();
        genericPostList = new GenericType<Collection<Post>>() {
        };
        postList = rs.readEntity(genericPostList);
        return postList;
    }

    public void createPostTest() throws IOException {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        System.out.println("Current Date is " + date);
        System.out.println("Converted String: " + strDate);

        postManagedBean = new PostManagedBean();
        p = new Post();
        postManagedBean.setPosterid(posterid);
        postManagedBean.setTitle(title);
        postManagedBean.setSkillid(skillid);
        postManagedBean.setPrice(price);
        postManagedBean.setDuration(duration);
        postManagedBean.setHmworker(hmworker);
        postManagedBean.setJobdescr(jobdescr);
        postManagedBean.setCategid(categid);
//        postManagedBean.setPostedon(strDate);

        p.setTitle(title);
//        p.setSkillid(skillid);
        p.setPrice(price);
        p.setDuration(duration);
        p.setHmworker(hmworker);
        p.setJobdescr(jobdescr);
//        p.setCategid(categid);
        p.setPostedOn(strDate);

        asbl.createPost(posterid,
                skillid,
                categid, p);
//                 
//        asbl.createPost(postManagedBean.getPosterid(),
//                postManagedBean.getSkillid(),
//                postManagedBean.getCategid(), p);

        redirect("PostList.jsf");

    }

    //Using Rest Full APIs
    public void createPost() {
        //Get Current Date And Time And Convert into String
        try {
//            Skill s = new Skill();
//            s.setSkillid(skillid);
//            s.setSkill(s.getSkill());
//
//            Categ c = new Categ();
//            c.setCategid(categid);
//            c.setCategname(c.getCategname());
//
//            User u = new User();
//            u.setUserid(posterid);

            postManagedBean = new PostManagedBean();
            postManagedBean.setTitle(title);
            postManagedBean.setPrice(price);
            postManagedBean.setDuration(duration);
            postManagedBean.setHmworker(hmworker);
            postManagedBean.setJobdescr(jobdescr);
            postManagedBean.setPostedon(postedon);

//            System.err.println("Poster Id "+postManagedBean.getPosterid());
//            System.err.println("Skill Id "+postManagedBean.getSkillid());
//            System.err.println("Categ  Id "+postManagedBean.getCategid());
//            adminRestClient.createPost_JSON(postManagedBean,
//                    Integer.toString(postManagedBean.getPosterid()),
//                    Integer.toString(postManagedBean.getSkillid()),
//                    Integer.toString(postManagedBean.getCategid()));
            adminRestClient.createPost_JSON(postManagedBean,
                    Integer.toString(posterid),
                    Integer.toString(skillid),
                    Integer.toString(categid));

            FacesContext.getCurrentInstance().getExternalContext().redirect("PostList.jsf");
            postManagedBean = null;
        } catch (Exception e) {
            System.out.println("Error is Postmanage bean create post method " + e);
        }

    }

    public void editPost(int postid) {
        PostManagedBean PMB;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();

        try {
            System.err.println("Post id is " + postid);

            p = new Post();
            genericPost = new GenericType<Post>() {
            };
            resPost = adminRestClient.getAllPostByPostID_XML(Response.class, Integer.toString(postid));
            p = resPost.readEntity(genericPost);

            PMB = new PostManagedBean();
            PMB.setPostid(p.getPostid());
            PMB.setPosterid(p.getPostid());
            PMB.setSkillid(p.getSkillid().getSkillid());
            PMB.setCategid(p.getCategId().getCategid());
            PMB.setUserid(p.getPosterid().getUserid());

            PMB.setTitle(p.getTitle());
            PMB.setPrice(p.getPrice());
            PMB.setDuration(p.getDuration());
            PMB.setHmworker(p.getHmworker());
            PMB.setJobdescr(p.getJobdescr());
//            PMB.setCategid(p.getCategId());

            sessionMap.put("editPostDetail", PMB);

            FacesContext.getCurrentInstance().getExternalContext().redirect("EditPost.jsf");

        } catch (Exception e) {
            System.out.println("Error is in " + e);
        }
    }

    public void updatePost(PostManagedBean postManagedBean) {
        try {
//            postManagedBean.setPostid(postManagedBean.getPostid());
//            postManagedBean.setPosterid(postManagedBean.getPosterid());
//            postManagedBean.setTitle(postManagedBean.getTitle());
//            postManagedBean.setSkillid(postManagedBean.getSkillid());
//            postManagedBean.setPrice(postManagedBean.getPrice());
//            postManagedBean.setDuration(postManagedBean.getDuration());
//            postManagedBean.setHmworker(postManagedBean.getHmworker());
//            postManagedBean.setJobdescr(postManagedBean.getJobdescr());
//            postManagedBean.setCategid(postManagedBean.getCategid());

            adminRestClient.updatePost_JSON(postManagedBean, Integer.toString(postManagedBean.getPosterid()),
                    Integer.toString(postManagedBean.getSkillid()), Integer.toString(postManagedBean.getCategid()));

            FacesContext.getCurrentInstance().getExternalContext().redirect("SkillList.jsf");
            postManagedBean = null;

        } catch (Exception e) {
            System.err.println("Error is in update Post " + e);
        }
    }

    public void removePost(int postid) {

        try {
            adminRestClient.removePost(Integer.toString(postid));
            FacesContext.getCurrentInstance().getExternalContext().redirect("PostList.jsf");

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
//        categList = asbl.getAllCetegores();
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

    public PostManagedBean1234() {
    }

}
