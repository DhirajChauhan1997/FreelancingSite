/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean.User;

import EJB.AdminSessionBeanLocal;
import Entity.*;
import client.AdminRestClient;
import client.UserRestClient;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
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
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "UserpostMB")
@ViewScoped

public class PostMB implements Serializable {
    
    @EJB
    AdminSessionBeanLocal asbl;
    
    int postid, skillid, posterid, categid, userid;
    String title, price, duration, hmworker, jobdescr, postedon;
    
    Collection<Post> postList;
    Post p;
    Response resPost;
    GenericType<Post> genericPost;
    
    UserRestClient userRestClient = new UserRestClient();
    AdminRestClient adminRestClient = new AdminRestClient();
    GenericType<Collection<Post>> genericPostList;
    Response rs;
    
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession session = request.getSession();
    
    PostMB postManagedBean;
    
    Collection<Post> postByUSerID;
    Collection<Skill> getallskill;
    Collection<Categ> getallcateg;
    int uid = (int) session.getAttribute("userid");
    
    public PostMB() {
        
    }
    
    public Collection getGetallskill() {
        getallskill = asbl.getAllSkill();
        return getallskill;
    }
    
    public void setGetallskill(Collection<Skill> getallskill) {
        this.getallskill = getallskill;
    }
    
    public Collection getGetallcateg() {
        getallcateg = asbl.getAllCetegores();
        return getallcateg;
    }
    
    public void setGetallcateg(Collection<Categ> getallcateg) {
        this.getallcateg = getallcateg;
    }
    
    public Collection<Post> getPostByUSerID() {
        postByUSerID = asbl.getAllPostByPosterId(uid);
        return postByUSerID;
    }
    
    public void setPostByUSerID(Collection<Post> postByUSerID) {
        this.postByUSerID = postByUSerID;
    }
    
    public void createPost() {
        //Get Current Date And Time And Convert into String
        try {
            
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            postManagedBean = new PostMB();
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
            asbl.createPost(uid, skillid, categid, p);
//            adminRestClient.createPost_XML(p,
//                    Integer.toString(22),
//                    Integer.toString(skillid),
//                    Integer.toString(categid));

            redirect("PostList.jsf");
        } catch (IOException | ClientErrorException e) {
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
        PostMB PMB;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();
        
        try {
            System.err.println("Post id from editPost Method " + postid);
            
            p = new Post();
            genericPost = new GenericType<Post>() {
            };
            resPost = adminRestClient.getAllPostByPostID_XML(Response.class, Integer.toString(postid));
            p = resPost.readEntity(genericPost);
            
            PMB = new PostMB();
            PMB.setPostid(p.getPostid());
            PMB.setPosterid(p.getPosterid().getUserid());
            PMB.setSkillid(p.getSkillid().getSkillid());
            PMB.setCategid(p.getCategId().getCategid());
            PMB.setTitle(p.getTitle());
            PMB.setPrice(p.getPrice());
            PMB.setDuration(p.getDuration());
            PMB.setHmworker(p.getHmworker());
            PMB.setJobdescr(p.getJobdescr());
            
            System.err.println("Duration in " + PMB.getDuration());
            sessionMap.put("editPostDetail", PMB);
            
            redirect("EditPost.jsf");
            
        } catch (IOException | ClientErrorException e) {
            System.out.println("Error is in " + e);
        }
    }
    
    public void updatePost(PostMB postManagedBean) {
        try {
            postManagedBean.setPostid(postManagedBean.getPostid());
//            postManagedBean.setPosterid(postManagedBean.getPosterid());
            postManagedBean.setTitle(postManagedBean.getTitle());
//            postManagedBean.setSkillid(postManagedBean.getSkillid());
            postManagedBean.setPrice(postManagedBean.getPrice());
            postManagedBean.setDuration(postManagedBean.getDuration());
            postManagedBean.setHmworker(postManagedBean.getHmworker());
            postManagedBean.setJobdescr(postManagedBean.getJobdescr());
//            postManagedBean.setCategid(postManagedBean.getCategid());

//            p = new Post();
//            p.setPostid(postid);
//            p.setTitle(title);
//            p.setPrice(price);
//            p.setDuration(duration);
            System.err.println("Duration from updatePost " + postManagedBean.getDuration());
//            p.setHmworker(hmworker);
//            p.setJobdescr(jobdescr);

            adminRestClient.updatePost_JSON(postManagedBean, Integer.toString(posterid),
                    Integer.toString(skillid), Integer.toString(categid));
//            

            redirect("PostList.jsf");
            
        } catch (IOException | ClientErrorException e) {
            System.err.println("Error is in update Post " + e);
        }
    }
    
    public void cancelUpdate() throws Exception {
        redirect("PostList.jsf");
    }
    
    public void removePost(int postid) throws Exception {
        try {
            adminRestClient.removePost(Integer.toString(postid));
            redirect("PostList.jsf");
            
        } catch (IOException | ClientErrorException e) {
            System.out.println("Error is in removeSkill " + e.getMessage());
        }
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
    
    public int getUserid() {
        return userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
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
    
    public Collection<Post> getPostList() {
        //        postList = asbl.getAllPost();
        rs = adminRestClient.getAllPost_XML(Response.class);
        postList = new ArrayList<>();
        genericPostList = new GenericType<Collection<Post>>() {
        };
        postList = rs.readEntity(genericPostList);
        return postList;
    }
    
    public void setPostList(Collection<Post> postList) {
        this.postList = postList;
    }
    
    private void redirect(String pagename) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(pagename);
    }

//    public User getuserbyname(){
//        Principal p=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
//        return 
//    }
}
