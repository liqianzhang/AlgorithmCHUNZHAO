/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class PowXn {
    public double myPow(double x, int n) {
        return n >= 0 ? quickCal(x, n) : 1.0 / quickCal(x, -n);
    }

    private double quickCal(double x, int n) {
        if (n ==0 ) {
            return 1.0;
        }
        double y = quickCal(x, n /2);
        return n % 2 == 0? y * y : y * y * x;
    }
}
