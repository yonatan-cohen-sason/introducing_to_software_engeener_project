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
        // } else if (action ==2) {
        //     enemy.Attack(player);
        } else if (action.equals("2")){
            player.defend();
            if (enemy.getHP()>0){
            enemy.Attack(player);
        }
        } else if (action.equals("3")) {
            int enem_hp = enemy.getHP();
            player.special(enemy);
            if (enemy.getHP()>0 && enem_hp != enemy.getHP()){
            enemy.Attack(player);
        }
        } else if (action.equals("4")) {
            player.recover();
            if (enemy.getHP()>0){
            enemy.Attack(player);
        }
        }
        System.out.println("enemy: " + enemy.getHP() + " player: " + player.getHP());
    }
    
}
}


class player_class{
    private int HP;
    private int resource;
    private boolean defence;
    private boolean pendingDefense;
    public player_class(){
         this.HP = 100;
         this.resource = 5;
         this.pendingDefense = false;
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
        } else{
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
        target.damage(10);
    }
    public int getHP() {
     return this.HP; 
    }


}

