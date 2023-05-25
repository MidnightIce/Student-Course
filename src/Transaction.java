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
