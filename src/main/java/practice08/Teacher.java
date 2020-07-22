package practice08;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(int id,String name, int age, Klass klass) {
        super(id,name, age);
        this.klass = klass;
    }

    public Teacher(int id,String name, int age) {
        super(id,name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        if (this.klass == null){
            return super.introduce() + " I am a Teacher. " + "I teach No Class.";
        }
        return super.introduce() + " I am a Teacher. " + "I teach Class " + this.klass.getNumber() + ".";
    }

    public String introduceWith(Student student){
        if (student.getKlass() == this.klass){
            return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        }
        return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + ".";
    }
}
