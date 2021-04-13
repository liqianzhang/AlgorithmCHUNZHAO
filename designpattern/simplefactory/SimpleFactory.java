package simplefactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class SimpleFactory {
    public Iproduct makeProduct (int kind) {
        switch (kind) {
            case Const.PRODUCT_A:
                return new ProductA();
            case Const.PRODUCT_B:
                return new ProductB();
            case Const.PRODUCT_C:
                return new ProductC();

        }
        return null;
    }
}
