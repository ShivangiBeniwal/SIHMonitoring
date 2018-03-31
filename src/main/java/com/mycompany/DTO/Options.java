/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shivangi
 */
@Entity
@Table(catalog = "final_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Options.findAll", query = "SELECT o FROM Options o"),
    @NamedQuery(name = "Options.findByOpid", query = "SELECT o FROM Options o WHERE o.opid = :opid")})
public class Options implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer opid;
    @Lob
    @Size(max = 65535)
    private String options;
    @JoinColumn(name = "QID", referencedColumnName = "QID")
    @ManyToOne(optional = false)
    private Question qid;

    public Options() {
    }

    public Options(Integer opid) {
        this.opid = opid;
    }

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Question getQid() {
        return qid;
    }

    public void setQid(Question qid) {
        this.qid = qid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opid != null ? opid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Options)) {
            return false;
        }
        Options other = (Options) object;
        if ((this.opid == null && other.opid != null) || (this.opid != null && !this.opid.equals(other.opid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DTO.Options[ opid=" + opid + " ]";
    }
    
}
