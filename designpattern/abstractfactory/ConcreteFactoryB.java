package abstractfactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryB implements IFactory {
    @Override
    public IproductA makeProductA() {
        return new ConcreteFactoryAWithFamilyB();
    }

    @Override
    public IproductB makeProductB() {
        return new ConcreteFactoryBWithFamilyB();
    }
}
