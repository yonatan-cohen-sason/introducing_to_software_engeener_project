package edu.starter;
import java.util.Scanner;

public final class Main {
 public static void main(String[] args){
    combatant player = new combatant("Player", 100, 5, false);
    Scanner scanner = new Scanner(System.in);
    
    Battle encounter1 = new Battle();
    boolean first_fight = encounter1.main_battle(player, 30,"a", scanner);

    if (first_fight == true){
        System.out.println("next round:");

        Battle encounter2 = new Battle();
        boolean second_fight = encounter2.main_battle(player, 45,"b", scanner);

        if (second_fight == true){
            System.out.println("You win!");
    
}
}
}
}

class Battle{
    public boolean main_battle( combatant player, int enemy_health,String enemy_name, Scanner scanner){
        if (player.getdef() == true){
            player.defend();
        }
        combatant enemy = new combatant(enemy_name, enemy_health, 0, false);
        
        
    while (player.getHP() >0 && enemy.getHP()>0){
        System.out.println("" + player.getname() + " HP: " + player.getHP() + " Player Resource: " + player.getres() + " " + enemy_name + " HP: " + enemy.getHP());
        System.out.print("choose an action: \n 1 - attack the enemy  \n 2 - defend \n 3 - special \n 4 - recover ");
        String action = scanner.nextLine();
        System.out.println(action);
        if (action.equals("1")){
            player.Attack(enemy);
            if (enemy.getHP()>0){
            enemy.Attack(player);
        }
        } else if (action.equals("2")){
            player.defend();
            if (enemy.getHP()>0){
            enemy.Attack(player);
        } 
        } else if (action.equals("3")) {
            boolean special_used = player.special(enemy);
            if (special_used && enemy.getHP()>0){
            enemy.Attack(player);
        }
        } else if (action.equals("4")) {
            boolean recover_used = player.recover();
            if (enemy.getHP()>0 && recover_used){
            enemy.Attack(player);
        }
        }
    }
    if (player.getHP() <= 0){
        System.out.println("You lose!");
        return false;
    }
    return true;
    }
}




class combatant{
    private int HP;
    private int resource;
    private boolean defence;
    private String name;
    public combatant(String name, int HP, int resource, boolean defence){
        if (HP<=100 && HP>=0 && resource<=10 && resource>=0 && (defence == true || defence == false) && name != null){
            this.HP = HP;
            this.resource = resource;
            this.defence = defence;
            this.name = name;
    } else {
        throw new IllegalArgumentException("Invalid combatant parameters");
    }
}
    public void Attack(combatant target){
        target.damage(10);
    }
    public void damage(int dam){
        if (this.defence == true){
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
    public boolean special(combatant enemy){
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