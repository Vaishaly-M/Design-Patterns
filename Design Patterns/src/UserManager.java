public class UserManager {
    private static UserManager instance;
    private String username;
    private String password;
    private UserManager() {
        username = "admin";
        password = "admin@123";
    }
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }
}

class UserMain {
    public static void main(String[] args) {
        UserManager userManager1 = UserManager.getInstance();
        UserManager userManager2 = UserManager.getInstance();

        System.out.println(userManager1 == userManager2);

        String username = "admin";
        String password = "admin@123";
        boolean isAuthenticated = userManager1.authenticate(username, password);
        System.out.println("Is authenticated: " + isAuthenticated);

        String newPassword = "newPassword";
        userManager2.resetPassword(newPassword);

        isAuthenticated = userManager1.authenticate(username, newPassword);
        System.out.println("Is authenticated with new password: " + isAuthenticated);
    }
}
