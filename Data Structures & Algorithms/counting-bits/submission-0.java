class Solution {
    public int[] countBits(int n) {
    int[] ones = new int[n + 1];
    int starter = 1;
    while (starter < n) {
        starter = starter * 2;
    }
    for (int num = 0; num <= n; num++) {
        int currnum = num;
        int var = starter;
        int count = 0;
        while (currnum != 0) {
            if (currnum - var >= 0) {
                currnum -= var;
                count++;
            }
            var = var / 2;
        }
        ones[num] = count;
    }
    return ones;
    }
}
