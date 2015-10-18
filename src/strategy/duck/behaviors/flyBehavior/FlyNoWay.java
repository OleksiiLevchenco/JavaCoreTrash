package strategy.duck.behaviors.flyBehavior;

/**
 * @author Alexey Levchhenko
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Can`t fly");
    }
}
