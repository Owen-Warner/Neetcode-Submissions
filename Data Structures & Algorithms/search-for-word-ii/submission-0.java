class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> storage = new HashMap<>();
        boolean inserted = false;
    }

    public TrieNode makeTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode currNode = root;
            for (int i = 0; i < word.length(); i++) {
                currNode = currNode.storage.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            currNode.inserted = true;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> output = new HashSet<>();
        TrieNode root = makeTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int x = 0; x < board[0].length; x++) {
                pathing(root, board, i, x, output, "");
            }
        }
        return new ArrayList<>(output);
    }

    private void pathing(TrieNode node, char[][] board, int row, int col,
                        Set<String> output, String currWord) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char c = board[row][col];
        if (c == '*' || !node.storage.containsKey(c)) return;

        TrieNode next = node.storage.get(c);
        String nextWord = currWord + c;
        if (next.inserted) output.add(nextWord);

        board[row][col] = '*';
        pathing(next, board, row - 1, col, output, nextWord);
        pathing(next, board, row + 1, col, output, nextWord);
        pathing(next, board, row, col - 1, output, nextWord);
        pathing(next, board, row, col + 1, output, nextWord);
        board[row][col] = c; // restore
    }
}
