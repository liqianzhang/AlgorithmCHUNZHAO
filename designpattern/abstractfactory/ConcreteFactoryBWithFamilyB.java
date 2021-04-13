package abstractfactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryBWithFamilyB implements IproductB {
    @Override
    public void doB() {
        System.out.println("the productB be part of FamilyB");
    }
}
