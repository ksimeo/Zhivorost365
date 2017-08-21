package com.ksimeo.nazaru.zhivorost365.domain.dto;

public class PhoneDTO {

    private String domain;
    private String number;

    public PhoneDTO() {
        //NOP
    }

    public PhoneDTO(String domain, String number) {
        this.domain = domain;
        this.number = number;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return "+380" + domain + number;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "domain='" + domain + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
