package extentionExemple.weapon;

/**
 * @author Alexey Levchenko
 */
public class pistol implements Weapon {
    @Override
    public void shoot() {
        System.out.println("пах");
    }

    @Override
    public float getWeight() {
        return 0.850f;
    }
}
