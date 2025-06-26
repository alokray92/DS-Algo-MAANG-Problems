package backtracking;

/**
 * Solves the "Word Search" problem (LeetCode #79) using DFS with backtracking.
 */
public class WordSearchSolver {

    /**
     * Main method to check if the word exists in the board.
     *
     * @param board 2D character board
     * @param word  Target word to search
     * @return True if word exists, otherwise false
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try to start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchFromCell(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Performs DFS from a cell to find the word character by character.
     *
     * @param board The board of characters
     * @param word The target word
     * @param row Current row index
     * @param col Current column index
     * @param index Current character index in the word
     * @return True if the word can be formed from this path
     */
    private boolean searchFromCell(char[][] board, String word, int row, int col, int index) {
        // Base conditions: out of bounds or character mismatch
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // All characters matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#'; // Temporarily mark as visited

        // Explore all 4 directions
        boolean found =
                searchFromCell(board, word, row + 1, col, index + 1) ||
                        searchFromCell(board, word, row - 1, col, index + 1) ||
                        searchFromCell(board, word, row, col + 1, index + 1) ||
                        searchFromCell(board, word, row, col - 1, index + 1);

        // Backtrack: restore original character
        board[row][col] = temp;

        return found;
    }
}
