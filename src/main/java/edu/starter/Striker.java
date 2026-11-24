package edu.starter;

public class Striker extends Combatant{
    /**
     * @pre name != null
     * @pre 0 <= resource && resource <= 10
     * @post this.HP == 80
     * @post this.resource == resource
     * @post this.name.equals(name)
     */
    Striker(String name, int resource) {
        super(name, 80, resource);
    }

    @Override
    protected int baseAttack() {
        return 12;
    }

    @Override
    protected int maxHP() {
        return 80;
    }
}
