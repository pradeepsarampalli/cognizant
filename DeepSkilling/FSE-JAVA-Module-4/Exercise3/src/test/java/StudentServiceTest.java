import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;


public class StudentServiceTest {
    @Test
    void testArgumentMatching(){
        StudentRepository mockRepo = Mockito.mock(StudentRepository.class);
        StudentService studentService = new StudentService(mockRepo);
        studentService.registerStudent(101);
        verify(mockRepo).saveStudent(101);
    }
}
