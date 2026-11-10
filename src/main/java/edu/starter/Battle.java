package edu.starter;
import java.util.Scanner;

//import edu.starter.Battle.Reward;


class Battle{
    public static int player_deal_damage = 10;
        enum Reward {RECOVERY,POWER}
        private static boolean rewardAvailable = false;
        private static boolean rewardClaimed = false;
    /**
     * @pre player != null && enemy_health >= 0 && enemy_name != null && scanner != null
     * @post returns true if player wins the battle, false if player loses
     */ 

    public static boolean main_battle( Combatant player, int enemy_health,String enemy_name, Scanner scanner){
        if (player.getdef() == true){
            player.defend();
        }
        Combatant enemy = new Combatant(enemy_name, enemy_health);
        
        
    while (player.getHP() >0 && enemy.getHP()>0){
        System.out.println("" + player.getname() + " HP: " + player.getHP() + " Player Resource: " + player.getres() + " Player attack: " + player.get_deal_damage() + " " + enemy_name + " HP: " + enemy.getHP());
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
 

    public static void unlockReward() {
    if (!rewardClaimed) {
        rewardAvailable = true;
    }
}

    /**
     * @pre (player != null && scanner != null) && battle_won == true; called after the first victory, before claiming a rewar
     * @post (player.HP == Math.min(oldHP + 25, 100) && player.player_deal_damage == oldplayer_deal_damage) or (player.player_deal_damage == 12 && player.HP == oldHP)
     */


    public static void reward(Combatant player, Scanner scanner){
        if (!rewardAvailable || rewardClaimed) {
        return;
    }
        while (true){
            System.out.println("choose a reward: \n 1 - recovery \n 2 - power");
            String input = scanner.nextLine();
            Reward reward_decision = switch (input) {
                case "1" -> Reward.RECOVERY;
                case "2" -> Reward.POWER;
                default -> null;
            };
            if (reward_decision == null){
                continue;
            } else {
                switch (reward_decision) {
                    case RECOVERY -> player.gain_health(25);
                    case POWER -> player.change_deal_damage(12);
            }
                rewardClaimed = true;
                rewardAvailable = false;
                return;
            }


        }
            
    }
}