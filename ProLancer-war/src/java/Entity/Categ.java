/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categ")
@XmlRootElement
@XmlTransient
@NamedQueries({
    @NamedQuery(name = "Categ.findAll", query = "SELECT c FROM Categ c"),
    @NamedQuery(name = "Categ.findByCategid", query = "SELECT c FROM Categ c WHERE c.categid = :categid"),
    @NamedQuery(name = "Categ.findByCategname", query = "SELECT c FROM Categ c WHERE c.categname = :categname")})
public class Categ implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categid")
    private Collection<Post> postCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categid")
    private Integer categid;
    @Basic(optional = false)
    @Column(name = "categname")
    private String categname;

    public Categ() {
    }

    public Categ(Integer categid) {
        this.categid = categid;
    }

    public Categ(Integer categid, String categname) {
        this.categid = categid;
        this.categname = categname;
    }

    public Integer getCategid() {
        return categid;
    }

    public void setCategid(Integer categid) {
        this.categid = categid;
    }

    public String getCategname() {
        return categname;
    }

    public void setCategname(String categname) {
        this.categname = categname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categid != null ? categid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categ)) {
            return false;
        }
        Categ other = (Categ) object;
        if ((this.categid == null && other.categid != null) || (this.categid != null && !this.categid.equals(other.categid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Categ[ categid=" + categid + " ]";
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }
    
}
