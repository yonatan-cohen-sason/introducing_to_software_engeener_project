package edu.starter;

class Guardian extends Combatant {

    Guardian() {
        super("player", 130, 5);
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
