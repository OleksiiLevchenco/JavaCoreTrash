package strategy.duck.behaviors.quackBehavior;

/**
 * @author Alexey Levchhenko
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack, quack");
    }
}
