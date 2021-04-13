package factorymethod;

import simplefactory.Iproduct;
import simplefactory.ProductA;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class FactoryA implements IFactory {
    @Override
    public Iproduct makeProduct() {
        return new ProductA();
    }
}
