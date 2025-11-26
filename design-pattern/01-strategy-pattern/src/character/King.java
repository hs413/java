package character;

public class King extends Character {
    public King() {
        this.weapon = new SwordBehavior();
    }



    @Override
    public void fight() {
        weapon.useWeapon();
    }
}
