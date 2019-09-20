/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dhiraj Chauhan
 */
@Entity
@Table(name = "apply_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplyProject.findAll", query = "SELECT a FROM ApplyProject a"),
    @NamedQuery(name = "ApplyProject.findByApplyProjectId", query = "SELECT a FROM ApplyProject a WHERE a.applyProjectId = :applyProjectId"),
    @NamedQuery(name = "ApplyProject.findByApplyProjectByUserId",query = "SELECT a FROM ApplyProject a WHERE a.userid = :userid")})
public class ApplyProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "apply_project_id")
    private Integer applyProjectId;
    @Basic(optional = false)
    @Lob
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Lob
    @Column(name = "coverlatter")
    private String coverLatter;
    @Basic(optional = false)
    @Lob
    @Column(name = "applyon")
    private String applyOn;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userid;
    @JoinColumn(name = "postid", referencedColumnName = "postid")
    @ManyToOne(optional = false)
    private Post postid;

    public ApplyProject() {
    }

    public ApplyProject(Integer applyProjectId) {
        this.applyProjectId = applyProjectId;
    }

    public ApplyProject(Integer applyProjectId, String status, String coverLatter, String applyOn) {
        this.applyProjectId = applyProjectId;
        this.status = status;
        this.coverLatter = coverLatter;
        this.applyOn = applyOn;
    }

    public Integer getApplyProjectId() {
        return applyProjectId;
    }

    public void setApplyProjectId(Integer applyProjectId) {
        this.applyProjectId = applyProjectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverLatter() {
        return coverLatter;
    }

    public void setCoverLatter(String coverLatter) {
        this.coverLatter = coverLatter;
    }

    public String getApplyOn() {
        return applyOn;
    }

    public void setApplyOn(String applyOn) {
        this.applyOn = applyOn;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Post getPostid() {
        return postid;
    }

    public void setPostid(Post postid) {
        this.postid = postid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applyProjectId != null ? applyProjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplyProject)) {
            return false;
        }
        ApplyProject other = (ApplyProject) object;
        if ((this.applyProjectId == null && other.applyProjectId != null) || (this.applyProjectId != null && !this.applyProjectId.equals(other.applyProjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ApplyProject[ applyProjectId=" + applyProjectId + " ]";
    }

}
