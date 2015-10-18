package extentionExemple.weapon;

/**
 * @author Alexey Levchhenko
 */
public class Lopata implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Дзынь");
    }

    @Override
    public float getWeight() {
        return 1.05f;
    }
}
