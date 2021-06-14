package org.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    public String getName() {
        return Name;
    }

    public Map<User, Account> getUserAccountMap() {
        return userAccountMap;
    }

    public Bank(String name) {
        Name = name;
        userAccountMap = new HashMap<>();
        accountHolderMap = new HashMap<>();
    }

    private final String Name;
    private final Map<String, User> accountHolderMap;
    private final Map<User, Account> userAccountMap;
    private Integer accountId = 1;

    private Account getUserAccount(String userName){
        return userAccountMap.get(accountHolderMap.get(userName));
    }

    private User createUser(String userName){
        User user = new User(userName);
        Account account = new Account(accountId);
        ++accountId;
        accountHolderMap.put(userName, user);
        userAccountMap.put(user, account);
        return user;
    }

    public void giveLoan(String userName, Integer loanAmount, double rate, Integer term){
        Account userAccount = getUserAccount(userName);
        if(userAccount == null){
            createUser(userName);
        }
        Loan loan = new Loan(rate, loanAmount,term, new Date());
        userAccount.setLoan(loan);
    }

    public void getBalances(String userName, Integer emiNumber){
        Account userAccount = getUserAccount(userName);
        userAccount.printBalance(emiNumber);

    }

    public void makeLumpsumPayments(String userName, Integer emiNumber, Integer paymentAmount){
        Account userAccount = getUserAccount(userName);
        LumpsumPayment lumpsumPayment = new LumpsumPayment(paymentAmount, emiNumber);
        userAccount.getPaymentList().add(lumpsumPayment);
    }
}
