package backtracking;

/**
 * Solves the "Sudoku Solver" problem (LeetCode #37) using backtracking.
 * Fills in the empty cells of a 9x9 Sudoku board.
 */
public class SudokuSolver {

    /**
     * Solves the Sudoku board by filling in all empty cells in-place.
     *
     * @param board The 9x9 Sudoku board, where empty cells are represented by '.'
     */
    public void solve(char[][] board) {
        solveBoard(board);
    }

    /**
     * Recursive function that uses backtracking to solve the board.
     *
     * @param board The Sudoku board
     * @return True if the board is solvable, false otherwise
     */
    private boolean solveBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find empty cell
                if (board[row][col] == '.') {

                    // Try placing digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively attempt to solve with this placement
                            if (solveBoard(board)) {
                                return true;
                            }

                            // Backtrack if not successful
                            board[row][col] = '.';
                        }
                    }

                    // If no digit works, return false
                    return false;
                }
            }
        }
        // All cells filled correctly
        return true;
    }

    /**
     * Checks whether it's valid to place a digit at a specific cell.
     *
     * @param board The Sudoku board
     * @param row   The row index
     * @param col   The column index
     * @param num   The digit to be placed
     * @return True if valid, false otherwise
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == num || board[i][col] == num) return false;

            // Check 3x3 sub-box
            int subRow = (row / 3) * 3 + i / 3;
            int subCol = (col / 3) * 3 + i % 3;
            if (board[subRow][subCol] == num) return false;
        }
        return true;
    }
}
