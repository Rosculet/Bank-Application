package com.example.bank_security.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "contact_messages", schema = "bank_security")
public class ContactMessagesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contact_id")
    private String contactId;
    @Basic
    @Column(name = "contact_name")
    private String contactName;
    @Basic
    @Column(name = "contact_email")
    private String contactEmail;
    @Basic
    @Column(name = "subject")
    private String subject;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactMessagesEntity that = (ContactMessagesEntity) o;

        if (contactId != null ? !contactId.equals(that.contactId) : that.contactId != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId != null ? contactId.hashCode() : 0;
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
    }
}
