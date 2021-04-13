package abstractfactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryBWithFamilyA implements IproductB {
    @Override
    public void doB() {
        System.out.println("the productB be part of FamilyA");
    }
}
