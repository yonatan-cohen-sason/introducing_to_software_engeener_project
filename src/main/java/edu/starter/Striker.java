package edu.starter;

public class Striker extends Combatant{
    Striker() {
        super("player", 80, 5);
    }

    @Override
    protected int baseAttack() {
        return 12;
    }

    @Override
    protected int maxHP() {
        return 80;
    }

    @Override
    protected int blockAmount() {
        return 5;
    }
}
