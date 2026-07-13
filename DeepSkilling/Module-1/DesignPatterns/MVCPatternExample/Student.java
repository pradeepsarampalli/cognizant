public class Student {
    private int id;
    private String name;
    private String grade;

    public Student(){}
    public Student(int id,String name,String grade){
        this.grade=grade;
        this.id=id;
        this.name=name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}