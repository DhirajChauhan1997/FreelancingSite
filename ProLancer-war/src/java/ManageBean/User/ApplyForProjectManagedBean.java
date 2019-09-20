/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean.User;

import EJB.AdminSessionBeanLocal;
import Entity.ApplyProject;
import ManageBean.ApplyProjectManagedBean;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "Applyjob")
@RequestScoped
public class ApplyForProjectManagedBean {

    @EJB
    AdminSessionBeanLocal asbl;

    int applyProjectId, postid, userid;
    String status, coverlatter, applyon;
    ApplyForProjectManagedBean applyForProjectManagedBean;
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession session = request.getSession();
    int uid = (int) session.getAttribute("userid");

    public void redirectapply(int id) throws Exception {
        System.err.println("------------------inredirect method---------------");
        session.setAttribute("postid", id);
        redirect("ApplyForJob.jsf");

    }

    public void createApplyProject() throws IOException {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);

        applyForProjectManagedBean = new ApplyForProjectManagedBean();
        applyForProjectManagedBean.setStatus("Pending");
        applyForProjectManagedBean.setCoverlatter(coverlatter);
        applyForProjectManagedBean.setApplyon(strDate);

        ApplyProject ap = new ApplyProject();

        ap.setApplyOn(strDate);
        ap.setCoverLatter(coverlatter);
        ap.setStatus("Pending");
        int pid = (int) session.getAttribute("postid");

        asbl.createapplyProject(pid, uid, ap);
        session.setAttribute("postid", null);
        redirect("index.jsf");

    }

    public Collection<ApplyProject> getApplyJobyByUserid() {
        Collection<ApplyProject> getApplyJobyByUserids = asbl.getApplyJobyByUserid(uid);
        return getApplyJobyByUserids;
    }

    private void redirect(String url) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(url);
    }

    public ApplyForProjectManagedBean() {
    }

    public int getApplyProjectId() {
        return applyProjectId;
    }

    public void setApplyProjectId(int applyProjectId) {
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

    public void setStatus(String status) {
        this.status = status;
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

}
