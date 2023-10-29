
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException {
//        Path inPath = Paths.get("/Users/macbook/IdeaProjects/Hotel/src/info.txt");
        List<Room> rooms = new ArrayList<>();
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/info.txt")))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                String[] values = lines[0].split(" ");
                int roomNumber = Integer.parseInt(values[0]);
                String type = values[1];
                String status = values[2];
                rooms.add(new Room(roomNumber, type, status));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/users.txt")))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                String[] values = lines[0].split(" ");
                String email = values[0];
                String password = values[1];
                users.add(new User(email, password));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ConsoleSystem consoleSystem = new ConsoleSystem(new Hotel(rooms), new User(users));
        UserSystem userSystem = new UserSystem(new User(users));

        consoleSystem.start();

    }
}

//emine-99@mail.ru 123123,
//        emineshaban@icloud.com qweqwe,
//        emine19997@gmail.com 987987,