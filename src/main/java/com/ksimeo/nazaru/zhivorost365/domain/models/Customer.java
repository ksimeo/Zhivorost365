package com.ksimeo.nazaru.zhivorost365.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = 661421636862411964L;
    private String phoneNumber;
    private int version;
    private String name;
    private String surname;
    private String email;
    private Date regDate;
    private Date lastOrderDate;
    private List<Order> orders;

    public Customer() {
        //NOP
    }

    public Customer(String phoneNumber, String name, String surname, String email, Date regDate, Date lastOrderDate) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.regDate = regDate;
        this.lastOrderDate = lastOrderDate;
    }

    @Id
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (phoneNumber != null ? !phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber != null)
            return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (regDate != null ? !regDate.equals(customer.regDate) : customer.regDate != null) return false;
        return !(lastOrderDate != null ? !lastOrderDate.equals(customer.lastOrderDate) : customer.lastOrderDate != null);

    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (lastOrderDate != null ? lastOrderDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }
}