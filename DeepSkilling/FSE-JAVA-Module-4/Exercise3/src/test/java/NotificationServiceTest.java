import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {
    @Test
    void testVoidMethod(){
        EmailService mockEmail = Mockito.mock(EmailService.class);
////        doNothing()
////                .when(mockEmail).sendEmail("abc@gmail.com");
//        NotificationService notificationService = new NotificationService(mockEmail);
//        notificationService.notifyUser("abc@gmail.com");
//        verify(mockEmail).sendEmail("abc@gmail.com");

        doThrow(new RuntimeException("Email Failed"))
                .when(mockEmail)
                .sendEmail("abc@gmail.com");
        NotificationService notificationService = new NotificationService(mockEmail);
        assertThrows(RuntimeException.class,()->{
            notificationService.notifyUser("abc@gmail.com");
        });
    }
}
