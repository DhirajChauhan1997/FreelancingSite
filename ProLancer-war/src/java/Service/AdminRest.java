/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import EJB.AdminSessionBeanLocal;
import Entity.ApplyProject;
import Entity.Categ;
import Entity.Grouptbl;
import Entity.Post;
import Entity.Skill;
import Entity.User;
import Entity.UserGroup;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dhiraj Chauhan
 */
@Path("admin")
@Stateless
public class AdminRest {

    @EJB
    AdminSessionBeanLocal asbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminRest
     */
    public AdminRest() {

    }

    //User Related Rest Services
    @POST
    @Path("createUser/{skillid}/{groupid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(User u, @PathParam("skillid") int skillid, @PathParam("groupid") int groupid) {
        try {
            asbl.createUser(u, skillid, groupid);
        } catch (Exception e) {
            System.err.println("Error is create user" + e.getMessage());
        }
    }

    @DELETE
    @Path("removeUser/{userid}")
    public void removeUser(@PathParam("userid") int userid) {
        try {
            asbl.removeUser(userid);
        } catch (Exception e) {
            System.err.println("Error is remove user" + e.getMessage());
        }
    }

    @PUT
    @Path("updateUser/{skillid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(User u, @PathParam("skillid") int skillid) {
        try {
            asbl.updateUser(u, skillid);
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUser() {
        try {
            Collection<User> users = asbl.getAllUser();
            return (users);
        } catch (Exception e) {
            System.err.println("Error is getAllUser" + e);
            return null;
        }
    }

    @GET
    @Path("getUserByUsername/{username}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUserByUsername(@PathParam("username") String username) {
        try {
            User users = asbl.getUserByUsername(username);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getUserByID/{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUserByID(@PathParam("userid") int userid) {
        try {
            User users = asbl.getUserByID(userid);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getUserByFirstName/{firstname}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getUserByFirstName(@PathParam("firstname") String firstName) {
        try {
            Collection<User> users = asbl.getAllUserByFirstName(firstName);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllUserByLastName/{Lastname}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUserByLastName(@PathParam("Lastename") String Lastname) {
        try {
            Collection<User> users = asbl.getAllUserByLastName(Lastname);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllUserByEmail/{Email}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUserByEmail(@PathParam("Email") String Email) {
        try {
            Collection<User> users = asbl.getAllUserByEmail(Email);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllUserByMobNo/{mobno}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUserByMobNo(@PathParam("mobno") String mobno) {
        try {
            Collection<User> users = asbl.getAllUserByMobNo(mobno);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllUserByCreatedDate/{createdDate}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUserByCreatedDate(@PathParam("createdDate") String createdDate) {
        try {
            Collection<User> users = asbl.getAllUserByCreatedDate(createdDate);
            return users;
        } catch (Exception e) {
            System.err.println("Error is " + e.getMessage());
            return null;
        }
    }

    //End User Section
    //Apply Project 
    @POST
    @Path("createapplyProject/{postid}/{userid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createapplyProject(@PathParam("postid") int postid, @PathParam("userid") int userID, ApplyProject ap) {
        try {
            asbl.createapplyProject(postid, userID, ap);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @DELETE
    @Path("removeApplyProject/{applyID}")
    public void removeApplyProject(@PathParam("applyID") int applyID) {
        try {
            asbl.removeApplyProject(applyID);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @PUT
    @Path("createapplyProject/{postid}/{userid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateApplyProject(@PathParam("postid") int postid, @PathParam("userid") int userid, ApplyProject ap) {
        try {
            asbl.createapplyProject(postid, userid, ap);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllApplyProject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<ApplyProject> getAllApplyProject() {
        try {
            Collection<ApplyProject> applyProjects = asbl.getAllApplyProject();
            return applyProjects;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getApplyProjectByID/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ApplyProject getApplyProjectByID(@PathParam("id") int id) {
        try {
            ApplyProject applyProjects = asbl.getApplyProjectByID(id);
            return applyProjects;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }
    //End Apply Project

    //Categores
    @POST
    @Path("createCetegore")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createCetegores(Categ c) {
        try {
            asbl.createCetegores(c);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @DELETE
    @Path("removeCetegores/{cetegID}")
    public void removeCetegores(@PathParam("cetegID") int categID) {
        try {
            asbl.removeCetegores(categID);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @PUT
    @Path("updateCetegores")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateCetegores(Categ c) {
        try {
            asbl.updateCetegores(c);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllCategores")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Categ> getAllCetegores() {
        try {
            Collection<Categ> categs = asbl.getAllCetegores();
            return categs;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getCetegoresByName/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Categ> getCetegoresByName(@PathParam("name") String categName) {
        try {
            Collection<Categ> categs = asbl.getCetegoresByName(categName);
            return categs;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getCetegoresByID/{categID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Categ getCetegoresByID(@PathParam("categID") int categID) {
        try {
            Categ categs = asbl.getCetegoresByID(categID);
            return categs;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    //End Categores
    //Skill
    @POST
    @Path("createSkill")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createSkill(Skill skill) {
        try {
            asbl.createSkill(skill);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @DELETE
    @Path("removeSkill/{skillID}")
    public void removeSkill(@PathParam("skillID") int skillID) {
        try {
            asbl.removeSkill(skillID);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @PUT
    @Path("updateSkill")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateSkill(Skill skill) {
        try {
            asbl.updateSkill(skill);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllSkill")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Skill> getAllSkill() {
        try {
            Collection<Skill> skills = asbl.getAllSkill();
            return skills;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getSkillByName/{skill}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Skill> getSkillByName(@PathParam("skill") String skill) {
        try {
            Collection<Skill> skills = asbl.getSkillByName(skill);
            return skills;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getSkillByID/{skillid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Skill getSkillByID(@PathParam("skillid") int skillID) {
        try {
            Skill skills = asbl.getSkillByID(skillID);
            return skills;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    //End Skill
    //Post
    @POST
    @Path("createPost/{posterid}/{skillid}/{categid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createPost(@PathParam("posterid") int posterid, @PathParam("skillid") int skillid, @PathParam("categid") int categid, Post post) {
        try {
            asbl.createPost(posterid, skillid, categid, post);
        } catch (Exception e) {
            System.err.println("Error is in Create Post Admin Rest " + e);
        }

    }

    @DELETE
    @Path("removePost/{postid}")
    public void removePost(@PathParam("postid") int postid) {
        try {
            asbl.removePost(postid);
        } catch (Exception e) {
            System.err.println("Error is in " + e);
        }
    }

    @PUT
    @Path("updatepost/{posterid}/{skillid}/{categid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePost(@PathParam("posterid") int posterid, @PathParam("skillid") int skillid, @PathParam("cetegid") int categid, Post post) {
        try {
            asbl.updatePost(posterid, skillid, categid, post);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllPost")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Post> getAllPost() {
        try {
            Collection<Post> posts = asbl.getAllPost();
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllPostByPostedOn/{date}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Post> getAllPostByPostedOn(@PathParam("date") String date) {
        try {
            Collection<Post> posts = asbl.getAllPostByPostedOn(date);
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllPostByPostID/{postid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Post getAllPostByPostID(@PathParam("postid") int posterid) {
        try {
            Post posts = asbl.getAllPostByPostID(posterid);
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllPostByPrice/{price}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Post> getAllPostByPrice(@PathParam("price") String price) {
        try {
            Collection<Post> posts = asbl.getAllPostByPrice(price);
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllPostByDuration/{duration}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Post> getAllPostByDuration(@PathParam("duration") String duration) {
        try {
            Collection<Post> posts = asbl.getAllPostByDuration(duration);
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getAllPostByTitle/{title}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Post> getAllPostByTitle(@PathParam("title") String title) {
        try {
            Collection<Post> posts = asbl.getAllPostByTitle(title);
            return posts;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    //End Post
    //Group
    @POST
    @Path("createGroup")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createGroup(Grouptbl Group) {
        try {
            asbl.createGroup(Group);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @DELETE
    @Path("removeGroup/{GroupID}")
    public void removeGroup(@PathParam("GroupID") int GroupID) {
        try {
            asbl.removeGroup(GroupID);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @PUT
    @Path("updateGroup")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateGroup(Grouptbl Group) {
        try {
            asbl.updateGroup(Group);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllGRoup")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Grouptbl> getAllGroup() {
        try {
            Collection<Grouptbl> grouptbls = asbl.getAllGroup();
            return grouptbls;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getGroupByName/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Grouptbl> getGroupByName(@PathParam("groupname") String groupName) {
        try {
            Collection<Grouptbl> grouptbls = asbl.getGroupByName(groupName);
            return grouptbls;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getGroupByID/{groupid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Grouptbl> getGroupByID(@PathParam("groupid") int groupID) {
        try {
            Collection<Grouptbl> grouptbls = asbl.getGroupByID(groupID);
            return grouptbls;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    //End Group
    //User Group
    @POST
    @Path("createUserGroup/{Groupid}/{userid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUserGroup(@PathParam("groupid") int GroupID, @PathParam("userid") int userid) {
        try {
            asbl.createUserGroup(GroupID, userid);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @DELETE
    @Path("removeUserGroup/{user_group_id}")
    public void removeUserGroup(@PathParam("user_group_id") int user_group_id) {
        try {
            asbl.removeUserGroup(user_group_id);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @PUT
    @Path("updateUserGroup/{user_group_id}/{groupid}/{userid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUserGroup(@PathParam("user_group_id") int user_group_id, @PathParam("Groupid") int GroupID, @PathParam("userid") int userid) {
        try {
            asbl.updateUserGroup(user_group_id, GroupID, userid);
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
        }
    }

    @GET
    @Path("getAllUserGroup")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<UserGroup> getAllUserGroup() {
        try {
            Collection<UserGroup> groups = asbl.getAllUserGroup();
            return groups;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @GET
    @Path("getUserGroupByUserId/{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserGroup getUserGroupByUserId(@PathParam("userid") int userid) {
        UserGroup ug = asbl.getUserGroupByUserId(userid);
        return ug;
    }

    @GET
    @Path("getApplyJobyByUserid/{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<ApplyProject> getApplyJobyByUserid(@PathParam("userid") int userid) {
        Collection<ApplyProject> getApplyJobyByUserids = asbl.getApplyJobyByUserid(userid);
        return getApplyJobyByUserids;

    }

}
