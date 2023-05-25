import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    Scanner input = new Scanner(System.in);

    private String term;
    private String year;
    private String dept;
    private String number;
    private String name;
    private int enrolled;
    private int cap;
    private int semesterHours;
    private ArrayList<Student> roster =  new ArrayList<>();
    private ArrayList<Student> waitList =  new ArrayList<>();

    public Course(String[] args) {
        term = args[0];
        year = args[1];
        dept = args[2];
        number = args[3];
        name = args[4];
        try {
            cap = Integer.parseInt(args[5]);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        try {
            semesterHours = Integer.parseInt(args[6]);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        enrolled = 0;
    }

    public String getCourseString(){
        return this.getTermAndYear() + " " +
                this.getDeptAndNumber() + " " +
                this.getCourseName();
    }

    public String getTermAndYear(){
        return this.term + this.year;
    }

    public String getDeptAndNumber(){
        return this.dept + " " + this.number;
    }

    public String getCourseName(){
        return this.name;
    }

    public int getCap(){
        return this.cap;
    }

    public boolean addStudent(Student s){
        if(enrolled < cap && !this.isRegistered(s)){
            roster.add(s);
            enrolled++;
            s.setSemesterHours(semesterHours);
            return true;
        } else if(enrolled >= cap){
            System.out.println("Cannot enroll student: enrollment exceeds cap.\n");
            this.joinWaitlist(s);
        } else {
            System.out.println("Cannot enroll student: student already enrolled.\n");
        }
        return false;
    }

    public boolean dropStudent(Student s){
        if(roster.contains(s)){
            roster.remove(s);
            enrolled--;
            if(waitList.size() > 0){
                this.addStudent(waitList.get(0));
                waitList.remove(0);
            }
            return true;
        } else {
            System.out.println("Cannot drop student: ID " + s.getUniqueID() + " is not present in roster.");
        }
        return false;
    }

    public int numSeatsFree() {
        int openSeats = cap - enrolled;
        return openSeats;
    }

    public boolean isRegistered(Student s) {
        if(roster.contains(s)){
            return true;
        }
        return false;
    }

    public void joinWaitlist(Student s){
        if(!this.isRegistered(s)){
            System.out.print("\nWould you like the join the wait list for this class? Y/N: ");
            String choice = input.nextLine();

            if(choice.equals("Y")){
                waitList.add(s);
                System.out.println("You are now on the waitlist.\n");
            } else {
                System.out.println("You are not registered or on the waitlist for this course.\n");
            }
        } else {
            System.out.println("You're already registered for this course.\n");
        }

    }

    public void printRoster(Student t) {
        int i = 1;
        for(Student s: this.roster) {
            System.out.println(i + ". " + s.getUniqueID() + " - " + s.getName());
            i++;
        } if(numSeatsFree(t) == cap) {
            System.out.println("The roster for this course is empty.");
        }
    }

    public void printWaitList(Student t) {
        int i = 1;
        if(numSeatsFree(t) == cap) {
            System.out.println("The waitlist for this course is empty.");
        }
        for(Student s: this.waitList) {
            System.out.println(i + ". " + s.getUniqueID() + " - " + s.getName());
        }
    }

    public int numSeatsFree(Student s) {
        int openSeats = cap - enrolled;
        if(openSeats == 0) {
            System.out.println("There are no open seats in this course. :(");
        }
        return openSeats;
    }

}
