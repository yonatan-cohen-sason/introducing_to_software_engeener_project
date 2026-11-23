package edu.starter;
public class Standard extends Combatant {
    Standard(String name, int HP, int resource) {
        super(name, HP, resource);
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
