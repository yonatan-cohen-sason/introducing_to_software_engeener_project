package edu.starter;

class Guardian extends Combatant {

    Guardian(String name, int HP, int resource) {
        super(name, HP, resource);
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
