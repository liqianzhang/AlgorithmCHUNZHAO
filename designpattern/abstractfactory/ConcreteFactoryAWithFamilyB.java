package abstractfactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryAWithFamilyB implements IproductA {
    @Override
    public void doA() {
        System.out.println("the productA be part of FamilyB");
    }
}
