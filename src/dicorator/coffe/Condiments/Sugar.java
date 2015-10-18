package dicorator.coffe.Condiments;

import dicorator.coffe.Beverage;
import dicorator.coffe.CondimentDecorator;

/**
 * @author Alexey Levchhenko
 */
public class Sugar extends CondimentDecorator{

    public  Sugar(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }



}
