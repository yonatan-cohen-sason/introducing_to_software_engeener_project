package edu.starter;
public class Standard extends Combatant {
    Standard() {
        super("player", 100, 5);
    }

    @Override
    protected int baseAttack() {
        return 10;
    }

    @Override
    protected int maxHP() {
        return 100;
    }

    @Override
    protected int blockAmount() {
        return 5;
    }
}
