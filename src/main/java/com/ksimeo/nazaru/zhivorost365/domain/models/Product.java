package com.ksimeo.nazaru.zhivorost365.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="products")
public class Product implements Serializable {
    private static final long serialVersionUID = 8980570398287165423L;
    private int id;
    private int version;
    private String name;
    private BigDecimal price;
    private CurrencyType currency;
    private MeasureUnit measure;
    private Date regDate;
    private Date lastEditDate;
    private boolean isActual;

    public Product() {
        //NOP
    }

    public Product(String name, BigDecimal price, CurrencyType currency, MeasureUnit measure, Date regDate, Date lastEditDate) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.measure = measure;
        this.regDate = regDate;
        this.lastEditDate = lastEditDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    @Column
    public MeasureUnit getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureUnit measure) {
        this.measure = measure;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Column(name = "date_of_last_edit")
    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "relevance")
    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        this.isActual = actual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (currency != product.currency) return false;
        if (measure != product.measure) return false;
        if (regDate != null ? !regDate.equals(product.regDate) : product.regDate != null) return false;
        return !(lastEditDate != null ? !lastEditDate.equals(product.lastEditDate) : product.lastEditDate != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (lastEditDate != null ? lastEditDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", currency=" + currency +
                ", measure=" + measure +
                ", regDate=" + regDate +
                ", lastEditDate=" + lastEditDate +
                ", isActual=" + isActual +
                '}';
    }
}