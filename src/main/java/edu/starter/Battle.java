import java.util.Scanner;
package edu.starter;

class Battle{
    public static int player_deal_damage = 10;

    public static boolean main_battle( Combatant player, int enemy_health,String enemy_name, Scanner scanner){
        if (player.getdef() == true){
            player.defend();
        }
        Combatant enemy = new Combatant(enemy_name, enemy_health);
        
        
    while (player.getHP() >0 && enemy.getHP()>0){
        System.out.println("" + player.getname() + " HP: " + player.getHP() + " Player Resource: " + player.getres() + " " + enemy_name + " HP: " + enemy.getHP());
        System.out.print("choose an action: \n 1 - attack the enemy  \n 2 - defend \n 3 - special \n 4 - recover ");
        String action = scanner.nextLine();
        System.out.println(action);
        if (action.equals("1")){
            player.Attack(enemy,player_deal_damage);
            if (enemy.getHP()>0){
            enemy.Attack(player,10);
        }
        } else if (action.equals("2")){
            player.defend();
            if (enemy.getHP()>0){
            enemy.Attack(player,10);
        } 
        } else if (action.equals("3")) {
            boolean special_used = player.special(enemy);
            if (special_used && enemy.getHP()>0){
            enemy.Attack(player,10);
        }
        } else if (action.equals("4")) {
            boolean recover_used = player.recover();
            if (enemy.getHP()>0 && recover_used){
            enemy.Attack(player,10);
        }
        }
    }
    if (player.getHP() <= 0){
        System.out.println("You lose!");
        return false;
    }
    return true;
    }
 
    public static void reward(Combatant player, Scanner scanner){
            System.out.println("choose a reard: \n 1 - recovery \n 2 - power");
            int reward_decision = Integer.parseInt(scanner.nextLine());
            switch(reward_decision){
                case 1 -> player.gain_health(25);
                case 2 -> player_deal_damage = 12;
            }
            if (reward_decision != 1 && reward_decision != 2){
                reward(player, scanner);
            }
    }
}