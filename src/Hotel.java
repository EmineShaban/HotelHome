import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel(List<Room> rooms) {
//        this.name = name;
        this.rooms = rooms;
    }
    public List<Room> getRooms() {
//        System.out.println("ffff");
        return rooms;
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
//    public Room getAllRooms() {
//        for (Room room : rooms) {
//            System.out.println(room);
//                return room;
//
//        }
//        return null;
//    }
    }
