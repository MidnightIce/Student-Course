// Created By Aaliyah Creech
// Created on Novemeber 27, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.math.BigDecimal;

class Transaction {
    private String type; // debit(DR) or credit(CR)
    private BigDecimal amount;
    private String label; // payment or tuition

    public Transaction(String a, BigDecimal b, String c) {
        this.type = a;
        this.amount = b;
        this.label = c;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

}
