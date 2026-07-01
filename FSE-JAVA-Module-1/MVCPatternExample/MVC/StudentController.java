package MVC;

public class StudentController {
    private Student student;
    private StudentView studentView;
    StudentController(Student student,StudentView studentView){
        this.student = student;
        this.studentView = studentView;
    }
    public void setStudentName(String name){
        student.setName(name);
    }


    public void setStudentGrade(int grade){
    student.setGrade(grade);
    }

    public void updateView(){
        studentView.displayStudentDetails(student);
    }
}
