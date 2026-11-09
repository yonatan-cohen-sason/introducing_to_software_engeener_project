import java.util.Scanner;
package edu.starter;

class Combatant{
    private int HP;
    private int resource;
    private boolean defence;
    private String name;
    public Combatant(int HP, int resource, boolean defence){
        if (HP>=0 && resource<=10 && resource>=0  && name != null){
            this.HP = HP;
            this.resource = resource;
            this.defence = defence;
            this.name = "player";
    } else {
        throw new IllegalArgumentException("Invalid Combatant parameters");
    }
}
    public Combatant(String name , int HP){
                if (HP>=0 && name != null){
            this.HP = HP;
            this.resource = 0;
            this.defence = false;
            this.name = name;
    } else {
        throw new IllegalArgumentException("Invalid Combatant parameters");
    }
    }
    public void Attack(Combatant target , int deal_damage){
        target.damage(deal_damage);
    }
    public void damage(int dam){
        if (this.defence == true && dam >= 5){
            this.HP = Math.max(this.HP - (dam-5),0);
            this.defend();
        } else {
            this.HP = Math.max(this.HP - dam,0);
        }
    }
    public void defend(){
        if (this.defence == true){
            this.defence = false;
        } else if (this.defence == false){
            this.defence = true;
        }
    }
    public boolean special(Combatant enemy){
        if (this.resource >= 3){
            this.resource = this.resource - 3;
            enemy.damage(15);
            return true;
        }
        return false;
    }
    public boolean recover() {
        if (this.resource < 10) {
            this.resource = Math.min(this.resource + 3, 10);
            return true;
        }
    return false;
}
    public void gain_health(int amount) {
        this.HP = Math.min(this.HP + amount, 100);
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