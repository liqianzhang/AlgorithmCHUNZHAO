import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class WalkingRobot {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> collect = Arrays.stream(obstacles).map(a -> a[0] + " " + a[1]).collect(Collectors.toSet());
        int x = 0, y = 0, d = 0, res = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            }else if (cmd == -2){
                d = (d + 3) % 4;
            }else{
                while (cmd --> 0 && !collect.contains((x + directs[d][0]) + " " + (y + directs[d][1]))) {
                    x += directs[d][0];
                    y += directs[d][1];
                    res = Math.max(res ,x * x + y * y);
                }
            }

        }
        return res;
    }
}
