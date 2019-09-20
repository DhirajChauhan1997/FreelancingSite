/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Entity.Skill;
import client.AdminRestClient;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "skillManagedBean")
@ViewScoped
public class SkillManagedBean implements Serializable {

    private int skillid;
    
    HttpServletRequest objHttpServletRequest;

    private String skill;

    Collection<Skill> skillList;
    AdminRestClient Adminclient = new AdminRestClient();

    private GenericType<Collection<Skill>> genericSkillList;
    private Response rs;

//    private Map<String, Object> sessionMap = FacesContext.
//            getCurrentInstance().getExternalContext().getSessionMap();
    
    
    /**
     * Get Skill Info From single object
     */
    
    Response reskill;
    Skill s;
    GenericType<Skill> skillgeneric;
    SkillManagedBean skillManagedBean;

    /**
     * Creates a new instance of SkillManagedBean
     */
    public SkillManagedBean() {

        objHttpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

    }

    public void createSkill() {
        try {
            skillManagedBean = new SkillManagedBean();
            skillManagedBean.setSkill(skill);

            Adminclient.createSkill_JSON(skillManagedBean);

            FacesContext.getCurrentInstance().getExternalContext().redirect("SkillList.jsf");

            if (skill != null || !skill.equals("")) {
                skill = "";
            }
        } catch (Exception e) {
            System.err.println("Error is in create skill " + e.getMessage());
        }

//        return "/SkillList.xhtml?faces-redirect=true";
    }

    public int getSkillid() {
        return skillid;
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Collection getSkillList() {
//        adminRestClient = new AdminRestClient();
        rs = Adminclient.getAllSkill_XML(Response.class);
        skillList = new ArrayList<>();
        genericSkillList = new GenericType<Collection<Skill>>() {
        };
        skillList = rs.readEntity(genericSkillList);
        return skillList;
    }

    public void setSkillList(Collection<Skill> skillList) {
        this.skillList = skillList;
    }

    public void editSkill(int skillid) throws Exception {

        SkillManagedBean SMB = null;

        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();

        try {
            s = new Skill();//entity class
            skillgeneric = new GenericType<Skill>() {
            };
            reskill = Adminclient.getSkillByID_XML(Response.class, Integer.toString(skillid));
            s = reskill.readEntity(skillgeneric);

            SMB = new SkillManagedBean();

            SMB.setSkillid(s.getSkillid());
            SMB.setSkill(s.getSkill());

            sessionMap.put("editSkillDetail", SMB);

            FacesContext.getCurrentInstance().getExternalContext().redirect("EditSkill.jsf");

        } catch (Exception e) {
            System.out.println("Error is in editSkill method " + e);
        }
    }

    public void updateSkill(SkillManagedBean skillManagedBean) {

        try {

//          skillManagedBean = new SkillManagedBean();
            skillManagedBean.setSkill(skillManagedBean.getSkill());
            skillManagedBean.setSkillid(skillManagedBean.getSkillid());
            Adminclient.updateSkill_JSON(skillManagedBean);

            FacesContext.getCurrentInstance().getExternalContext().redirect("SkillList.jsf");
            skill = "";
        } catch (Exception e) {

            System.err.println("Error is in create skill " + e.getMessage());

        }

//        return "/SkillList.xhtml?faces-redirect=true";
    }

    public void reset(){
        skill=null;
    }
    public void removeSkill(int skillid) {
        try {
//            if (objHttpServletRequest.getParameter("skillid") != null) {
            Adminclient.removeSkill(Integer.toString(skillid));
            FacesContext.getCurrentInstance().getExternalContext().redirect("SkillList.jsf");
//            }

        } catch (Exception e) {
            System.out.println("Error is in removeSkill " + e.getMessage());
        }
    }

}
