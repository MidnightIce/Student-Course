import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    Scanner input = new Scanner(System.in);
    private ArrayList<Course> courseCatalog =  new ArrayList<>();

    public Catalog(){

    }

    public void addCourse(Course c) {
        if(!courseCatalog.contains(c)) {
            courseCatalog.add(c);
            System.out.println("Course has been added to Catalog.");
        } else {
            System.out.println("This course is already in the Catalog.\n");
            this.addCourse(c);
        }
        return;
    }

    public void removeCourse(Course c) {
        if(courseCatalog.contains(c)) {
            courseCatalog.remove(c);
            System.out.println("Course has been removed from Catalog.\n");
        } else {
            System.out.println("This course is not in the Catalog.\n");
            this.removeCourse(c);
        }
        return;
    }

    public void displayCatalog(){
        System.out.println("\nCourse Catalog: ");
        int i = 1;
        for(Course item: this.courseCatalog) {
            System.out.println(i + ". " + item.getDeptAndNumber() + " - " + item.getCourseName());
            i++;
        }
        return;
    }

    public Course getCourse(int index){
        return courseCatalog.get(index);
    }
}
