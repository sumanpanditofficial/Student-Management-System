package studentmanagement;

import studentmanagement.model.Student;
import studentmanagement.service.StudentService;
import studentmanagement.thread.AutoSaveThread;
import studentmanagement.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = FileUtil.loadFromFile();
        StudentService studentService = new StudentService(students);
        AutoSaveThread auto = new AutoSaveThread(students);
        auto.start();
        Scanner sc = new Scanner(System.in);
        int id;
        int marks;
        String name;
        boolean running = true;
        while (running) {
            int chooseMenu = -1;
            System.out.print("\nChoose What you wanna do:\n" + "1.Add\n" + "2.Update\n" + "3.Delete\n" + "4.Search by ID\n" + "5.List All\n" + "6.Sort by name\n" + "7.Sort by marks\n" + "8.Exit \n");

            chooseMenu = sc.nextInt();

            switch (chooseMenu) {
                case 1:
                    System.out.print("Enter the id of the Student: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the name of the Student: ");
                    name = sc.nextLine();
                    System.out.print("Enter the marks of the Student: ");
                    marks = sc.nextInt();
                    Student s = new Student(id, name, marks);
                    studentService.addStudent(s);
                    System.out.print("Students Added!!!");
                    break;

                case 2:
                    System.out.print("Enter the id of the Student you wanna update: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the name of the Student: ");
                    name = sc.nextLine();
                    System.out.print("Enter the marks of the Student: ");
                    marks = sc.nextInt();
                    Student updateStudent = new Student(id, name, marks);
                    studentService.updateStudent(id, updateStudent);
                    System.out.print("Students Updated!!!");
                    break;

                case 3:
                    System.out.print("Enter the id of the Student you want to delete: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    studentService.deleteStudent(id);
                    System.out.println("Student successfully deleted");
                    break;

                case 4:
                    System.out.print("Enter the id of the Student you want to see: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Student toShow = studentService.studentGetById(id);
                    System.out.println("Id: " + toShow.getId() + "Name: " + toShow.getName() + "Marks: " + toShow.getMarks());
                    break;

                case 5:
                    List<Student> allStudents = studentService.getAllStudent();
                    for (Student showAll : allStudents) {
                        System.out.println(showAll);

                    }
                    break;

                case 6:
                    List<Student> sortingStudentsByName = studentService.getSortByName();
                    for (Student sortedAllByName : sortingStudentsByName) {
                        System.out.println(sortedAllByName);
                        break;
                    }
                    break;

                case 7:
                    List<Student> sortingStudentsByMarks = studentService.getSortedByMarks();
                    for (Student sortedStudentsByMarks : sortingStudentsByMarks) {
                        System.out.println(sortedStudentsByMarks);

                    }
                    break;

                case 8:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;


            }

        }


    }


}
