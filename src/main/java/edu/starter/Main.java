package edu.starter;
import java.util.Scanner;

public final class Main {
 public static void main(String[] args){
    combatant player = new combatant("Player", 100, 5, false);

    Battle encounter1 = new Battle();
    boolean first_fight = encounter1.main_battle(player, 30,"a");

    if (first_fight == true){
        System.out.println("next round:");

        Battle encounter2 = new Battle();
        boolean second_fight = encounter2.main_battle(player, 45,"b");

        if (second_fight == true){
            System.out.println("You win!");
    
}
}
}
}

class Battle{
    public boolean main_battle( combatant player, int enemy_health,String enemy_name){
        if (player.getdef() == true){
            player.defend();
        }
        combatant enemy = new combatant(enemy_name, enemy_health, 0, false);
        
        Scanner scanner = new Scanner(System.in);
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
            player.defend();
        }
        } else if (action.equals("3")) {
            int enem_hp = enemy.getHP();
            player.special(enemy);
            if (enemy.getHP()>0 && enem_hp != enemy.getHP()){
            enemy.Attack(player);
        }
        } else if (action.equals("4")) {
            int res = player.getres();
            player.recover();
            if (enemy.getHP()>0 && player.getres() != res){
            enemy.Attack(player);
        }
        }
    }
    if (player.getHP() <= 0){
        System.out.println("You lose!");
        return false;
    } else if (enemy.getHP() <= 0){
        return true;
    } else {
        return true;
    }

    }
}




class combatant{
    private int HP;
    private int resource;
    private boolean defence;
    private String name;
    public combatant(String name, int HP, int resource, boolean defence){
         this.HP = HP;
         this.resource = resource;
         this.defence = defence;
         this.name = name;
    }
    public void Attack(combatant target){
        target.damage(10);
    }
    public void damage(int dam){
        if (this.defence == true){
            this.HP = Math.max(this.HP - (dam-5),0);
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
    public void special(combatant enemy){
        if (this.resource >= 3){
            this.resource = this.resource - 3;
            enemy.damage(15);
        }
    }
    public void recover() {
    this.resource = Math.min(this.resource + 3, 10);
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