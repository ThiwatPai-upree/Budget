/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SONY
 */
@Entity
@Table(name = "employee_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeSkill.findAll", query = "SELECT e FROM EmployeeSkill e")
    , @NamedQuery(name = "EmployeeSkill.findByEsid", query = "SELECT e FROM EmployeeSkill e WHERE e.esid = :esid")
    , @NamedQuery(name = "EmployeeSkill.findByEdi", query = "SELECT e FROM EmployeeSkill e WHERE e.edi = :edi")
    , @NamedQuery(name = "EmployeeSkill.findBySid", query = "SELECT e FROM EmployeeSkill e WHERE e.sid = :sid")})
public class EmployeeSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "esid")
    private Integer esid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edi")
    private int edi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sid")
    private int sid;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Integer esid) {
        this.esid = esid;
    }

    public EmployeeSkill(Integer esid, int edi, int sid) {
        this.esid = esid;
        this.edi = edi;
        this.sid = sid;
    }

    public Integer getEsid() {
        return esid;
    }

    public void setEsid(Integer esid) {
        this.esid = esid;
    }

    public int getEdi() {
        return edi;
    }

    public void setEdi(int edi) {
        this.edi = edi;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esid != null ? esid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeSkill)) {
            return false;
        }
        EmployeeSkill other = (EmployeeSkill) object;
        if ((this.esid == null && other.esid != null) || (this.esid != null && !this.esid.equals(other.esid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EmployeeSkill[ esid=" + esid + " ]";
    }
    
}
