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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dhiraj Chauhan
 */
@Entity
@Table(name = "job_complete")
@XmlRootElement
@XmlTransient
@NamedQueries({
    @NamedQuery(name = "JobComplete.findAll", query = "SELECT j FROM JobComplete j"),
    @NamedQuery(name = "JobComplete.findByJobComplateId", query = "SELECT j FROM JobComplete j WHERE j.jobComplateId = :jobComplateId"),
    @NamedQuery(name = "JobComplete.findByPostid", query = "SELECT j FROM JobComplete j WHERE j.postid = :postid")})
public class JobComplete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "job_complate_id")
    private Integer jobComplateId;
    @Basic(optional = false)
    @Column(name = "postid")
    private int postid;
    @Basic(optional = false)
    @Lob
    @Column(name = "finish_on")
    private String finishOn;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userid;

    public JobComplete() {
    }

    public JobComplete(Integer jobComplateId) {
        this.jobComplateId = jobComplateId;
    }

    public JobComplete(Integer jobComplateId, int postid, String finishOn) {
        this.jobComplateId = jobComplateId;
        this.postid = postid;
        this.finishOn = finishOn;
    }

    public Integer getJobComplateId() {
        return jobComplateId;
    }

    public void setJobComplateId(Integer jobComplateId) {
        this.jobComplateId = jobComplateId;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getFinishOn() {
        return finishOn;
    }

    public void setFinishOn(String finishOn) {
        this.finishOn = finishOn;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobComplateId != null ? jobComplateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobComplete)) {
            return false;
        }
        JobComplete other = (JobComplete) object;
        if ((this.jobComplateId == null && other.jobComplateId != null) || (this.jobComplateId != null && !this.jobComplateId.equals(other.jobComplateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.JobComplete[ jobComplateId=" + jobComplateId + " ]";
    }
    
}
