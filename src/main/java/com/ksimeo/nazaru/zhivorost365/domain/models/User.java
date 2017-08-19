package com.ksimeo.nazaru.zhivorost365.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = -8687063809629519459L;
    private String login;
    private UserRole role;
    private String name;
    private String surname;
    private Date regDate;
    private String password;

    public User() {
        //NOP
    }

    public User(String login, UserRole role, String name, String surname, Date regDate, String password) {
        this.login = login;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.regDate = regDate;
        this.password = password;
    }

    @Id
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (role != user.role) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (regDate != null ? !regDate.equals(user.regDate) : user.regDate != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", regDate=" + regDate +
                ", password='" + password + '\'' +
                '}';
    }
}