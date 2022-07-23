public class Solver {
    public static boolean SafetyCheck( int row, int col, int num)
    {
        // row check - returns false if existing number is present
        for (int i = 0; i < Board.Board.length; i++)
        {
            if (Board.Board[row][i] == num)
            {
                return false;
            }
        }

        // column check - returns false if existing number is present
        for (int i = 0; i < Board.Board.length; i++)
        {
            if (Board.Board[i][col] == num)
            {
                return false;
            }
        }

        int root = (int) Math.sqrt(Board.Board.length);
        int Gridrow = row - row % root;
        int GridCol = col - col % root;

        for (int i = Gridrow;i < Gridrow + root; i++)
        {
            for (int j = GridCol;j < GridCol + root; j++)
            {
                if (Board.Board[i][j] == num)
                {
                    return false;
                }
            }
        }

        // Returning safe if no numbers are repeated
        return true;
    }

    public static boolean SudokuSolver( int n)
    {
        int row = -1;
        int col = -1;
        boolean empty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (Board.Board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    empty = false;   //for empty spaces
                    break;
                }
            }
            if (!empty)
            {
                break;
            }
        }

        if (empty)
        {
            return true;
        }

        // calling recursively for checking
        //other position if the current postion is invalid
        //by backtracking
        for (int k = 1; k <= n; k++)
        {
            if (SafetyCheck(row, col, k))
            {
                Board.Board[row][col] = k;
                if (SudokuSolver(n))
                {
                    return true;
                }
                else
                {
                    Board.Board[row][col] = 0;
                }
            }
        }
        return false; //if there is no solution for the position hence ending the call
    }

}
