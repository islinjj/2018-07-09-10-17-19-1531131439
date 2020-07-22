package practice11;

public class Student extends Person{
    private Klass klass;

    public Student(int id,String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        this.klass.appendMember(this);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        if (klass.getLeader() == this){
            return super.introduce() + " I am a Student. " + "I am Leader of Class " + this.klass.getNumber() + ".";
        } else {
            return super.introduce() + " I am a Student. " + "I am at Class " + this.klass.getNumber() + ".";
        }
    }
}
