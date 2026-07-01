public class UserManager {
    private UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }
    public void service(){
        userService.login();
        userService.logout();
    }
}
