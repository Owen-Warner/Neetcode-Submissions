class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char curr = board[row][col];
                if (curr == word.charAt(0)) {
                    if (neighbor(board, word, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

        public boolean neighbor(char[][] board, String word, int row, int col) {
        if (word.isEmpty()) {
            return true;
        }
        if (board[row][col] != word.charAt(0)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = false;
        if (!found && row != 0) {
            found = neighbor(board, word.substring(1), row - 1, col);
        }
        if (!found && row != board.length - 1) {
            found = neighbor(board, word.substring(1), row + 1, col);
        }
        if (!found && col != 0) {
            found = neighbor(board, word.substring(1), row, col - 1);
        }
        if (!found && col != board[0].length - 1) {
            found = neighbor(board, word.substring(1), row, col + 1);
        }

        board[row][col] = temp;
        return found;
    }
}
