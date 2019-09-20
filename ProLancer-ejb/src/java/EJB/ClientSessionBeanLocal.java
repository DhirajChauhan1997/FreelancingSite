/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.*;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dhiraj Chauhan
 */
@Local
public interface ClientSessionBeanLocal {

    //User Section
    public int createUser(User u, int skillid, int groupid);

    public int removeUser(int userid);

    public int updateUser(User u, int skillid);


    //End User Section
    //Apply Project 
    public int createapplyProject(int postid, int userID, ApplyProject ap);

    public int removeApplyProject(int applyID);

    public int updateApplyProject(int postid, int userid, ApplyProject ap);

    public Collection<ApplyProject> getAllApplyProject();

    public Collection<ApplyProject> getApplyProjectByID(int id);

    //End Apply Project
    //Post
    public int createPost(int posterid, int skillid, int categid, Post post);

    public int removePost(int postid);

    public int updatePost(int skillid, int categid, Post post);

    public Collection<Post> getAllPost();

    public Collection<Post> getAllPostByPostedOn(String date);

    public Collection<Post> getAllPostByPosterID(int posterid);

    public Collection<Post> getAllPostByPrice(String price);

    public Collection<Post> getAllPostByDuration(String duration);

    public Collection<Post> getAllPostByTitle(String title);
    
    
    Collection<Post> getAllPostByUserID(int userID);
    User getUserByUserName(String username);

}
