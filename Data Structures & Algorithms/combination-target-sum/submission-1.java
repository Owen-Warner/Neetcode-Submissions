class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> output = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), output, target, 0);
    return output;
}

private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> output, int target, int tot) {
    if (tot == target) {
        output.add(new ArrayList<>(curr));
        return;
    }
    if (tot > target) {
        return;
    }
    for (int i = start; i < nums.length; i++) {
        curr.add(nums[i]);
        backtrack(nums, i, curr, output, target, tot + nums[i]); 
        curr.remove(curr.size() - 1);
    }
}
}
