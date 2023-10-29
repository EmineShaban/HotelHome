import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserSystem {
    private List<User> users;
    public UserSystem(List<User> users) throws IOException {
        this.users = users;
    }
    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return null;
    }

}
