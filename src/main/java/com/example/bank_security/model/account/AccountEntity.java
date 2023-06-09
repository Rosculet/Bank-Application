package com.example.bank_security.model.account;

import com.example.bank_security.model.customer.CustomerEntity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "accounts", schema = "bank_security")
public class AccountEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Id
    @Column(name = "account_number")
    private int accountNumber;
    @Basic
    @Column(name = "account_type")
    private String accountType;
    @Basic
    @Column(name = "branch_address")
    private String branchAddress;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;


    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
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

        AccountEntity that = (AccountEntity) o;

        if (customer != that.customer) return false;
        if (accountNumber != that.accountNumber) return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (branchAddress != null ? !branchAddress.equals(that.branchAddress) : that.branchAddress != null)
            return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customer.hashCode();
        result = 31 * result + accountNumber;
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (branchAddress != null ? branchAddress.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
    }
}

