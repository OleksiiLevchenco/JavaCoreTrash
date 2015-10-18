package dicorator.coffe.Condiments;

import dicorator.coffe.Beverage;
import dicorator.coffe.CondimentDecorator;

/**
 * @author Alexey Levchhenko
 */
public class Whip extends CondimentDecorator {

    public  Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }


}
