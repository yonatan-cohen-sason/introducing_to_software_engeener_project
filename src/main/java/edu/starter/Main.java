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
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println(action);
        if (action == 1){
            player.Attack(enemy);
        // } else if (action ==2) {
        //     enemy.Attack(player);
        } else if (action==2){
            player.defend();
        } else if (action ==3) {
            player.special(enemy);
        } else if (action ==4) {
            player.recover();
        }
        System.out.println(""+player.getHP()+" "+enemy.getHP());


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
    public void recover(){
        int points = 5;
        this.resource =this.resource + points;
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

