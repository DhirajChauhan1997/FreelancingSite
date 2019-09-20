/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.Collection;
import javax.ejb.Local;
import Entity.*;

/**
 *
 * @author Dhiraj Chauhan
 */
@Local
public interface AdminSessionBeanLocal {

    //User Section
    public int createUser(User u, int skillid,int groupid);

    public int removeUser(int userid);

    public int updateUser(User u, int skillid);

    public int checkUserNameAvailability(String username);
    
    public int checkEmailAvailability(String email);
    
    public User getUserbyEmail(String email);
    
    public User getOldpassData(String username,String oldPass);
    
    public Collection<User> getAllUser();

    public User getUserByID(int userid);

    public Collection<User> getAllUserByFirstName(String Firstname);

    public Collection<User> getAllUserByLastName(String Lastname);

    public Collection<User> getAllUserByEmail(String Email);

    public Collection<User> getAllUserByMobNo(String mobno);

    public Collection<User> getAllUserByCreatedDate(String createdDate);

    public User getUserByUsername(String username);
    //End User Section
    
    //Apply Project 

    public int createapplyProject(int postid, int userID, ApplyProject ap);

    public int removeApplyProject(int applyID);

    public int updateApplyProject(int postid, int userid, ApplyProject ap);

    public Collection<ApplyProject> getAllApplyProject();

    public ApplyProject getApplyProjectByID(int id);
    
    public Collection<ApplyProject> getApplyJobyByUserid(int userid);

    public Collection<ApplyProject>getApplyJobByPOsterID(int posterid);
    
    //End Apply Project
    //Categores
    public int createCetegores(Categ categores);

    public int removeCetegores(int categID);

    public int updateCetegores(Categ categ);

    public Collection<Categ> getAllCetegores();

    public Collection<Categ> getCetegoresByName(String categName);

    public Categ getCetegoresByID(int categID);

    //End Categores
    //Skill
    public int createSkill(Skill skill);

    public int removeSkill(int skillID);

    public int updateSkill(Skill skill);

    public Collection<Skill> getAllSkill();

    public Collection<Skill> getSkillByName(String skill);

    public Skill getSkillByID(int skillID);

    //End Skill
    //Post
    public int createPost(int posterid, int skillid, int categid, Post post);

    public int removePost(int postid);

    public int updatePost(int posterid, int skillid, int categid, Post post);

    public Collection<Post> getAllPost();

    public Collection<Post> getAllPostByPostedOn(String date);

    public Post getAllPostByPostID(int postid);

    public Collection<Post>getAllPostByPosterId(int posterid);
//    public Collection<Post> getAllPostBySkillID(int skillID);
//    public Collection<Post> getAllPostBySkill(String skill);
//    public Collection<Post> getAllPostByCategores(String Categores);
//    public Collection<Post> getAllPostByCategores(int categID);
    public Collection<Post> getAllPostByPrice(String price);

    public Collection<Post> getAllPostByDuration(String duration);

    public Collection<Post> getAllPostByTitle(String title);

    //End Post
    //Group
    public int createGroup(Grouptbl Group);

    public int removeGroup(int GroupID);

    public int updateGroup(Grouptbl Group);

    public Collection<Grouptbl> getAllGroup();

    public Collection<Grouptbl> getGroupByName(String groupName);

    public Collection<Grouptbl> getGroupByID(int groupID);

    //End Group
    
    //User Group
    public int createUserGroup(int GroupID, int userid);

    public int removeUserGroup(int user_group_id);

    public int updateUserGroup(int user_group_id, int GroupID, int userid);

    public Collection<UserGroup> getAllUserGroup();

    public UserGroup getUserGroupByUserId(int userid);
   
}
