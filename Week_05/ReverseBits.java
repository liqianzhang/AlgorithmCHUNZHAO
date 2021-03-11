public class ReverseBits {
    public static void main(String[] args) {
        reverseBits(1100001111);
    }
    public static int reverseBits(int n) {
        int ret = 0;
        for (int i = 31; i >= 0 ; i--) {
            ret = ret | (((n >> (31 - i)) & 1) << i);
        }
        return ret;
    }
}
