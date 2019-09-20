/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dhiraj Chauhan
 */
@Entity
@Table(name = "post")
@XmlRootElement
@XmlTransient
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByPostid", query = "SELECT p FROM Post p WHERE p.postid = :postid"),
    @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title"),
    @NamedQuery(name = "Post.findByPrice", query = "SELECT p FROM Post p WHERE p.price = :price"),
    @NamedQuery(name = "Post.findByDuration", query = "SELECT p FROM Post p WHERE p.duration = :duration"),
    @NamedQuery(name = "Post.findByHmworker", query = "SELECT p FROM Post p WHERE p.hmworker = :hmworker"),
    @NamedQuery(name = "Post.findByJobdescr", query = "SELECT p FROM Post p WHERE p.jobdescr = :jobdescr"),
    @NamedQuery(name = "Post.findByPostedOn", query = "SELECT p FROM Post p WHERE p.postedOn = :postedOn")})
public class Post implements Serializable {

//    String te = "@NamedQuery(name = \"post.findAllData\", query = \"SELECT p FROM post p ,(select u from user u where u.userid=p.userid)as fname,(SELECT s FROM skill WHERE s.skillid=p.skillid)as skill,(SELECT c FROM categ WHERE c.categid=p.categid) as categname from post p\")})\n";
//    String st = "    @NamedQuery(name = "Post.findAllData", query = "SELECT p from Post p (SELECT fname FROM user u WHERE u.userid=post p.posterid) as fname (SELECT skill s FROM skill s WHERE skillid=post.skillid)as skill (SELECT categname FROM categ WHERE categid=post.categid) as categname from post p")})";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postid")
    private Integer postid;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @Column(name = "duration")
    private String duration;
    @Basic(optional = false)
    @Column(name = "hmworker")
    private String hmworker;
    @Basic(optional = false)
    @Column(name = "jobdescr")
    private String jobdescr;
    @Basic(optional = false)
    @Column(name = "postedon")
    private String postedOn;
    @JoinColumn(name = "posterid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User posterid;
    @JoinColumn(name = "skillid", referencedColumnName = "skillid")
    @ManyToOne(optional = false)
    private Skill skillid;
    @JoinColumn(name = "categid", referencedColumnName = "categid")
    @ManyToOne(optional = false)
    private Categ categId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postid")
    private List<ApplyProject> applyProjectList;

    public Post() {
    }

    public Post(Integer postid) {
        this.postid = postid;
    }

    public Post(Integer postid, String title, String price, String duration, String hmworker, String jobdescr, String postedOn) {
        this.postid = postid;
        this.title = title;
        this.price = price;
        this.duration = duration;
        this.hmworker = hmworker;
        this.jobdescr = jobdescr;
        this.postedOn = postedOn;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHmworker() {
        return hmworker;
    }

    public void setHmworker(String hmworker) {
        this.hmworker = hmworker;
    }

    public String getJobdescr() {
        return jobdescr;
    }

    public void setJobdescr(String jobdescr) {
        this.jobdescr = jobdescr;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    @JsonbTransient
    public User getPosterid() {
        return posterid;
    }

    public void setPosterid(User posterid) {
        this.posterid = posterid;
    }

    @JsonbTransient
    public Skill getSkillid() {
        return skillid;
    }

    public void setSkillid(Skill skillid) {
        this.skillid = skillid;
    }

    @JsonbTransient
    public Categ getCategId() {
        return categId;
    }

    public void setCategId(Categ categId) {
        this.categId = categId;
    }

    @XmlTransient
    @JsonbTransient
    public List<ApplyProject> getApplyProjectList() {
        return applyProjectList;
    }

    public void setApplyProjectList(List<ApplyProject> applyProjectList) {
        this.applyProjectList = applyProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postid != null ? postid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.postid == null && other.postid != null) || (this.postid != null && !this.postid.equals(other.postid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Post[ postid=" + postid + " ]";
    }

}
