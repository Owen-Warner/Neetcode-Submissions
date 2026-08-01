class Solution {
    public List<String> generateParenthesis(int n) {
        return parens(n, 0, 0, "");
    }

    public List<String> parens(int n, int left, int right, String str){
        ArrayList<String> temp = new ArrayList<>();
        if(left == n && right == n){
            temp.add(str);
            return temp;
        }
        if(left != n){
            temp.addAll(parens(n, left+1, right, str+"("));
        }
        if(right != left){
            temp.addAll(parens(n, left, right+1, str+")"));
        }
        return temp;
    }
}
