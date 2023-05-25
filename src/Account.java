// Created By Aaliyah Creech
// Created on Novemeber 27, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.math.BigDecimal;
import java.util.*;

class Account {
    private List<Transaction> transactions = new ArrayList<>();
    private BigDecimal balance = new BigDecimal(0);

    public void addTransaction(Transaction trans) {
        transactions.add(0, trans);
        balance = balance.add(trans.getAmount());
    }

    public void paymentTransaction(String a, BigDecimal b, String payment) {
        balance = balance.subtract(b);
    }

    public BigDecimal getAmount() {
        return balance;
    }

    public void setAmount(BigDecimal amount) {
        balance = amount;
        return;
    }

    public List<Transaction> getList() {
        return this.transactions;
    }

}
