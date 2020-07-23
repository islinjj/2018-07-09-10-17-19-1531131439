package practice11;

import java.util.LinkedList;

public class Teacher extends Person implements TeacherClassObserve {

    private Klass klass;
    private LinkedList<Klass> classes;

    public Teacher(int id,String name, int age, Klass klass) {
        super(id,name, age);
        this.klass = klass;
    }

    public Teacher(int id,String name, int age) {
        super(id,name, age);
        this.classes = new LinkedList<>();
    }

    public Teacher(int id,String name, int age,LinkedList<Klass> classes) {
        super(id,name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.updateTeacher(this);
        }
    }

    public Klass getKlass() {
        return klass;
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce(){
        if (this.classes.size() == 0){
            return super.introduce() + " I am a Teacher. " + "I teach No Class.";
        }
        return super.introduce() + " I am a Teacher. " + "I teach Class " + formatClassesOutput(this.classes) + ".";
    }

    public String introduceWith(Student student){
        if (isTeaching(student)){
            return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        }
        return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + ".";
    }

    public boolean isTeaching(Student student){
        for (Klass klass : classes) {
            return klass.isIn(student);
        }
        return false;
    }

    private String formatClassesOutput(LinkedList<Klass> classes) {
        String classesNumber = "";
        for(Klass klass: classes){
            classesNumber += klass.getNumber() + ", ";
        }
        return classesNumber.substring(0, classesNumber.length() - 2);
    }

    @Override
    public void updateStudent(Student student,Klass klass) {
        System.out.printf(
                "I am %s. I know %s has joined Class %d.\n",
                getName(),
                student.getName(),
               klass.getNumber());
    }

    @Override
    public void updateLeader(Student leader,Klass klass) {
        System.out.printf(
                "I am %s. I know %s become Leader of Class %d.\n",
                getName(),
                leader.getName(),
                klass.getNumber());
    }
}
