package org.example;

public class LumpsumPayment {
    private final Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public LumpsumPayment(Integer amount, Integer emiId) {
        this.amount = amount;
        this.emiId = emiId;
    }


    public Integer getEmiId() {
        return emiId;
    }


    private final Integer emiId;
}
