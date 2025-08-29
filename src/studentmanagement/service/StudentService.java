package studentmanagement.service;

import studentmanagement.exception.StudentNotFoundException;
import studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> initialStudent){
        this.students = initialStudent;
    }





    public Student findStudentById(int id){
        for(Student s: students){
            if(s.getId() == id){
                return s;
            }

        }
        throw new StudentNotFoundException("Student with ID: " +id+" not found");
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public void updateStudent(int id, Student s){

        Student idFound = findStudentById(id);
        idFound.setName(s.getName());
        idFound.setMarks(s.getMarks());

    }

    public void deleteStudent(int id){

        Student objForDelete = findStudentById(id);
        students.remove(objForDelete);
    }

    public Student studentGetById(int id){

        return findStudentById(id);

    }

    public List<Student> getAllStudent(){
        return students;
    }

    public List<Student> getSortByName(){
        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparing(Student::getName));
        return sortedList;
    }

    public List<Student> getSortedByMarks(){
        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(Comparator.comparing(Student::getMarks));
        return sortedList;
    }
}
