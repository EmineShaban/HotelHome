import java.util.Scanner;

public class ConsoleSystem {
    private final Scanner scanner = new Scanner(System.in);
    private Hotel rooms;

    public ConsoleSystem(Hotel rooms) {
    this.rooms = rooms;

    }

    public void start() {
        System.out.println("Welcome to our Hotel Emine");
        menu();

    }

    private void menu() {
        while (true) {
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
                    return;
                case 3:
                    cancelBooking();
                    return;
                default:
                    System.out.println("Something going wrong! Choose 1, 2 or 3!");
            }
        }
    }




    private void viewFreeRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room: rooms.getRooms()) {
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
            room.setStatus("booked");
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
            room.setStatus("available");
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Room is either not booked or doesn't exist.");
        }


    }
}




