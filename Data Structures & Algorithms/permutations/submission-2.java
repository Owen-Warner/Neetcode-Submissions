class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int x : nums) {
            temp.add(x);
        }
        return mute(temp, new ArrayList<>());
    }

    public static List<List<Integer>> mute(ArrayList<Integer> nums, ArrayList<Integer> curr){
        if(nums.isEmpty()){
            return new ArrayList<>(Collections.singletonList(new ArrayList<>(curr)));
        }
        else{
            int sz = nums.size();
            ArrayList<List<Integer>> bigUn = new ArrayList<>();
            for(int i = 0; i < sz; i++){
                curr.add(nums.get(i));
                ArrayList<Integer> ongoing = new ArrayList<>(nums);
                ongoing.remove(i);
                List<List<Integer>> temp = mute(ongoing, curr);
                bigUn.addAll(temp);
                curr.remove(curr.size() - 1);
            }
            return bigUn;
        }
    }
}
