/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.batch.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author r.benrejeb
 */
@Entity
@Table(name = "registrationconfirmation", catalog = "person", schema = "")
public class RegistrationConfirmation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "contact", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Contact contact;
    @Column(name = "confirmation")
    private Boolean confirmation;
    @Column(name = "confirmationTime")
    @Temporal(TemporalType.TIME)
    private Date confirmationTime;

    public RegistrationConfirmation() {
    }

    public RegistrationConfirmation(Integer id) {
        this.id = id;
    }

    public RegistrationConfirmation(Contact contact, Boolean confirmation, Date confirmationTime) {
        this.contact = contact;
        this.confirmation = confirmation;
        this.confirmationTime = confirmationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfirmationTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.hh.MM.ss");
        return dateFormat.format(confirmationTime);
    }

    public void setConfirmationTime(Date confirmationTime) {
        this.confirmationTime = confirmationTime;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
        if (!(object instanceof RegistrationConfirmation)) {
            return false;
        }
        RegistrationConfirmation other = (RegistrationConfirmation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistrationConfirmation{" + "id=" + id + ", contact=" + contact + ", confirmation=" + confirmation + ", confirmationTime=" + confirmationTime + '}';
    }

   
}
