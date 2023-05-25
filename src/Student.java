import java.math.BigDecimal;

public class Student {

    private String firstName;
    private String lastName;
    private String uniqueID;
    private Account account = new Account();
    private int semesterHours = 0;

    public Student(String fname, String lname, String ynum) {
        this.firstName = fname;
        this.lastName = lname;
        this.uniqueID = ynum;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
        return;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
        return;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public void finalizeSchedule() {
        BigDecimal bigD1 = BigDecimal.valueOf(semesterHours * 270);
        BigDecimal bigD2 = BigDecimal.valueOf(3240);

        if (semesterHours <= 11) {
            Transaction tran1 = new Transaction("DR", bigD1, "tuition");
            this.account.addTransaction(tran1);
            System.out.print("Schedule has been finalized!\n");
        } else if (semesterHours >= 12 && semesterHours <= 18) {
            Transaction tran2 = new Transaction("DR", bigD2, "tuition");
            this.account.addTransaction(tran2);
            System.out.print("Schedule has been finalized!\n");
        } else if (semesterHours > 18) {
            Transaction tran3 = new Transaction("DR", bigD1, "tuition");
            this.account.addTransaction(tran3);
            System.out.print("Schedule has been finalized!\n");
        }
    }

    public void payment(BigDecimal amount) {
        account.paymentTransaction("CR", amount, "payment");
    }

    public int getSemesterHours() {
        return semesterHours;
    }

    public void setSemesterHours(int sh) {
        this.semesterHours += sh;
        return;
    }

    public Account getAccount() {
        return this.account;
    }
}