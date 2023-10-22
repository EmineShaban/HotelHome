class Room{
   public int roomNumber;
     public String roomType;
     public String status;
    public Room(int roomNumber, String roomType, String status){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }
     public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Status: " + status;
    }


//    public getRooms() {
//        return rooms;
//    }

}