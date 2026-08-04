class Solution {
    public List<List<String>> solveNQueens(int n) {
    String[][] board = new String[n][n];
    for (int i = 0; i < n; i++) {
        for (int x = 0; x < n; x++) {
            board[i][x] = "X";
        }
    }
    return convert(queenMaker(n, board, 0));
    }

    public ArrayList<String[][]> queenMaker(int n, String[][] board, int currRow) {
        ArrayList<String[][]> setup = new ArrayList<>();
        if (currRow == n) {
            setup.add(board);
            return setup;
        }
        for (int i = 0; i < board.length; i++) {
            if (!board[currRow][i].equals(".")) {
                String[][] tempBoard = boardAdjuster(currRow, i, deepCopy(board));
                setup.addAll(queenMaker(n, tempBoard, currRow + 1));
            }
        }
        return setup;
    }

    public String[][] deepCopy(String[][] board) {
        String[][] copy = new String[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    public String[][] boardAdjuster(int row, int col, String[][] board) {
        board[row][col] = "Q";
        for (int i = row + 1; i < board.length; i++) {
            board[i][col] = ".";
            int diff = i - row;
            if (col - diff >= 0){
                board[i][col - diff] = ".";
            } 
            if (col + diff < board.length){
                board[i][col + diff] = ".";
            } 
        }
        return board;
    }

    public List<List<String>> convert(ArrayList<String[][]> maps){
        ArrayList<List<String>> output = new ArrayList<>();
        for(String[][] x : maps){
            ArrayList<String> currList = new ArrayList<>();
            for(int i = 0; i < x.length; i++){
                String currString = "";
                for(String s : x[i]){
                    if(s.equals("X")){
                        currString = currString + ".";
                    }
                    else{
                        currString = currString + s;
                    }
                }
                currList.add(currString);
            }
            output.add(currList);
        }
        return output;
    }
}
