package com.ksimeo.nazaru.zhivorost365.domain.models;

public enum CurrencyType {
    UAH("UAH", '₴'), USD("USD", '$'), EUR("EUR", '€'), GBP("GBP", '£'), CHF("CHF", '₣'), JPY("JPY",'¥'),
    RUR("RUR", '\u20BD');

    String name;
    char c;

    CurrencyType(String name, char c) {
        this.name = name;
        this.c = c;
    }

    public char getC() {
        return c;
    }
}
