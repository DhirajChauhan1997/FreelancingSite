/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import Entity.*;
import client.AdminRestClient;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "categManageBean")
@RequestScoped
public class CategManageBean implements Serializable {

    String categname;
    int categid;
    Collection<Categ> categList;

    AdminRestClient adminRestClient = new AdminRestClient();

    GenericType<Collection<Categ>> genericCategList;
    Response rs;

    /**
     * For get Single Object Of categores
     */
    Categ c;
    CategManageBean categManageBean;
    Response categRes;
    GenericType<Categ> genericCateg;

    public String getCategname() {
        return categname;
    }

    public void setCategname(String categname) {
        this.categname = categname;
    }

    public int getCategid() {
        return categid;
    }

    public void setCategid(int categid) {
        this.categid = categid;
    }

    public Collection getCategList() {
        rs = adminRestClient.getAllCetegores_XML(Response.class);
        categList = new ArrayList<>();
        genericCategList = new GenericType<Collection<Categ>>() {
        };
        categList = rs.readEntity(genericCategList);
        return categList;
    }

    public void setCategList(Collection<Categ> categList) {
        this.categList = categList;
    }

    public void createCate() {
        try {

            categManageBean = new CategManageBean();
            categManageBean.setCategname(categname);
            System.out.println("*-*-*-*-*-**-*-*-*-*");
            System.out.println("Categore  is " + categManageBean.getCategname());
            adminRestClient.createCetegores_JSON(categManageBean);

            redirect("CategList.jsf");
            categname = "";

        } catch (IOException | ClientErrorException e) {

            System.err.println("Error is in create Categ " + e);

        }
    }

    public void editCateg(int categid) {
        CategManageBean CMB = null;
        Map<String, Object> sessionMap = FacesContext.
                getCurrentInstance().getExternalContext().getSessionMap();
        try {
            System.err.println("Skill id is " + categid);
            c = new Categ();
            genericCateg = new GenericType<Categ>() {
            };

            categRes = adminRestClient.getCetegoresByID_XML(Response.class, Integer.toString(categid));
            c = categRes.readEntity(genericCateg);

            System.err.println("<Categ entity> Categ Name " + c.getCategname() + "<Categ entity>");
            System.err.println("<Categ entity> categ ID " + c.getCategid() + "<Categ entity>");

            CMB = new CategManageBean();

            CMB.setCategid(c.getCategid());
            CMB.setCategname(c.getCategname());

            System.err.println("Categ name is " + CMB.getCategname());
            System.err.println("Categ id is " + CMB.getCategid());

            sessionMap.put("editCategDetail", CMB);

            FacesContext.getCurrentInstance().getExternalContext().redirect("EditCateg.jsf");

        } catch (IOException | ClientErrorException e) {
            System.out.println("Error " + e);
        }
    }

    public void updateCateg(CategManageBean categManageBean) {
        try {

//            skillManagedBean = new SkillManagedBean();
            categManageBean.setCategid(categManageBean.getCategid());
            categManageBean.setCategname(categManageBean.getCategname());
            adminRestClient.updateCetegores_JSON(categManageBean);

            redirect("CategList.jsf");
            categname = "";
        } catch (IOException | ClientErrorException e) {

            System.err.println("Error is in create skill " + e.getMessage());

        }
    }

    public void reset() {
        categname = null;
    }

    public void cancel() throws Exception {
        redirect("CategList.jsf");
    }

    public void removeCateg(int categid) {
        try {
//            if (objHttpServletRequest.getParameter("skillid") != null) {
            adminRestClient.removeCetegores(Integer.toString(categid));
            redirect("CategList.jsf");
//            }

        } catch (Exception e) {
            System.out.println(" Error is in remove Categ " + e.getMessage());
        }
    }

    private void redirect(String url) throws IOException {
        FacesContext objFacesContext = FacesContext.getCurrentInstance();
        objFacesContext.getExternalContext().redirect(url);
    }

    /**
     * Creates a new instance of CategManageBean
     */
    public CategManageBean() {
    }

}
