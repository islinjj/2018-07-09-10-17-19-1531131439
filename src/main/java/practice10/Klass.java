package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> studentList;

    public Klass(int number) {
        this.number = number;
        this.studentList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student student){
        for (Student stu : studentList) {
            if (stu.id == student.id){
                this.leader = student;
                return;
            }
        }
        System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student student){
        studentList.add(student);
    }

    public boolean isIn(Student student){
        for (Student stu : studentList) {
            return stu.getKlass().getNumber() == student.getKlass().getNumber();
        }
        return false;
    }
}
