package strategy.duck.behaviors.quackBehavior;

/**
 * @author Alexey Levchhenko
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak, squeak");
    }
}
