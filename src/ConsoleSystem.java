import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ConsoleSystem {
    private final Scanner scanner = new Scanner(System.in);
    private Hotel rooms;
    private List<User> users;
    private String userFilePath = "src/users.txt";  // Update with the correct path if necessary

    public ConsoleSystem(Hotel rooms, List<User> users) throws IOException {
        this.rooms = rooms;
        this.users = users;
    }

    public void start() throws IOException {
        System.out.println("Welcome to our Hotel Emine");
        User loggedInUser = loginOrRegister();
        if (loggedInUser != null) {
            while (true) {
                menu();
                saveTxt();
            }
        } else {
            System.out.println("Thank you!");
        }
    }

    public User loginOrRegister() throws IOException {
        while (true) {
            System.out.println("Please, choose 1 or 2 or 3");
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    User user = login();
                    if (user != null) {
                        return user;
                    }
                    break;
                case 2:
                    User user1 = register();
                    if (user1 != null) {
                        return user1;
                    }
                    break;
                case 3:
                    return null;
                default:
                    System.out.println("Something going wrong! Choose 1 or 2!");
                    return null;
            }
        }
    }

    private void menu() {
        while (true) {
            System.out.println("Please, choose 1, 2 or 3, 4");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewFreeRooms();
                    return;
                case 2:
                    bookRoom();
                    return;
                case 3:
                    cancelBooking();
                    return;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Something going wrong! Choose 1, 2 or 3, 4!");

            }
        }
    }


    private void saveTxt() {
        String fileName = "/Users/macbook/IdeaProjects/HotelHome/src/info.txt";
        String content = "";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Room room : rooms.getRooms()) {
                content += room.roomNumber + " " + room.roomType + " " + room.status + "," + "\n";
            }
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    private void viewFreeRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms.getRooms()) {
            if ("available".equalsIgnoreCase(room.getStatus())) {
                System.out.println(room.roomNumber);
            }
        }
    }

    private void bookRoom() {
        System.out.println("Enter the room number you want to book:");
        int roomNumber = scanner.nextInt();
        Room room = rooms.getRoom(roomNumber);
        if (room != null && "available".equalsIgnoreCase(room.getStatus())) {
            room.setStatus("Booked");
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Room is either not available or doesn't exist.");
        }
    }


    private void cancelBooking() {
        System.out.println("Please write the number of room which you want to cancel:");
        int roomNumber = scanner.nextInt();
        Room room = rooms.getRoom(roomNumber);
        if (room != null && "booked".equalsIgnoreCase(room.getStatus())) {
            room.setStatus("Available");
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Room is either not booked or doesn't exist.");
        }
    }

    private User login() {
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


    public User register() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired username: ");
        String email = scanner.nextLine();
        System.out.println("Enter desired password: ");
        String password = scanner.nextLine();
        User newUser = new User(email, password);
        users.add(newUser);
        try (FileOutputStream fos = new FileOutputStream(userFilePath, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw);
             PrintWriter out = new PrintWriter(bw)) {
            out.write("\n"); // new line in csv
            out.print(email + " " + password + ",");
        }
        System.out.println("Registration successful!");
        return newUser;
    }
}




