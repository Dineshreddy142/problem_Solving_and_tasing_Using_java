import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private final int id;
    private final String fname;
    private final double cgpa;

    Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Task4JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (!in.hasNextInt()) {
            return;
        }

        int testCases = Integer.parseInt(in.nextLine().trim());
        List<Student> studentList = new ArrayList<>();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(Comparator
                .comparing(Student::getCgpa, Comparator.reverseOrder())
                .thenComparing(Student::getFname)
                .thenComparing(Student::getId));

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
