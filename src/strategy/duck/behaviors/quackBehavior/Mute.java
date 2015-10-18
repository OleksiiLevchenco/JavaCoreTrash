package strategy.duck.behaviors.quackBehavior;

/**
 * @author Alexey Levchhenko
 */
public class Mute implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< silent >>");
    }
}
