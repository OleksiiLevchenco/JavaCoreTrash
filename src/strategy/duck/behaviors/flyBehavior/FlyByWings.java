package strategy.duck.behaviors.flyBehavior;

/**
 * @author Alexey Levchhenko
 */
public class FlyByWings implements FlyBehavior  {

    @Override
    public void fly() {
        System.out.println("Fly in high! Fly Fly Fly");
    }
}
