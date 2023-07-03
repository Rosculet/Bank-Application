package com.example.bank_security.model.authorities;

import com.example.bank_security.model.customer.CustomerEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "authorities", schema = "bank_security")
public class AuthoritiesEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customerId) {
        this.customer = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthoritiesEntity that = (AuthoritiesEntity) o;

        if (id != that.id) return false;
        if (customer != that.customer) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customer.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
