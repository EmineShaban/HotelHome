import java.util.List;

public class Hotel {
    private List<Room> rooms;
    public Hotel(List<Room> rooms) {
        this.rooms = rooms;
    }
    public List<Room> getRooms() {
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
    }
