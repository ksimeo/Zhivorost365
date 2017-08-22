package com.ksimeo.nazaru.zhivorost365.domain.dto;

public class OrderDTO {
    private int amount;
    private int type;

    public OrderDTO() {
        //NOP
    }

    public OrderDTO(int amount, int type) {
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "amount=" + amount +
                ", type=" + type +
                '}';
    }
}
