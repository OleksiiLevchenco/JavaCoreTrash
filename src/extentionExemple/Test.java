package extentionExemple;

import extentionExemple.weapon.Carbine;
import extentionExemple.weapon.Lopata;
import extentionExemple.weapon.MachineGun;
import extentionExemple.weapon.Weapon;

/**
 * @author Alexey Levchhenko
 */
public class Test {
    public static void main(String[] args) {
        Man vova = new Man("Вова",27,93,176);
        Weapon weapon = new MachineGun();

        Paratrooper paratrooper = new Paratrooper(vova,weapon);

        paratrooper.destroyTarget();

        paratrooper.setWeapon(new Lopata());

        paratrooper.destroyTarget();

    }
}
