package MVC;

public class StudentView {
    public void displayStudentDetails(Student student){
        System.out.println("id :"+student.getId());
        System.out.println("Name :"+student.getName());
        System.out.println("Grade :"+student.getGrade());
    }

}
