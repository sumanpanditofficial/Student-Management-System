package studentmanagement.thread;

import studentmanagement.model.Student;
import studentmanagement.util.FileUtil;

import java.util.List;

public class AutoSaveThread extends Thread{
    private List<Student> students;

    public AutoSaveThread(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        while (true){
            FileUtil.SaveToFile(students);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
