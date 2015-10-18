package dicorator.coffe.beverages;

import dicorator.coffe.Beverage;

/**
 * @author Alexey Levchhenko
 */
public class Espresso extends Beverage {


    @Override
    public String getDescription() {
        return "Espresso";
    }
    @Override
      public double cost() {
        return 2.00;
    }

}