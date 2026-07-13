public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.setId(1);
        controller.setName("Pradeep");
        controller.setGrade("s");
        controller.updateView();
    }
}