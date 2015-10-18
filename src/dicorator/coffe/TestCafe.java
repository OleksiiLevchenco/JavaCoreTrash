package dicorator.coffe;

import dicorator.coffe.Condiments.*;
import dicorator.coffe.beverages.Cafe;
import dicorator.coffe.beverages.Tea;

/**
 * @author Alexey Levchhenko
 */
public class TestCafe {

    public static void main(String[] args) {

        Beverage cafe1 = new Cafe();
        cafe1 = new Milk(cafe1);
        cafe1 = new Sugar(cafe1);

        System.out.println(cafe1.getDescription());
        System.out.println(cafe1.cost());

        Beverage tea1 = new Tea();
        tea1 = new Sugar(tea1);

        System.out.println(tea1.getDescription());
        System.out.println(tea1.cost());

    }
}
