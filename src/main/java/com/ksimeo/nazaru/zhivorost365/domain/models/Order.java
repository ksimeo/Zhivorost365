package com.ksimeo.nazaru.zhivorost365.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1423213359968345418L;
    private Long id;
    private int version;
    private Date regDate;
    private Customer customer;
    private Product product;
    private int amount;
    private Date viewDate;


    public Order() {
        //NOP
    }

    public Order(Date regDate, Customer customer, Product product, int amount) {
        this.regDate = regDate;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @ManyToOne
    @JoinColumn(name="customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "view_date")
    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (amount != order.amount) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (regDate != null ? !regDate.equals(order.regDate) : order.regDate != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        return !(product != null ? !product.equals(order.product) : order.product != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", regDate=" + regDate +
                ", customer=" + customer +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }
}