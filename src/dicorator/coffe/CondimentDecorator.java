package dicorator.coffe;

/**
 * @author Alexey Levchhenko
 */
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public abstract double cost();


    @Override
    public abstract String getDescription();
}
