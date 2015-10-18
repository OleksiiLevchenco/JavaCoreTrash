package strategy.duck.impl;

import strategy.duck.Duck;
import strategy.duck.behaviors.flyBehavior.FlyNoWay;
import strategy.duck.behaviors.quackBehavior.Quack;

/**
 * @author Alexey Levchhenko
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("It is a model duckStrategy");
    }
}
