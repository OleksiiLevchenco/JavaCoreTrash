package strategy.duck.test;

import strategy.duck.Duck;
import strategy.duck.behaviors.flyBehavior.FlyByRocketPower;
import strategy.duck.impl.MillardDuck;
import strategy.duck.impl.ModelDuck;

/**
 * @author Alexey Levchhenko
 */
public class DuckTest {
    public static void main(String[] args) {
        Duck millard = new MillardDuck();
        millard.display();
        millard.flyPerform();
        millard.quackPerform();
        millard.swim();


        Duck model = new ModelDuck();
        model.display();
        model.flyPerform();
        model.setFlyBehavior(new FlyByRocketPower());
        model.flyPerform();

    }
}
