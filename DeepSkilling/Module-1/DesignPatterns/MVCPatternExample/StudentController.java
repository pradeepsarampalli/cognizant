public class StudentController {
    Student s;
    StudentView view;

    public StudentController(Student s,StudentView view) {
        this.s = s;
        this.view = view;
    }

    public void setGrade(String grade) {
        s.setGrade(grade);
    }

    public void setId(int id) {
        s.setId(id);
    }

    public void setName(String name) {
        s.setName(name);
    }

    public String getGrade() {
        return s.getGrade();
    }

    public int getId() {
        return s.getId();
    }

    public String getName() {
        return s.getName();
    }

    public void updateView(){
        view.displayStudentDetails(s);
    }
}