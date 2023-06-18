package com.example.bank_security.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Table(name = "notice_details", schema = "bank_security")
public class NoticeDetailsEntity {


    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Id
    @Column(name = "notice_id")
    private int noticeId;
    @Basic
    @Column(name = "notice_summary")
    private String noticeSummary;
    @Basic
    @Column(name = "notice_details")
    private String noticeDetails;
    @Basic
    @Column(name = "notic_beg_dt")
    private Date noticBegDt;
    @Basic
    @Column(name = "notic_end_dt")
    private Date noticEndDt;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;
    @Basic
    @Column(name = "update_dt")
    private Date updateDt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticBegDt() {
        return noticBegDt;
    }

    public void setNoticBegDt(Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public Date getNoticEndDt() {
        return noticEndDt;
    }

    public void setNoticEndDt(Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticeDetailsEntity that = (NoticeDetailsEntity) o;

        if (noticeId != that.noticeId) return false;
        if (noticeSummary != null ? !noticeSummary.equals(that.noticeSummary) : that.noticeSummary != null)
            return false;
        if (noticeDetails != null ? !noticeDetails.equals(that.noticeDetails) : that.noticeDetails != null)
            return false;
        if (noticBegDt != null ? !noticBegDt.equals(that.noticBegDt) : that.noticBegDt != null) return false;
        if (noticEndDt != null ? !noticEndDt.equals(that.noticEndDt) : that.noticEndDt != null) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (updateDt != null ? !updateDt.equals(that.updateDt) : that.updateDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noticeId;
        result = 31 * result + (noticeSummary != null ? noticeSummary.hashCode() : 0);
        result = 31 * result + (noticeDetails != null ? noticeDetails.hashCode() : 0);
        result = 31 * result + (noticBegDt != null ? noticBegDt.hashCode() : 0);
        result = 31 * result + (noticEndDt != null ? noticEndDt.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (updateDt != null ? updateDt.hashCode() : 0);
        return result;
    }
}
