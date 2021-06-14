package org.example;

import java.util.HashMap;
import java.util.Map;

public class TheLedgerServices {
    private final Map<String, Bank> bankMap;

    public TheLedgerServices() {
        bankMap = new HashMap<>();
    }

    private Bank createBank(String bankName){
        Bank bank = new Bank(bankName);
        bankMap.put(bankName, bank);
        return bank;
    }

    public void processCommand(String command){
        String[] strArr = command.split("\\s+");
        switch(strArr[0]){
            case "LOAN":
                Bank bank = bankMap.getOrDefault(strArr[1], createBank(strArr[1]));
                bank.giveLoan(strArr[2],Integer.parseInt(strArr[3]), Double.parseDouble(strArr[4]), Integer.parseInt(strArr[5]));
                break;
            case "PAYMENT":
                Bank bankPayment = bankMap.get(strArr[1]);
                bankPayment.makeLumpsumPayments(strArr[2],Integer.parseInt(strArr[3]), Integer.parseInt(strArr[4]));
                break;
            case "BALANCE":
                Bank bankbalance = bankMap.get(strArr[1]);
                bankbalance.getBalances(strArr[2],Integer.parseInt(strArr[3]));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strArr[0]);
        }
    }
}
