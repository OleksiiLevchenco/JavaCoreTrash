package extentionExemple;

import extentionExemple.weapon.Weapon;

/**
 * @author Alexey Levchhenko
 */
public class Paratrooper extends Man {

    private Weapon weapon;

    public Paratrooper(Man man , Weapon weapon) {
        super(man.getName(), man.getAge(), man.getWeight(), man.getHeight());
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void destroyTarget(){
        System.out.println("Рядовий " + this.getName() + " до бою готовий!");
        weapon.shoot();
        System.out.println("Виконано!");

    }
}
