package edu.starter;

public class Striker extends Combatant{
    Striker(String name, int HP, int resource) {
        super(name, HP, resource);
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
