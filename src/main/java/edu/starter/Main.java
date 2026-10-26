package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */

import java.util.Scanner;
public final class Main {
 public static void main(String[] args){
    enemy_class enemy = new enemy_class(100);
    player_class player = new player_class();
    Scanner scanner = new Scanner(System.in);
    while (player.getHP() >0 && enemy.getHP()>0){
        System.out.print("choose an action: \n 1 - attack the enemy \n 2 - enemy attacks you \n 3 - defend \n 4 - special \n 5 - recover ");
        int action = Integer.parseInt(scanner.nextLine());
        System.out.println(action);
        if (action == 1){
            player.Attack(enemy);
        } else if (action ==2) {
            enemy.Attack(player);
        } else if (action==3){
            player.defend();
        } else if (action ==4) {
            player.special();
        } else if (action ==5) {
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
        target.damage();
    }
    public void damage(){
        this.HP = this.HP - 10;
    }
    public void defend(){
        if (this.defence == true){
            this.defence = false;
        } else{
            this.defence = true;
        }
        
    }
    public void special(){
        if (this.resource >= 3){
            this.resource = this.resource - 3;
            this.HP = this.HP - 15;
        }
    }
    public void recover(){
        int points = 5;
        this.HP = Math.min(this.HP + points,100);
    }
    public int getHP() {
         return this.HP; 
        }
}


class enemy_class{
    private int HP;
    private boolean defence;
    public enemy_class(int health){
         this.HP = health;
    }
    public void damage(){
        this.HP = this.HP - 10;
    }
    public void Attack(player_class target){
        target.damage();
    }
    public int getHP() {
     return this.HP; 
    }


}

