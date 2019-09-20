/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import EJB.AdminSessionBeanLocal;
import Entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import client.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
public class Test extends HttpServlet {

    @EJB
    AdminSessionBeanLocal asbl;
    AdminRestClient Adminclient = new AdminRestClient();
//    UserRestClient userRestClient = new UserRestClient();

//    Response res;
    User user;
//    Collection<User> users;
//    GenericType<Collection<User>> usersgeneric;
//    
//    Response reskill;
//    Skill Skill;
//    GenericType<Skill> skillgeneric;
//    
    UserGroup useruser = new UserGroup();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Dhiraj");

//            user = new User();
//
//            useruser = asbl.getUserGroupByUserId(26);
//            out.println("<h1>First Name " + useruser.getUserid().getFname() + "</h1>");
//            out.println("<h1>Last Name " + useruser.getUserid().getLname() + "</h1>");

//            Collection<User> users;
//            users = asbl.getAllUser();
//            asbl.removeSkill(11);
//            Adminclient = new AdminRestClient();
//            users = new ArrayList<>();
//            usersgeneric = new GenericType<Collection<User>>() {
//            };
//
//            res = Adminclient.getAllUser_XML(Response.class);
//            users = res.readEntity(usersgeneric);
//            for (User u : users) {
//
//                out.println("<h1> Id =" + u.getUserid() + " Name = " + u.getFname() + " " + u.getLname() + "</h1>");
//
//            }
//            user = new User();
//
            Categ c = new Categ();
            Skill s = new Skill();
            Post p = new Post();
//            user.setUserid(1);
//            s.setSkillid(30);
//            c.setCategid(1);
            p.setPosterid(user);
            p.setTitle("Chauhan");
//            p.setSkillid(s);
            p.setPrice("200000");
            p.setDuration("4 month");
            p.setHmworker("5");
            p.setJobdescr("kjdhfjhfhfsjhfjshfjshfsdhfjh");
//            p.setCategId(c);
            p.setPostedOn("22-8-2018");
            Adminclient.createPost_XML(p, Integer.toString(23), Integer.toString(31), Integer.toString(1));
            //asbl.createPost(21, 31, 1, p);
            // Adminclient.removePost(Integer.toString(10));
//            asbl.removePost(11);
//            try {
//
//            } catch (Exception e) {
//            }
//
//            Skill = new Skill();
//            skillgeneric = new GenericType<Skill>() {
//            };
//            reskill = Adminclient.getSkillByID_XML(Response.class, Integer.toString(30));
//            Skill = reskill.readEntity(skillgeneric);
//
//            out.println("<h1> Skill Name " + Skill.getSkill() + "</h1>");
//            out.println("<h1> Skill ID " + Skill.getSkillid() + "</h1>");
//
//            Categ c = new Categ();
//            GenericType<Categ> categGeneric = new GenericType<Categ>() {
//            };
//            Response categres;
//            categres = Adminclient.getCetegoresByID_XML(Response.class, Integer.toString(1));
//            c = categres.readEntity(categGeneric);
//
//            out.println("<h1> categ Name " + c.getCategname() + "</h1>");
//            out.println("<h1> categ ID " + c.getCategid() + "</h1>");
//            c.setCategid(5);
//            c.setCategname("Information Technology");
//            Adminclient.updateCetegores_JSON(c);
//            c.setCategname("Test123");
//            Adminclient.createCetegores_JSON(c);         
//            
//            s.setSkill("Dhiraj Chauhan");
//            Adminclient.createSkill_XML(s);
//            Adminclient.removeSkill(Integer.toString(9));
//            User u = new User("dhiraj","dhiraj","dhiraj@d.com","444444444","dhiraj","chauhan","dhiraj.jpg","asfdhmhgfdsasfghgfdss","22/09/2018" );
//            User u = new User();
//            u.setUsername("tetst");
//            u.setPassword("fsffsf");
//            u.setEmail("sandip@d.com");
//            u.setMobno("878787887");
//            u.setFname("sandip");
//            u.setLname("valvi");
//            u.setPhoto("sandip.jpg");
//            u.setDescription("i am sandip");
//            u.setCreatedon("22/09/2018");
//            Adminclient.createUser_XML(u, Integer.toString(30), Integer.toString(1));
//            u.setSkillid(new Integer("6"));
//            u.setUserid(6);
//            int i = 0;
//            i = asbl.createUser(u,new Integer("4"));
//            i = asbl.removeUser(new Integer("3"));
//            i = asbl.removeUser(new Integer("3"));
//            i = asbl.updateUser(u, new Integer("4"));
//            Post p = new Post();
//            p.setPostid(2);
//            ApplyProject ap = new ApplyProject();
////            ap.setUserid(u);
////            ap.setPostid(p);
//            ap.setApplyOn("40/8/2018");
//            ap.setStatus("Completed");
//            ap.setCoverLatter("dhiraj isdhdidh sdsajkakdadasd asd asd");
//            ap.setApplyProjectId(2);
//            // i = asbl.createapplyProject(2, 1, ap);
//
//            // i = asbl.updateApplyProject(3, 1, ap);
//            i = asbl.removeApplyProject(3);
//            if (i > 0) {
//                out.println("Sucesss");
//            } else {
//                out.println("Error");
//            }
//            List<User> users = asbl.getAllUser();
//            for (User u1 : users) {
//                out.println("<h1> Name  " + u1.getFname() + "</h1>");
//                out.println("<h1> Lastne  " + u1.getLname()+ "</h1>");
////                out.println("<h1> Name" + u1.getFname() + "</h1>");
////                out.println("<h1> Name" + u1.getFname() + "</h1>");
////                out.println("<h1> Name" + u1.getFname() + "</h1>");
//
//            }
//          out.println("<h1>Servlet Test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
