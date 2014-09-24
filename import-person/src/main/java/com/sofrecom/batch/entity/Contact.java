/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author r.benrejeb
 */
@Entity
@Table(name = "contact", catalog = "person", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "threadName")
    private String threadName;
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @OneToMany(mappedBy = "contact",fetch = FetchType.LAZY)
    private Set<RegistrationConfirmation> registrationconfirmationSet;

    public Contact() {
    }

    public Contact(Integer id) {
        this.id = id;
    }

    public Contact(String firstname, String lastname, Date birth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }

    public Contact(Integer id, String firstname, String lastname, String threadName, Date birth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.threadName = threadName;
        this.birth = birth;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Set<RegistrationConfirmation> getRegistrationconfirmationSet() {
        return registrationconfirmationSet;
    }

    public void setRegistrationconfirmationSet(Set<RegistrationConfirmation> registrationconfirmationSet) {
        this.registrationconfirmationSet = registrationconfirmationSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    
    @Override
    public String toString() {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (id!=null?id:"") + "," + firstname + "," + lastname + "," + dateFormat.format(birth)+","+threadName;
    }

    
}
