package abstractfactory;


/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Client3 {
    public static void main(String[] args) {
        IFactory factory = new ConcreteFactoryA();
        IproductA iproductA = factory.makeProductA();
        iproductA.doA();
        factory.makeProductB();

        factory = new ConcreteFactoryB();
        factory.makeProductA();
        factory.makeProductB();
    }
}
