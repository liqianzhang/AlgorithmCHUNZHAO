package factorymethod;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Client2 {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        factory.makeProduct().doSomething();
        factory = new FactoryB();
        factory.makeProduct().doSomething();
        factory = new FactoryC();
        factory.makeProduct().doSomething();
    }
}
