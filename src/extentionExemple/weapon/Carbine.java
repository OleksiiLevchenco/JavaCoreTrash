package extentionExemple.weapon;

/**
 * @author Alexey Levchhenko
 */
public class Carbine implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Дыщь-ДыДыщь");
    }

    @Override
    public float getWeight() {
        return 3.05f;
    }
}
