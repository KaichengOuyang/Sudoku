import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BoardImporter {
    public static void BoardReader(String fileName) throws IOException {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("File not found");
            Main.main(null);
        }
        try {
            for (int i = 0; i < 81; i++) {
                Board.Board[i / 9][i % 9] = Integer.parseInt(String.valueOf(data.charAt(i)));
            }
        }catch (StringIndexOutOfBoundsException e){;
            Main.main(null);
        }
    }
}
