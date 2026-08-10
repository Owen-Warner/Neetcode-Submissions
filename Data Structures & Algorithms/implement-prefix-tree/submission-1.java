class PrefixTree {
    class TrieNode{
        HashMap<Character, TrieNode> storage = new HashMap<>();
        boolean inserted = false;
    }

        TrieNode lets;

        public PrefixTree() {
            lets = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currNode = lets;
            for(int i = 0; i < word.length(); i++){
                char curr = word.charAt(i);
                if(currNode.storage.containsKey(curr)){
                    currNode = currNode.storage.get(curr);
                }
                else{
                    TrieNode n = new TrieNode();
                    currNode.storage.put(curr, n);
                    currNode = n;
                }
            }
            currNode.inserted = true;
        }

        public boolean search(String word) {
            if(word.isEmpty()){
                return true;
            }
            else{
                TrieNode currNode = lets;
                for(int i = 0; i < word.length(); i++){
                    char curr = word.charAt(i);
                    if(currNode.storage.containsKey(curr)){
                        currNode = currNode.storage.get(curr);
                    }
                    else{
                        return false;
                    }
                }
                return currNode.inserted;
            }
        }

        public boolean startsWith(String prefix) {
            if(prefix.isEmpty()){
                return true;
            }
            else{
                TrieNode currNode = lets;
                for(int i = 0; i < prefix.length(); i++){
                    char curr = prefix.charAt(i);
                    if(currNode.storage.containsKey(curr)){
                        currNode = currNode.storage.get(curr);
                    }
                    else{
                        return false;
                    }
                }
                return true;
            }
        }
    }
