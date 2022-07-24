import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Do you want to generate a board or solve a board?\n"
                + "1. Generate\n"
                + "2. Solve\n"
                + "3. Exit");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("1")||choice.equalsIgnoreCase("Generate")){
            Generator.sudokuGenerator();
        }else if(choice.equalsIgnoreCase("2")||choice.equalsIgnoreCase("Solve")){
            System.out.println("Enter the file name of the board you want to solve(Note: The file must be in the same directory as the file. Ex. src/Board):");
            String fileName = sc.nextLine();
            BoardImporter.BoardReader(fileName);
            int length = Board.Board.length;
            if(Solver.SudokuSolver(length, Board.Board)){
                System.out.println("\n--------------------------");
                System.out.println("\n\nThe Solution:\n");
                Main.print(length);
            }else{
                System.out.println("No Solution Exists");
            }
        } else if (choice.equalsIgnoreCase("3")||choice.equalsIgnoreCase("Exit")){
            System.exit(0);
        } else {
            System.out.println("Invalid input");
            Main.main(null);
        }
    }


    public static void print(int N) throws IOException {

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
        Main.main(null);
    }

}
