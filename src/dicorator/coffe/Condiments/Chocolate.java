package dicorator.coffe.Condiments;

import dicorator.coffe.Beverage;
import dicorator.coffe.CondimentDecorator;

/**
 * @author Alexey Levchhenko
 */
public class Chocolate extends CondimentDecorator {

    public  Chocolate(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }

}
