/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "grouptbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouptbl.findAll", query = "SELECT g FROM Grouptbl g"),
    @NamedQuery(name = "Grouptbl.findByGroupId", query = "SELECT g FROM Grouptbl g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Grouptbl.findByGroupName", query = "SELECT g FROM Grouptbl g WHERE g.groupName = :groupName")})
public class Grouptbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupid")
    private Integer groupId;
    @Basic(optional = false)
    @Column(name = "groupname")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<UserGroup> userGroupList;

    public Grouptbl() {
    }

    public Grouptbl(Integer groupId) {
        this.groupId = groupId;
    }

    public Grouptbl(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public List<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouptbl)) {
            return false;
        }
        Grouptbl other = (Grouptbl) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Grouptbl[ groupId=" + groupId + " ]";
    }
    
}
