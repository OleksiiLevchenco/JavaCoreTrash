package strategy.duck.behaviors.flyBehavior;

/**
 * @author Alexey Levchhenko
 */
public class FlyByRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly with rocket!!");
    }
}
