package com.example.bank_security.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cards", schema = "bank_security", catalog = "")
public class CardsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_id")
    private int cardId;
    @Basic
    @Column(name = "card_number")
    private String cardNumber;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "card_type")
    private String cardType;
    @Basic
    @Column(name = "total_limit")
    private int totalLimit;
    @Basic
    @Column(name = "amount_used")
    private int amountUsed;
    @Basic
    @Column(name = "available_amount")
    private int availableAmount;
    @Basic
    @Column(name = "create_dt")
    private Date createDt;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(int totalLimit) {
        this.totalLimit = totalLimit;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
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

        CardsEntity that = (CardsEntity) o;

        if (cardId != that.cardId) return false;
        if (customerId != that.customerId) return false;
        if (totalLimit != that.totalLimit) return false;
        if (amountUsed != that.amountUsed) return false;
        if (availableAmount != that.availableAmount) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + totalLimit;
        result = 31 * result + amountUsed;
        result = 31 * result + availableAmount;
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
    }
}
