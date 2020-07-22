package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> studentList;
    private List<Teacher> teacherList;

    public Klass(int number) {
        this.number = number;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
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
                for(Teacher teacher: teacherList) {
                    teacher.updateLeader(leader,this);
                }
                return;
            }
        }
        System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student student){
        studentList.add(student);
        for (Teacher teacher : teacherList) {
            teacher.updateStudent(student,this);
        }
    }

    public boolean isIn(Student student){
        for (Student stu : studentList) {
            return stu.getKlass().getNumber() == student.getKlass().getNumber();
        }
        return false;
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }
}
