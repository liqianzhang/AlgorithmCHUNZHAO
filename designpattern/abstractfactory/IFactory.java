package abstractfactory;

import simplefactory.Iproduct;

public interface IFactory {
    IproductA makeProductA();

    IproductB makeProductB();
}
