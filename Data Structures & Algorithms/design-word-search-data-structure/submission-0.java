class TrieNode {
    HashMap<Character, TrieNode> storage = new HashMap<>();
    boolean inserted = false;
}

class WordDictionary {
    TrieNode lets;

    public WordDictionary() {
        lets = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currNode = lets;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            currNode = currNode.storage.computeIfAbsent(curr, c -> new TrieNode());
        }
        currNode.inserted = true;
    }

    public boolean search(String word) {
        return searchHelper(word, lets);
    }

    private boolean searchHelper(String word, TrieNode node) {
        TrieNode currNode = node;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == '.') {
                for (TrieNode child : currNode.storage.values()) {
                    if (searchHelper(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else if (currNode.storage.containsKey(curr)) {
                currNode = currNode.storage.get(curr);
            } else {
                return false;
            }
        }
        return currNode.inserted;
    }
}