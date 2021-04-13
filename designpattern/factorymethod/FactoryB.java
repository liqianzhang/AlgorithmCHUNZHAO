package factorymethod;

import simplefactory.Iproduct;
import simplefactory.ProductB;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class FactoryB implements IFactory {
    @Override
    public Iproduct makeProduct() {
        return new ProductB();
    }
}
