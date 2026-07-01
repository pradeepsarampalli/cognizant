package MVC;

public class Main {
    public static void main(String[] args){
        StudentController studentController = new StudentController(new Student("Umesh",1,5),new StudentView());
        studentController.setStudentName("Upender");
        studentController.updateView();
    }
}
