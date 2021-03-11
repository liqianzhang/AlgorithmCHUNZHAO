import java.util.Arrays;

public class MinPathSum {
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
