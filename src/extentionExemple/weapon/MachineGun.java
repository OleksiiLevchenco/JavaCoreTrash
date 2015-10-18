package extentionExemple.weapon;

/**
 * @author Alexey Levchhenko
 */
public class MachineGun implements Weapon {
    @Override
    public void shoot() {
        System.out.println("Ды-Ды-Ды-Ды-Ды-Ды-Ды-Ды-Ды-Ды-Ды-Ды");
    }

    @Override
    public float getWeight() {
        return 7.5f;
    }
}
