import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {

        char[] tasks = new char[] {'A' ,'C' , 'C', 'C', 'B', 'B'};
        int[] buckets = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        System.out.println(maxTimes);
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        System.out.println(maxCount);



    }
}
