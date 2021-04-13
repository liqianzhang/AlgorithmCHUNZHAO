package simplefactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Client {
    public static void main(String[] args) {
        Iproduct iproduct = new SimpleFactory().makeProduct(0);
        //iproduct.doSomething();
    }
}
