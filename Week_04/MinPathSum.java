import java.util.Arrays;

public class MinPathSum {
    /**
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, colomns = grid[0].length;
        int[][] dp = new int[rows][colomns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < colomns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < colomns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][colomns - 1];
    }     */
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i - 'A']]++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for (int i = 25; i > 1; i--) {
            if (buckets[i] == buckets[i - 1]) {
                maxCount++;
            }
            else {
                break;
            }
        }
        int ret = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(ret, tasks.length);
    }
}
