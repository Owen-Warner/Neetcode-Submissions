public class Solution {
    public int reverseBits(int n) {
        long unsignedN = Integer.toUnsignedLong(n);
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result * 2 + (unsignedN % 2);
            unsignedN /= 2;
        }
        return (int) result;
    }
}