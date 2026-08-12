class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> x = new HashMap<>();
        for(int n : nums){
            if(x.containsKey(n)){
                x.replace(n, x.get(n)+1);
            }
            else{
                x.put(n, 1);
            }
        }
        for(int n : x.keySet()){
            if(x.get(n) == 1){
                return n;
            }
        }
        return -1;
    }
}
