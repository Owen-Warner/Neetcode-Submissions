class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combs(int[] cands, int remaining, int start,
                               List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < cands.length; i++) {
            if (i > start && cands[i] == cands[i - 1]) {
                continue;
            }
            if (cands[i] > remaining) {
                break;
            }
            current.add(cands[i]);
            combs(cands, remaining - cands[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
