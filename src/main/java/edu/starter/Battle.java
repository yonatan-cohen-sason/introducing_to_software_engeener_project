package edu.starter;
import java.util.Scanner;



class Battle{
        enum Reward {RECOVERY,POWER}
        private static boolean rewardAvailable = false;
        private static boolean rewardClaimed = false;
    
    /**
     * @pre player != null && scanner != null &&
     * enemy_name != null && 0 <= enemy_health && enemy_health <= 100
     * @pre firstEncounter is true only for the first encounter
     * @post returns true if player wins, false if player loses.
     * A first-encounter victory makes the reward available
     * if no reward was claimed before.
     */

    public static boolean main_battle( Combatant player, int enemy_health,String enemy_name, Scanner scanner, boolean firstEncounter){
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
    if (player.getHP() <= 0) {
        System.out.println("You lose!");
        return false;
    }

    if (firstEncounter && !rewardClaimed) {
        rewardAvailable = true;
    }

    return true;
    }
 

    /**
     * @pre player != null && scanner != null
     * @post if reward is unavailable or already claimed,
     * player state stays unchanged.
     * Otherwise, one valid reward is applied.
     * Invalid choices do not change player state.
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
                System.out.println("Unknown decision, try again");
                continue;
            } else {
                switch (reward_decision) {
                    case RECOVERY -> player.gain_health(25);
                    case POWER -> player.change_deal_damage(player.get_deal_damage() + 2);
            }
                rewardClaimed = true;
                rewardAvailable = false;
                return;
            }


        }
            
    }
}