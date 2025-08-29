package studentmanagement.util;

import studentmanagement.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static final String File_Name = "Student.txt";

    public static void SaveToFile(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(File_Name))) {
            for (Student s : students) {

                writer.println(s.getId() + " , " + s.getName() + " , " + s.getMarks());

            }

        } catch (IOException e) {
            System.out.println("Error saving the file:" + e.getMessage());
        }
    }

    public static List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(File_Name))) {

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double marks = Double.parseDouble(parts[2].trim());

                    students.add(new Student(id, name, marks));

                }

            }

        } catch (IOException e) {
            System.out.println("Error saving the file:" + e.getMessage());
        }

        return students;

    }


}
