package abstractfactory;



/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryA implements IFactory {

    @Override
    public IproductA makeProductA() {
        return new ConcreteFactoryAWithFamilyA();
    }

    @Override
    public IproductB makeProductB() {
        return new ConcreteFactoryBWithFamilyA();
    }
}
