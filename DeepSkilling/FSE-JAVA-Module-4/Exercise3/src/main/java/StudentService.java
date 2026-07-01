public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void registerStudent(int id){
        studentRepository.saveStudent(id);
    }
}
