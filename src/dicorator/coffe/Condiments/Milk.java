package dicorator.coffe.Condiments;

import dicorator.coffe.Beverage;
import dicorator.coffe.CondimentDecorator;

/**
 * @author Alexey Levchhenko
 */
public class Milk extends CondimentDecorator {

    public  Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.3 + beverage.cost();
    }


}