class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> output) {
        output.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, output);
            curr.remove(curr.size() - 1);
        }
    }
}