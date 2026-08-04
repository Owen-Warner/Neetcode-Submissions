class Solution {
    private static final String[] KEYS = {
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        } 
        return combLet(digits, "");
    }

    public List<String> combLet(String digits, String word) {
        if (digits.isEmpty()) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(word);
            return temp;
        }
        ArrayList<String> temp = new ArrayList<>();
        String letters = KEYS[digits.charAt(0) - '0'];
        for (char c : letters.toCharArray()) {
            temp.addAll(combLet(digits.substring(1), word + c));
        }
        return temp;
}
}
