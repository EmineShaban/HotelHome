
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
//        FileHandler.
        Path inPath = Paths.get("/Users/macbook/IdeaProjects/Hotel/src/info.txt");
//        Hotel hotel =
        List<Room> rooms = new ArrayList<>();
//        try {
//            List<String> lines = Files.readAllLines(inPath);
//
//            for (int i = 0; i < lines.size(); i++) {
//                var el = lines.get(i);
//                String[] e = el.split(" ");
//                int roomNumber = Integer.parseInt(e[0]);
//                String type = e[1];
//                String status = e[2];
//                rooms.add(new Room(roomNumber, type, status));
//
////                rooms.add(new Room(roomNumber, type, status));
//            }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/info.txt")))) {
            String line;
            // skipping the header line of the csv
//            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
               String[] values = lines[0].split(" ");
//                System.out.println(values);
//                for (int i = 0; i < values.length; i++) {
//
//                }
//                System.out.println(values[0]);

                int roomNumber = Integer.parseInt(values[0]);

                String type = values[1];
                String status = values[2];

                rooms.add(new Room(roomNumber, type, status));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ConsoleSystem consoleSystem = new ConsoleSystem(new Hotel(rooms));
        consoleSystem.start();

    }
}

