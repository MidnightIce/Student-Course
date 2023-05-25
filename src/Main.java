// Created By Aaliyah Creech
// Created on Novemeber 27, 2022
// CSIS 3701: Programming and Problem-Solving
// YSU 2022

import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.NumberFormat;
import java.util.Locale;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Catalog catalog1 = new Catalog();
        StudentBody studentBody = new StudentBody();
        Student temp = null;
        int choice;
        String uniqueID;

        String studentString = "Luke Hall Y00364422";
        String studentPattern = "(([A-Z][a-z]+)\\s([A-Z][a-z]+)\\s(Y[0-9]{8})\\s?)";
        Pattern r = Pattern.compile(studentPattern);
        Matcher m = r.matcher(studentString);

        try (Scanner input = new Scanner(Paths.get("C:\\Users\\jacob\\IdeaProjects\\Student Course 1\\src\\Students.txt"))) {
            while (input.hasNextLine()) {
                studentString = input.nextLine();
                m = r.matcher(studentString);
                if (m.find()) {
                    System.out.println("Found value: " + m.group(1)); // full name
                    System.out.println("Found value: " + m.group(2)); // first name
                    System.out.println("Found value: " + m.group(3)); // last name
                    System.out.println("Found value: " + m.group(4) + "\n"); // Y number

                    Student s = new Student(m.group(2), m.group(3), m.group(4));
                    studentBody.addStudent(s);
                } else {
                    System.out.println("No matches found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String courseString = "F2022 CSIS 1595 Fundamentals of Programming I 3 3 ";
        String coursePattern = "(([S|X|F])(2[0-9]{3})\\s([A-Z]{3,})\\s?([1-4][0-9]{3})\\s((\\S+\\s?)+)\\s([0-9])\\s([0-9])\\s?)";
        Pattern r2 = Pattern.compile(coursePattern);
        Matcher m2 = r2.matcher(courseString);

        try (Scanner input = new Scanner(Paths.get("C:\\Users\\jacob\\IdeaProjects\\Student Course 1\\src\\Courses.txt"))) {
            while (input.hasNextLine()) {
                courseString = input.nextLine();
                m2 = r2.matcher(courseString);
                if (m2.find()) {
                    System.out.println("Found value: " + m2.group(1)); // full string
                    System.out.println("Found value: " + m2.group(2)); // term
                    System.out.println("Found value: " + m2.group(3)); // year
                    System.out.println("Found value: " + m2.group(4)); // dept
                    System.out.println("Found value: " + m2.group(5)); // course number
                    System.out.println("Found value: " + m2.group(6)); // course name
                    System.out.println("Found value: " + m2.group(8)); // cap
                    System.out.println("Found value: " + m2.group(9) + "\n"); // semester hours

                    String[] courseParams = { m2.group(2), m2.group(3), m2.group(4), m2.group(5), m2.group(6), m2.group(8),
                            m2.group(9) };
                    Course c = new Course(courseParams);
                    catalog1.addCourse(c);
                } else {
                    System.out.println("No matches found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // student 1 has 21 credit hours
        catalog1.getCourse(0).addStudent(studentBody.getStudent(0));
        catalog1.getCourse(1).addStudent(studentBody.getStudent(0));
        catalog1.getCourse(2).addStudent(studentBody.getStudent(0));
        catalog1.getCourse(3).addStudent(studentBody.getStudent(0));
        catalog1.getCourse(4).addStudent(studentBody.getStudent(0));
        catalog1.getCourse(5).addStudent(studentBody.getStudent(0));

        // student 2 has 14 credit hours
        catalog1.getCourse(1).addStudent(studentBody.getStudent(1));
        catalog1.getCourse(2).addStudent(studentBody.getStudent(1));
        catalog1.getCourse(4).addStudent(studentBody.getStudent(1));
        catalog1.getCourse(5).addStudent(studentBody.getStudent(1));

        // student 3 has 8 credit hours
        catalog1.getCourse(2).addStudent(studentBody.getStudent(2));
        catalog1.getCourse(4).addStudent(studentBody.getStudent(2));

        //getting user input
        System.out.println("\nWelcome to the Hypothetical State University, or HSU for short!");
        System.out.println("Auto-Enrollment is in effect.");

        String[] menu = {
                "1 - View Course Catalog" + "\n2 - Add Student to Course" +
                        "\n3 - Drop Student from Course" + "\n4 - View Course Roster" +
                        "\n5 - View Student Body" + "\n6 - View Course Waitlist" +
                        "\n7 - Finalize Schedule " + "\n8 - Make Payment" +
                        "\n9 - Quit"
        };

        System.out.println("Please enter Student ID: ");
        uniqueID = scan.nextLine();
        if(studentBody.isEnrolled(uniqueID)) {
            temp = studentBody.searchStudentBody(uniqueID);
            if(temp != null) {
                do {
                    for (String s : menu) {
                        System.out.println("\n" + s);
                    }
                    System.out.print("Input your choice: ");
                    choice = scan.nextInt();

                    switch (choice) {
                        case 1: //course catalog
                            catalog1.displayCatalog();
                            break;
                        case 2: // add student
                            catalog1.displayCatalog();
                            System.out.print("Add student to which course: ");
                            int a = scan.nextInt();
                            switch (a) {
                                case 1:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(0).numSeatsFree(temp));
                                    catalog1.getCourse(0).addStudent(temp); // csis 1595
                                    break;
                                case 2:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(1).numSeatsFree(temp));
                                    catalog1.getCourse(1).addStudent(temp); // csis 2605
                                    break;
                                case 3:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(2).numSeatsFree(temp));
                                    catalog1.getCourse(2).addStudent(temp); // csis 3701
                                    break;
                                case 4:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(3).numSeatsFree(temp));
                                    catalog1.getCourse(3).addStudent(temp); // math 1572
                                    break;
                                case 5:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(4).numSeatsFree(temp));
                                    catalog1.getCourse(4).addStudent(temp); // geog 2640
                                    break;
                                case 6:
                                    System.out.println("Number of seats open in class: " + catalog1.getCourse(5).numSeatsFree(temp));
                                    catalog1.getCourse(5).addStudent(temp); // thtr 1590
                                    break;
                                default:
                                    System.out.print("Please enter a valid choice: ");
                                    break;
                            }
                            break;
                        case 3: // drop student
                            catalog1.displayCatalog();
                            System.out.print("Remove student from which course: ");
                            int b = scan.nextInt();
                            switch (b) {
                                case 1:
                                    catalog1.getCourse(0).dropStudent(temp); // csis 1595
                                    break;
                                case 2:
                                    catalog1.getCourse(1).dropStudent(temp); // csis 2605
                                    break;
                                case 3:
                                    catalog1.getCourse(2).dropStudent(temp); // csis 3701
                                    break;
                                case 4:
                                    catalog1.getCourse(3).dropStudent(temp); // math 1572
                                    break;
                                case 5:
                                    catalog1.getCourse(4).dropStudent(temp); // geog 2640
                                    break;
                                case 6:
                                    catalog1.getCourse(5).dropStudent(temp); // thtr 1590
                                    break;
                                default:
                                    System.out.print("Please enter a valid choice: ");
                                    break;
                            }
                            break;
                        case 4: // View Course Roster
                            catalog1.displayCatalog();
                            System.out.print("View roster for which course: ");
                            int select3 = scan.nextInt();
                            switch (select3) {
                                case 1:
                                    catalog1.getCourse(0).printRoster(temp); // csis 1595
                                    break;
                                case 2:
                                    catalog1.getCourse(1).printRoster(temp); // csis 2605
                                    break;
                                case 3:
                                    catalog1.getCourse(2).printRoster(temp); // csis 3700
                                    break;
                                case 4:
                                    catalog1.getCourse(3).printRoster(temp); // math 1572
                                    break;
                                case 5:
                                    catalog1.getCourse(4).printRoster(temp); // geog 2640
                                    break;
                                case 6:
                                    catalog1.getCourse(5).printRoster(temp); // thtr 1590
                                    break;
                                default:
                                    System.out.print("Please enter a valid choice: ");
                                    break;
                            }
                            break;
                        case 5: // student body
                            studentBody.displayStudentBody();
                            break;
                        case 6: // View Course Wailist
                            catalog1.displayCatalog();
                            System.out.print("View waitlist for which course: ");
                            int select4 = scan.nextInt();
                            switch (select4) {
                                case 1:
                                    catalog1.getCourse(0).printWaitList(temp); // csis 1595
                                    break;
                                case 2:
                                    catalog1.getCourse(1).printWaitList(temp); // csis 2605
                                    break;
                                case 3:
                                    catalog1.getCourse(2).printWaitList(temp); // csis 3701
                                    break;
                                case 4:
                                    catalog1.getCourse(3).printWaitList(temp); // math 1572
                                    break;
                                case 5:
                                    catalog1.getCourse(4).printWaitList(temp); // geog 2640
                                    break;
                                case 6:
                                    catalog1.getCourse(5).printWaitList(temp); // thtr 1590
                                    break;
                                default:
                                    System.out.print("Please enter a valid choice: ");
                                    break;
                            }
                            break;
                        case 7: // finalize schedule
                            temp.finalizeSchedule();
                            NumberFormat USformat = NumberFormat.getCurrencyInstance(Locale.US);
                            System.out.println("The balance in this students account is: ");

                            BigDecimal sum = temp.getAccount().getList().stream()
                                    .map(x -> x.getAmount())
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
                            System.out.printf("%s\n", USformat.format(sum));
                            break;
                        case 8: // make payment
                            System.out.println("\nThis student is now making a payment...");
                            temp.payment(temp.getAccount().getAmount());
                            System.out.println("Balance in Account now: $" + temp.getAccount().getAmount());
                            break;
                        case 9: // quit
                            System.out.println("Goodbye! :D");
                            break;
                        default:
                            System.out.print("Please enter a valid choice: ");
                            break;
                    }
                } while(choice != 9);
            }
        }
    }
}
