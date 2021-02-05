/**
 接雨水
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int rainNo = 0;
        for (int i = 1; i < height.length-1; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(height[j], max_left);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(height[j], max_right);
            }
            rainNo += Math.min(max_left, max_right) - height[i];
        }
        return rainNo;
    }
}
