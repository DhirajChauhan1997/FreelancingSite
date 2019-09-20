/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import EJB.AdminSessionBeanLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import Entity.*;
import client.AdminRestClient;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "applyProjectManagedBean")
@ViewScoped
public class ApplyProjectManagedBean implements Serializable {

    @EJB
    AdminSessionBeanLocal asbl;

    int applyProjectId, postid, userid;
    String status, coverlatter, applyon;

    Collection<ApplyProject> applyProjectList;
    ApplyProjectManagedBean applyProjectManagedBean;
    AdminRestClient adminRestClient = new AdminRestClient();
    Response res;
    GenericType<Collection<ApplyProject>> genericApplyProjectList;

    ApplyProject ap;
    GenericType<ApplyProject> genericApply;
    Response resApply;

    public Collection getApplyProjectList() {
        applyProjectList = new ArrayList<>();
        genericApplyProjectList = new GenericType<Collection<ApplyProject>>() {
        };
        res = adminRestClient.getAllApplyProject_XML(Response.class);
        applyProjectList = res.readEntity(genericApplyProjectList);
        return applyProjectList;
    }

    public void createApplyProject() throws IOException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        applyProjectManagedBean = new ApplyProjectManagedBean();
        applyProjectManagedBean.setStatus(status);
        applyProjectManagedBean.setCoverlatter(coverlatter);
        applyProjectManagedBean.setApplyon(strDate);
        applyProjectManagedBean.setUserid(userid);
        applyProjectManagedBean.setPostid(postid);

        ApplyProject ap = new ApplyProject();

        ap.setApplyOn(strDate);
        ap.setCoverLatter(coverlatter);
        ap.setStatus(status);
        asbl.createapplyProject(postid, userid, ap);
        redirect("ApplyProjectList.jsf");

    }

    public void createApplyProjectRest() {
        try {
            applyProjectManagedBean = new ApplyProjectManagedBean();
            applyProjectManagedBean.setStatus(status);
            applyProjectManagedBean.setCoverlatter(coverlatter);
            applyProjectManagedBean.setApplyon(applyon);
            adminRestClient.createapplyProject_JSON(applyProjectManagedBean,
                    Integer.toString(postid), Integer.toString(userid));
        } catch (Exception e) {
            System.out.println("Error is in Apply Project in bean " + e);
        }
    }

    public void editApplyProject(int applyProjectId) {
        applyProjectManagedBean = null;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();
        try {
            ap = new ApplyProject();
            genericApply = new GenericType<ApplyProject>() {
            };
            resApply = adminRestClient.getApplyProjectByID_XML(Response.class, Integer.toString(applyProjectId));
            ap = resApply.readEntity(genericApply);

            applyProjectManagedBean = new ApplyProjectManagedBean();
            applyProjectManagedBean.setPostid(ap.getPostid().getPostid());
            applyProjectManagedBean.setUserid(ap.getUserid().getUserid());
            applyProjectManagedBean.setCoverlatter(ap.getCoverLatter());
            applyProjectManagedBean.setStatus(ap.getStatus());

            sessionMap.put("editApplyDetail", applyProjectManagedBean);

            FacesContext.getCurrentInstance().getExternalContext().redirect("EditApplyProject.jsf");
        } catch (Exception e) {
        }
    }

    public void upadte(ApplyProjectManagedBean applyProjectManagedBean) throws IOException {

        adminRestClient.updateApplyProject_JSON(applyProjectManagedBean, Integer.toString(postid), Integer.toString(userid));
        FacesContext.getCurrentInstance().getExternalContext().redirect("ApplyProjectList.jsf");

    }

    public void removeApplyProject(int applyProjectId) {
        try {
            adminRestClient.removeApplyProject(Integer.toString(applyProjectId));
            FacesContext.getCurrentInstance().getExternalContext().redirect("ApplyProjectList.jsf");

        } catch (Exception e) {
            System.out.println("Error is in remove Apply Project " + e);
        }
    }

    public void reset() {
        userid=-1;
        postid=-1;
        status = null;
        coverlatter = null;
        applyon = null;
    }

    private void redirect(String pagename) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(pagename);
    }

    public void setApplyProjectList(Collection<ApplyProject> applyProjectList) {
        this.applyProjectList = applyProjectList;
    }

    public int applyProjectId() {
        return applyProjectId;
    }

    public void applyProjectId(int applyProjectId) {
        this.applyProjectId = applyProjectId;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String ststus) {
        this.status = ststus;
    }

    public String getCoverlatter() {
        return coverlatter;
    }

    public void setCoverlatter(String coverlatter) {
        this.coverlatter = coverlatter;
    }

    public String getApplyon() {
        return applyon;
    }

    public void setApplyon(String applyon) {
        this.applyon = applyon;
    }

    public ApplyProjectManagedBean() {
    }

}
