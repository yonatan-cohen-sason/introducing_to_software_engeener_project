package edu.starter;

class Guardian extends Combatant {

    /**
     * @pre name != null
     * @pre 0 <= resource && resource <= 10
     * @post this.HP == 130
     * @post this.resource == resource
     * @post this.name.equals(name)
     */
    Guardian(String name, int resource) {
        super(name, 130, resource);
    }

    @Override
    protected int baseAttack() {
        return 8;
    }

    @Override
    protected int maxHP() {
        return 130;
    }

    @Override
    protected int blockAmount() {
        return 7;
    }
}
