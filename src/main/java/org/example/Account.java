package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final Integer accountId;

    public Account(Integer accountId) {
        this.accountId = accountId;
        this.paymentList = new ArrayList<>();
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Loan getLoan() {
        return loan;
    }

    public List<LumpsumPayment> getPaymentList() {
        return paymentList;
    }

    private Loan loan;
    private final List<LumpsumPayment> paymentList;

    public void printBalance(Integer emiId){
        Integer lumpsumPaymentsTillemi = paymentList.stream().filter(payment -> payment.getEmiId() <= emiId).mapToInt(payment -> payment.getAmount()).sum();
        Integer emiAmountPaid = loan.getEmiAmount()*emiId;
        Integer balanceAmount = (int)Math.ceil(loan.getTotalLoanedAmount())-(lumpsumPaymentsTillemi+emiAmountPaid);
        Integer remainingEmis = balanceAmount/ loan.emiAmount;
        System.out.println((lumpsumPaymentsTillemi+emiAmountPaid) + " " + remainingEmis);
    }
}
