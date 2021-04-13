package simplefactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 * 具体产品productA
 */
public class ProductA implements Iproduct{
    @Override
    public void doSomething() {
        System.out.println("I am Product A");
    }
}
