package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
 public static void main(String[] args){
    enemy_class enemy = new enemy_class(100);
    player_class player = new player_class();
    if (player.HP <0 && enemy.HP<0){
        break;
    }




}
}


class player_class{
    private int HP;
    private int resource;
    private boolean defence;
    private boolean pendingDefense;
    public void player_class(){
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
        this.defence = true;
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



}

