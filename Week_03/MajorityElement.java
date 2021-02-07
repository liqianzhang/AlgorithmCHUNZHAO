import java.util.Arrays;

/**
 * @MethodName: $
 * @Description: 竟然还有这么简单的方法，数学才是生产力
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
