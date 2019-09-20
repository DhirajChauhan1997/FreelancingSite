/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.*;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dhiraj Chauhan
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

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
//            UserGroup ug = new UserGroup();
//            ug.setUserid(u);
//            ug.setGroupId(em.find(Grouptbl.class, groupid));
//            em.merge(ug);
            em.merge(u);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }

    }

    @Override
    public Collection<User> getAllUser() {
        try {
            Collection<User> allUserList = em.createNamedQuery("User.findAll")
                    .getResultList();
            return allUserList;
        } catch (Exception e) {
            System.err.println("Error is in Get All User " + e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByID(int userid) {
        try {
            User users = (User) em.createNamedQuery("User.findByUserid")
                    .setParameter("userid", userid)
                    .getSingleResult();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public User getOldpassData(String username, String oldPass) {
        User u = (User) em.createNamedQuery("User.findByUsernamePassword")
                .setParameter("username", username)
                .setParameter("password", oldPass)
                .getSingleResult();
        return u;
    }

    @Override
    public Collection<User> getAllUserByFirstName(String Firstname) {
        try {
            Collection<User> users = em.createNamedQuery("User.findByFname")
                    .setParameter("fname", Firstname)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<User> getAllUserByLastName(String Lastname) {
        try {
            Collection<User> users = em.createNamedQuery("User.findByLname")
                    .setParameter("lname", Lastname)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in get UserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<User> getAllUserByEmail(String Email) {
        try {
            Collection<User> users = em.createNamedQuery("User.findByEmail")
                    .setParameter("emial", Email)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<User> getAllUserByMobNo(String mobno) {
        try {
            Collection<User> users = em.createNamedQuery("User.findBymobno")
                    .setParameter("mobno", mobno)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<User> getAllUserByCreatedDate(String createdDate) {
        try {
            Collection<User> users = em.createNamedQuery("User.findBycreatedDate")
                    .setParameter("createdDate", createdDate)
                    .getResultList();
            return users;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
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
    public ApplyProject getApplyProjectByID(int id) {
        try {
            ApplyProject apply = (ApplyProject) em.createNamedQuery("ApplyProject.findByApplyProjectId")
                    .setParameter("applyProjectId", id)
                    .getResultList();
            return apply;
        } catch (Exception e) {
            System.err.println("Error is in get Apply  ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<ApplyProject> getApplyJobByPOsterID(int posterid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public int createCetegores(Categ categores) {
        try {
            em.persist(categores);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Create Categ " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeCetegores(int categID) {
        try {
            Categ c = em.find(Categ.class, categID);
            em.remove(c);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in RemoveCategores " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateCetegores(Categ categ) {
        try {
            em.merge(categ);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Update Categores " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Collection<Categ> getAllCetegores() {
        try {
            List<Categ> allCategores = em.createNamedQuery("Categ.findAll").getResultList();
            return allCategores;
        } catch (Exception e) {
            System.out.println("Error is in " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Categ> getCetegoresByName(String categName) {
        try {
            Collection<Categ> categores = em.createNamedQuery("Categ.findByCategName")
                    .setParameter("categname", categName)
                    .getResultList();
            return categores;
        } catch (Exception e) {
            System.err.println("Error is in getUserBy ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public Categ getCetegoresByID(int categID) {
        try {
            Categ categores = (Categ) em.createNamedQuery("Categ.findByCategid")
                    .setParameter("categid", categID)
                    .getSingleResult();
            return categores;
        } catch (Exception e) {
            System.err.println("Error is in get cetegores by id ID " + e.getMessage());
            return null;
        }
    }

    @Override
    public int createSkill(Skill skill) {
        try {

            em.persist(skill);
            em.flush();
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeSkill(int skillID) {
        try {
            Skill s = em.find(Skill.class, skillID);
            em.remove(s);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Remove Skill " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateSkill(Skill skill) {
        try {
            em.merge(skill);
            return 1;
        } catch (Exception e) {
            System.out.println("Error is in Update Skill " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Collection<Skill> getAllSkill() {
        try {
            Collection<Skill> skills = em.createNamedQuery("Skill.findAll")
                    .getResultList();
            return skills;
        } catch (Exception e) {
            System.out.println("Error is in getAll Skill " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Skill> getSkillByName(String skill) {

        try {
            Collection<Skill> skills = em.createNamedQuery("Skill.findBySkill")
                    .setParameter("skill", skill)
                    .getResultList();
            return skills;
        } catch (Exception e) {
            System.out.println("Error is in Update Skill " + e.getMessage());
            return null;
        }
    }

    @Override
    public Skill getSkillByID(int skillID) {
        try {
            Skill skill = (Skill) em.createNamedQuery("Skill.findBySkillid")
                    .setParameter("skillid", skillID)
                    .getSingleResult();
            return skill;
        } catch (Exception e) {
            System.out.println("Error is in Update Skill " + e.getMessage());
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

            em.persist(post);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create Post in Admin Session Bean " + e);
            return 0;
        }
    }

    @Override
    public int removePost(int postid) {
        try {
            Post post = em.find(Post.class, postid);
            em.remove(post);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in delete Post " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updatePost(int posterid, int skillid, int categid, Post post) {
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
    public Post getAllPostByPostID(int postid) {
        try {
            Post posts = (Post) em.createNamedQuery("Post.findByPostid")
                    .setParameter("postid", postid)
                    .getSingleResult();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Post> getAllPostByPosterId(int posterid) {
        try {
            User u = em.find(User.class, posterid);
            Collection<Post> posts = em.createNamedQuery("Post.findByPosterID", Post.class)
                    .setParameter("posterid", u)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List By Poster ID" + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<ApplyProject> getApplyJobyByUserid(int userid) {
        User u = em.find(User.class, userid);
        Collection<ApplyProject> appyesProject = em.createNamedQuery("ApplyProject.findByApplyProjectByUserId")
                .setParameter("userid", u)
                .getResultList();
        return appyesProject;
    }

//    @Override
//    public List<Post> getAllPostBySkillID(int skillID) {
//        try {
//            List<Post> posts = em.createNamedQuery("Post.f")
//                    .setParameter("postedOn", skillID);
//                    .getResultList();
//            return posts;
//        } catch (Exception e) {
//            System.out.println("Error is in Post List " + e.getMessage());
//            return null;
//        }
//    }
//    @Override
//    public List<Post> getAllPostBySkill(String skill) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public List<Post> getAllPostByCategores(String Categores) {
//        try {
//            List<Post> posts = em.createNamedQuery("Post.fin")
//                    .setParameter("postedOn", Categores)
//                    .getResultList();
//            return posts;
//        } catch (Exception e) {
//            System.out.println("Error is in Post List " + e.getMessage());
//            return null;
//        }
//    }
//    @Override
//    public List<Post> getAllPostByCategores(int categID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public Collection<Post> getAllPostByPrice(String price) {
        try {
            Collection<Post> posts = em.createNamedQuery("Post.findByPrice")
                    .setParameter("price", price)
                    .getResultList();
            return posts;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
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
    public int createGroup(Grouptbl Group) {
        try {

            em.persist(Group);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeGroup(int GroupID) {
        try {
            Grouptbl g = em.find(Grouptbl.class, GroupID);
            em.remove(g);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateGroup(Grouptbl Group) {
        try {
            em.merge(Group);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Collection<Grouptbl> getAllGroup() {
        try {
            Collection<Grouptbl> grouptbls = em.createNamedQuery("Grouptbl.findAll")
                    .getResultList();
            return grouptbls;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Grouptbl> getGroupByName(String groupName) {
        try {
            Collection<Grouptbl> grouptbls = em.createNamedQuery("Grouptbl.findByGroupName")
                    .setParameter("groupName", groupName)
                    .getResultList();
            return grouptbls;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Grouptbl> getGroupByID(int groupID) {
        try {
            Collection<Grouptbl> grouptbls = em.createNamedQuery("Grouptbl.findByGroupId")
                    .setParameter("groupId", groupID)
                    .getResultList();
            return grouptbls;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }

    @Override
    public int createUserGroup(int GroupID, int userid) {
        try {
            Grouptbl g = em.find(Grouptbl.class, GroupID);
            User u = em.find(User.class, userid);
            UserGroup ug = new UserGroup();
            ug.setGroupId(g);
            ug.setUserid(u);
            em.persist(ug);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Group Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeUserGroup(int user_group_id) {
        try {
            UserGroup ug = em.find(UserGroup.class, user_group_id);
            em.remove(ug);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateUserGroup(int user_group_id, int GroupID, int userid) {
        try {
            Grouptbl g = em.find(Grouptbl.class, GroupID);
            User u = em.find(User.class, userid);
            UserGroup ug = em.find(UserGroup.class, user_group_id);
            ug.setGroupId(g);
            ug.setUserid(u);
            em.merge(ug);
            return 1;
        } catch (Exception e) {
            System.err.println("Error is in Create User Group Method " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Collection<UserGroup> getAllUserGroup() {
        try {
            Collection<UserGroup> userGroups = em.createNamedQuery("UserGroup.findAll")
                    .getResultList();
            return userGroups;
        } catch (Exception e) {
            System.out.println("Error is in Post List " + e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            User user = (User) em.createNamedQuery("User.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            return user;
        } catch (Exception e) {
            System.err.println("Error is " + e);
            return null;
        }
    }

    @Override
    public UserGroup getUserGroupByUserId(int userid) {
        try {

            UserGroup ug = (UserGroup) em.createNamedQuery("UserGroup.findByUserId")
                    .setParameter("userid", userid)
                    .getSingleResult();

            return ug;
        } catch (Exception e) {
            System.err.println("Error is " + e);
            return null;
        }
    }

    @Override
    public int checkUserNameAvailability(String username) {
        try {
            Collection<User> u = em.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", username)
                    .getResultList();

            int i = 0;
            for (User usr : u) {
                i = i + 1;
            }
            if (i > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("error is in" + e.getMessage());
            return 0;
        }
    }

    @Override
    public int checkEmailAvailability(String email) {
        try {
            Collection<User> u = em.createNamedQuery("User.findByEmail", User.class)
                    .setParameter("username", email)
                    .getResultList();

            int i = 0;
            for (User usr : u) {
                i = i + 1;
            }
            if (i > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("error is in" + e.getMessage());
            return 0;
        }
    }

    @Override
    public User getUserbyEmail(String email) {
        return (User) em.createNamedQuery("User.findByEmail").setParameter("email", email).getSingleResult();
    }

}
