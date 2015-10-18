package dicorator.coffe.beverages;

import dicorator.coffe.Beverage;

/**
 * @author Alexey Levchhenko
 */
public class Cafe extends Beverage {

    @Override
    public String getDescription() {
        return "Cafe";
    }

    @Override
       public double cost() {
        return 1.99;
    }
}
