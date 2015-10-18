package strategy.duck;

import strategy.duck.behaviors.flyBehavior.FlyBehavior;
import strategy.duck.behaviors.quackBehavior.QuackBehavior;

/**
 * @author Alexey Levchhenko
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public Duck(){}

    public void flyPerform(){
        flyBehavior.fly();
    }
    public  void  quackPerform(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("swim swim swim");
    }

    public abstract void display();
}
