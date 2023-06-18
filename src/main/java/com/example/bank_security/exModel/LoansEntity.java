package com.example.bank_security.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "loans", schema = "bank_security")
public class LoansEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "loan_number")
    private int loanNumber;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "start_dt")
    private Date startDt;
    @Basic
    @Column(name = "loan_type")
    private String loanType;
    @Basic
    @Column(name = "total_loan")
    private int totalLoan;
    @Basic
    @Column(name = "amount_paid")
    private int amountPaid;
    @Basic
    @Column(name = "outstanding_amount")
    private int outstandingAmount;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(int totalLoan) {
        this.totalLoan = totalLoan;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
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

        LoansEntity that = (LoansEntity) o;

        if (loanNumber != that.loanNumber) return false;
        if (customerId != that.customerId) return false;
        if (totalLoan != that.totalLoan) return false;
        if (amountPaid != that.amountPaid) return false;
        if (outstandingAmount != that.outstandingAmount) return false;
        if (startDt != null ? !startDt.equals(that.startDt) : that.startDt != null) return false;
        if (loanType != null ? !loanType.equals(that.loanType) : that.loanType != null) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loanNumber;
        result = 31 * result + customerId;
        result = 31 * result + (startDt != null ? startDt.hashCode() : 0);
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        result = 31 * result + totalLoan;
        result = 31 * result + amountPaid;
        result = 31 * result + outstandingAmount;
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
    }
}
