package dicorator.coffe.beverages;

import dicorator.coffe.Beverage;

/**
 * @author Alexey Levchhenko
 */
public class Tea extends Beverage {

    @Override
    public String getDescription() {
        return "Tea";
    }
    @Override
    public double cost() {
        return 0.75;
    }
}