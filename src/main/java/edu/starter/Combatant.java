package edu.starter;

/**
 * Class Invariants:
 * 0 <= HP && HP <= 100
 * 0 <= resource && resource <= 10
 * name != null
 * player_deal_damage >= 0
 */

abstract class Combatant{
    private int HP;
    private int resource;
    private boolean defence;
    private String name;
    private int player_deal_damage;

    /**
     * @pre 0 <= HP && HP <= 100
     * @pre 0 <= resource && resource <= 10
     * @post this.HP == HP
     * @post this.resource == resource
     * @post this.defence == defence
     * @post this.player_deal_damage == 10
     * @post this.name.equals("player")
     */
    protected Combatant(String name, int HP, int resource) {
        this.HP = HP;
        this.resource = resource;
        this.defence = false;
        this.name = name;
        this.player_deal_damage = 0;
    }

    protected abstract int baseAttack();
    protected abstract int maxHP();
    protected int blockAmount() { return 5; }

    /**
     * @pre target != null
     * @post target loses this.player_deal_damage HP,
     * or 5 less damage if target was defending.
     * HP never goes below 0.
     */
    public void Attack(Combatant target){
        target.damage(get_deal_damage());
    }
    /**
    * @pre dam>=0
    * @post this.HP == Math.max(oldHP - (dam-5),0); or this.HP == Math.max(oldHP - dam,0);
    */
    public void damage(int dam){
        if (this.defence == true && dam >= blockAmount()){
            this.HP = Math.max(this.HP - (dam-blockAmount()),0);
            this.defend();
        } else {
            this.HP = Math.max(this.HP - dam,0);
        }
    }
    /**
     * @pre true
     * @post defence != oldDefence
     */
    public void defend(){
        if (this.defence == true){
            this.defence = false;
        } else if (this.defence == false){
            this.defence = true;
        }
    }
    /**
     * @pre enemy != null
     * @post if oldResource >= 3, returns true,
     * resource decreases by 3 and enemy takes 15 damage
     * Otherwise, returns false and nothing changes.
     */
    public boolean special(Combatant enemy){
        if (this.resource >= 3){
            this.resource = this.resource - 3;
            enemy.damage(15);
            return true;
        }
        return false;
    }
    /**
     * @pre true
     * @post this.resource == Math.min(oldresource + 3, 10); or this.resource == oldresource;
     */
    public boolean recover() {
        if (this.resource < 10) {
            this.resource = Math.min(this.resource + 3, 10);
            return true;
        }
    return false;
    }
    /**
     * @pre amount >= 0
     * @post this.HP == Math.min(oldHP + amount, 100);
     */
    public void gain_health(int amount) {
        this.HP += Math.min(amount, maxHP() - this.HP);
    }

    public int get_deal_damage() {
        return baseAttack() + this.player_deal_damage;
    }

    /**
     * @pre new_damage >= 0
     * @post this.player_deal_damage == new_damage;
     */
    public void change_deal_damage(int amount) {
        this.player_deal_damage += amount;
    }
    
    public int getHP() {
         return this.HP; 
        }
    
    public int getres() {
         return this.resource; 
        }

    public boolean getdef() {
         return this.defence; 
        }
    public String getname() {
         return this.name; 
        }

}