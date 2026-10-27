package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */

import java.util.Scanner;
public final class Main {
 public static void main(String[] args){
    enemy_class enemy = new enemy_class(30);
    player_class player = new player_class();
    Scanner scanner = new Scanner(System.in);
    while (player.getHP() >0 && enemy.getHP()>0){
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
        System.out.println("Player HP: " + player.getHP() + " Enemy HP: " + enemy.getHP() + " Player Resource: " + player.getres());
    }
    if (player.getHP() <= 0){
        System.out.println("You lose");
    } else if (enemy.getHP() <= 0){
        System.out.println("You win");
    }
    
}
}


class player_class{
    private int HP;
    private int resource;
    private boolean defence;
    public player_class(){
         this.HP = 100;
         this.resource = 5;
         this.defence = false;
    }
    public void Attack(enemy_class target){
        target.damage(10);
    }
    public void damage(int dam){
        this.HP = Math.max(this.HP - dam,0);
    }
    public void defend(){
        if (this.defence == true){
            this.defence = false;
        } else if (this.defence == false){
            this.defence = true;
        }
    }
    public void special(enemy_class enemy){
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
}


class enemy_class{
    private int HP;
    private boolean defence;     

    public enemy_class (int health){
         this.HP = health;
    }
    public void damage(int dam){
        this.HP = Math.max(this.HP - dam,0);
    }
    public void Attack(player_class target){
        if (target.getdef() == true){
            target.damage(5);
        } else {
            target.damage(10);
        }
    }
    public int getHP() {
     return this.HP; 
    }


}

