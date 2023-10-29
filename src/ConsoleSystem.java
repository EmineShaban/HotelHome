import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleSystem {
    private final Scanner scanner = new Scanner(System.in);
    private Hotel rooms;
    private UserSystem userSystem;
private User users;
    public ConsoleSystem(Hotel rooms, User users) throws IOException {
        this.rooms = rooms;
        this.userSystem = new UserSystem(users);
    }

    public void start() {
        System.out.println("Welcome to our Hotel Emine");
        System.out.println("Please, choose 1 or 2");
        System.out.println("1. Login");
        System.out.println("2. Registration");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                User user = userSystem.login();

                return;
            case 2:
                registration();
                return;
            default:
                System.out.println("Something going wrong! Choose 1 or 2!");

        }

//        menu();

    }

    private void menu() {
        while (true) {
            System.out.println("Please, choose 1, 2 or 3");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    viewFreeRooms();
                    return;
                case 2:
                    bookRoom();
                    saveTxt();
                    return;
                case 3:
                    cancelBooking();
                    saveTxt();
                    return;
                default:
                    System.out.println("Something going wrong! Choose 1, 2 or 3!");

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
            e.printStackTrace();
        }
    }

    private void viewFreeRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms.getRooms()) {
//            System.out.println(room);
            if ("available".equalsIgnoreCase(room.getStatus())) {
                System.out.println(room.roomNumber);
            }
        }
        menu();
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

    private void login(){

    }

    private void registration(){

    }
}




