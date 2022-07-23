import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BoardImporter {
    public static void BoardReader(String fileName) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        for(int i = 0; i < 81; i++){
            Board.Board[i/9][i%9] = Integer.parseInt(String.valueOf(data.charAt(i)));
        }
    }
}
