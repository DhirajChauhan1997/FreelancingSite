/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
+-;
 */
package EJB;

import Entity.*;
import java.security.acl.Group;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhiraj Chauhan
 */
@Stateless
public class ClientSessionBean implements ClientSessionBeanLocal {
    
    @PersistenceContext(unitName = "ProlancerUnit")
    EntityManager em;
    
    @Override
    public int createUser(User u, int skillid, int groupid) {
        try {
            Skill s = em.find(Skill.class, skillid);
            u.setSkillid(s);
            UserGroup ug = new UserGroup();
            ug.setUserid(u);
            ug.setGroupId(em.find(Grouptbl.class, groupid));
            em.persist(ug);
            em.persist(u);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int removeUser(int userid) {
        try {
            User u = em.find(User.class, userid);
            em.remove(u);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Remove User " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int updateUser(User u, int skillid) {
        try {
            Skill s = em.find(Skill.class, skillid);
            u.setSkillid(s);
//            em.find(User.class, userid);
//            u.setUserid(userid);
            em.merge(u);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Update User " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int createapplyProject(int postid, int userID, ApplyProject ap) {
        try {
            User applyer = em.find(User.class, userID);
            Post postid1 = em.find(Post.class, postid);
            ap.setUserid(applyer);
            ap.setPostid(postid1);
            em.persist(ap);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Create Apply Project " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int removeApplyProject(int applyID) {
        try {
            ApplyProject a = em.find(ApplyProject.class, applyID);
            em.remove(a);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Remove Apply Project " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int updateApplyProject(int postid, int userid, ApplyProject ap) {
        try {
            User applyer = em.find(User.class, userid);
            Post postid1 = em.find(Post.class, postid);
            
            ap.setUserid(applyer);
            ap.setPostid(postid1);
            
            em.merge(ap);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Create Apply Project " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public Collection<ApplyProject> getAllApplyProject() {
        try {
            Collection<ApplyProject> allApplyProject = em.createNamedQuery("ApplyProject.findAll")
                    .getResultList();
            return allApplyProject;
        } catch (Exception e) {
            System.err.println("Error is in get All Applyed Project " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<ApplyProject> getApplyProjectByID(int id) {
        try {
            Collection<ApplyProject> users = em.createNamedQuery("ApplyProject.findByApplyProjectId")
                    .setParameter("createdDate", id)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public int createPost(int posterid, int skillid, int categid, Post post) {
        try {
            User u = em.find(User.class, posterid);
            Skill s = em.find(Skill.class, skillid);
            Categ c = em.find(Categ.class, categid);
            
            post.setPosterid(u);
            post.setSkillid(s);
            post.setCategId(c);
            
            em.merge(post);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create Post " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int removePost(int postid) {
        try {
            Post post = em.find(Post.class, postid);
            em.merge(post);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in delete Post " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public int updatePost(int skillid, int categid, Post post) {
        try {
            Skill s = em.find(Skill.class, skillid);
            Categ c = em.find(Categ.class, categid);
            
            post.setSkillid(s);
            post.setCategId(c);
            
            em.merge(post);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in update Post " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public Collection<Post> getAllPost() {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findAll")
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
        
    }
    
    @Override
    public Collection<Post> getAllPostByPostedOn(String date) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByPostedOn")
                    .setParameter("postedOn", date)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Post> getAllPostByPosterID(int posterid) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByPostedOn")
                    .setParameter("posterid", posterid)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post Collection " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Post> getAllPostByPrice(String price) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByPrice")
                    .setParameter("price", price)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post Collection " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Post> getAllPostByDuration(String duration) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByDuration")
                    .setParameter("duration", duration)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Post> getAllPostByTitle(String title) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByTitle")
                    .setParameter("title", title)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Post> getAllPostByUserID(int userID) {        return null;
    }
    
    @Override
    public User getUserByUserName(String username) {
      return null;
    }
    
}
