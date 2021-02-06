

public class UglyNumber {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) {
                a++;
            }
            if (n3 == dp[i]) {
                b++;
            }
            if (n5 == dp[i]) {
                c++;
            }

        }
        return dp[n-1];
    }
}
