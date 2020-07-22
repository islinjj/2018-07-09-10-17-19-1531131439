package practice07;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(String name, int age,Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
        this.klass = new Klass(-1);
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        if (this.klass.getNumber() == -1){
            return super.introduce() + " I am a Teacher. " + "I teach No Class.";
        }
        return super.introduce() + " I am a Teacher. " + "I teach Class " + this.klass.getNumber() + ".";
    }

    public String introduceWith(Student student){
        if (student.getKlass().equals(this.klass)){
            return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        }
        return "My name is " + super.getName() + ". I am " + super.getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + ".";
    }
}
