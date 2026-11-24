package edu.starter;
public class Standard extends Combatant {
    Standard(String name, int HP, int resource) {
        super(name, HP, resource);
    }

    /**
     * @pre name != null
     * @pre 0 <= HP && HP <= maxHP()
     * @post this.HP == HP
     * @post this.resource == 5
     * @post this.name.equals(name)
     */
    Standard(String name, int HP) {
        this(name, HP, 5);
    }

    @Override
    protected int baseAttack() {
        return 10;
    }

    @Override
    protected int maxHP() {
        return 100;
    }
}
