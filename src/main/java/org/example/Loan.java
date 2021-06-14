package org.example;

import java.util.Date;

public class Loan {
    public double getInterestRate() {
        return interestRate;
    }

    public Integer getTerm() {
        return term;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Loan(double interestRate, Integer term, Integer loanAmount, Date loanDate) {
        this.interestRate = interestRate;
        this.term = term;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        emiAmount = (int)Math.ceil(getLoanAmount()/this.getTerm());
        numOfEmi = this.term;
    }

    private final double interestRate;
    private final Integer term;
    private final Integer loanAmount;
    private final Date loanDate;

    public Integer getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(Integer emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Integer getNumOfEmi() {
        return numOfEmi;
    }

    public void setNumOfEmi(Integer numOfEmi) {
        this.numOfEmi = numOfEmi;
    }

    Integer emiAmount;
    Integer numOfEmi;

    public double getTotalLoanedAmount(){
        return this.loanAmount + (this.loanAmount*this.interestRate+this.term);
    }
}
