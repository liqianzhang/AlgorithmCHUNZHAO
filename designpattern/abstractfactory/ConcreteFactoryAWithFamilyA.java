package abstractfactory;



/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ConcreteFactoryAWithFamilyA implements IproductA {

    @Override
    public void doA() {
        System.out.println("the productA be part of FamilyA");
    }
}
