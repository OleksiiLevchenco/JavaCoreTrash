package strategy.duck.impl;

import strategy.duck.Duck;
import strategy.duck.behaviors.flyBehavior.FlyByWings;
import strategy.duck.behaviors.quackBehavior.Quack;

/**
 * @author Alexey Levchhenko
 */
public class MillardDuck extends Duck {

    public MillardDuck(){
        flyBehavior = new FlyByWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("A millard duckStrategy hear!");
    }
}
