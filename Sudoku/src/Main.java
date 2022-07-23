import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Importing board...");
        BoardImporter.BoardReader("src/Board");
        int length = Board.Board.length;
        System.out.println("Imported board\n");
        print(length);
        if (Solver.SudokuSolver(length))
        {
            System.out.println("\n--------------------------");
            System.out.println("\n\nThe Solution:\n");
            print(length);
        }
        else
        {
            System.out.println("No Solution Exists");
        }
    }

    public static void print(int N) {

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                System.out.print(Board.Board[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
            if ((i + 1) % (int) Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

}
