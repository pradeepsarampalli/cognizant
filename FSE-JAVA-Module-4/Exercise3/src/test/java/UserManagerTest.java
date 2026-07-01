import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class UserManagerTest {
    @Test
    void testInteractionOrder(){
        UserService mockUser = Mockito.mock(UserService.class);
        UserManager userManager = new UserManager(mockUser);
        userManager.service();
        InOrder inOrder = Mockito.inOrder(mockUser);
        inOrder.verify(mockUser).login();
        inOrder.verify(mockUser).logout();
    }
}
