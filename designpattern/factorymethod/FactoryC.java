package factorymethod;

import simplefactory.Iproduct;
import simplefactory.ProductC;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class FactoryC implements IFactory {
    @Override
    public Iproduct makeProduct() {
        return new ProductC();
    }
}
