package com.example.bank_security.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "account_transactions", schema = "bank_security")
public class AccountTransactionsEntity {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;
    @Basic
    @Column(name = "account_number")
    private int accountNumber;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "transaction_dt")
    private Date transactionDt;
    @Basic
    @Column(name = "transaction_summary")
    private String transactionSummary;
    @Basic
    @Column(name = "transaction_type")
    private String transactionType;
    @Basic
    @Column(name = "transaction_amt")
    private int transactionAmt;
    @Basic
    @Column(name = "closing_balance")
    private int closingBalance;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(Date transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getTransactionSummary() {
        return transactionSummary;
    }

    public void setTransactionSummary(String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(int transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public int getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(int closingBalance) {
        this.closingBalance = closingBalance;
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

        AccountTransactionsEntity that = (AccountTransactionsEntity) o;

        if (accountNumber != that.accountNumber) return false;
        if (customerId != that.customerId) return false;
        if (transactionAmt != that.transactionAmt) return false;
        if (closingBalance != that.closingBalance) return false;
        if (transactionId != null ? !transactionId.equals(that.transactionId) : that.transactionId != null)
            return false;
        if (transactionDt != null ? !transactionDt.equals(that.transactionDt) : that.transactionDt != null)
            return false;
        if (transactionSummary != null ? !transactionSummary.equals(that.transactionSummary) : that.transactionSummary != null)
            return false;
        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
            return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionId != null ? transactionId.hashCode() : 0;
        result = 31 * result + accountNumber;
        result = 31 * result + customerId;
        result = 31 * result + (transactionDt != null ? transactionDt.hashCode() : 0);
        result = 31 * result + (transactionSummary != null ? transactionSummary.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + transactionAmt;
        result = 31 * result + closingBalance;
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
    }
}
