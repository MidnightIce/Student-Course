// Created By Aaliyah Creech
// Created on Novemeber 27, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.util.ArrayList;

public class StudentBody {

    private ArrayList<Student> studentBody =  new ArrayList<>();

    public StudentBody(){
    }

    public void addStudent(Student s) {
        if(!studentBody.contains(s)) {
            studentBody.add(s);
        } else {
            System.out.println("This student is already enrolled.\n");
            this.addStudent(s);
        }
        return;
    }

    public void dropStudent(Student s) {
        if(studentBody.contains(s)) {
            studentBody.remove(s);
        } else {
            System.out.println("This student is not enrolled.\n");
            this.dropStudent(s);
        }
    }

    public boolean isEnrolled(String uniqueID) {
        boolean found = false;
        for(Student s: this.studentBody) {
            if(uniqueID.equals(s.getUniqueID())) {
                System.out.print("This student is enrolled.");
                System.out.println("\nStudent: " + s.getName());
                return true;
            }
        }
        if (!found) {
            System.out.println("This student is not enrolled.\n");
        }
        return false;
    }

    public Student searchStudentBody(String uniqueID) {
        boolean found = false;
        for(Student s: this.studentBody) {
            if(uniqueID.equals(s.getUniqueID())) {
                return s;
            }
        }
        if (!found) {
            System.out.println("This student is not enrolled.\n");
        }
        return null;
    }

    public Student getStudent(int index){
        return studentBody.get(index);
    }

    public void displayStudentBody(){
        System.out.println("\nStudent Body: ");
        int i = 1;
        for(Student item: this.studentBody) {
            System.out.println(i + ". " + item.getUniqueID() + " - " + item.getName());
            i++;
        }
    }

}
