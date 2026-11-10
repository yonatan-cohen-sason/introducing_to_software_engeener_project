package edu.starter;
import java.util.Scanner;

public final class Main {
 public static void main(String[] args){
    System.out.println("First fight:");

    Combatant player = new Combatant(100, 5, false);
    Scanner scanner = new Scanner(System.in);
    boolean first_fight = Battle.main_battle(player, 30,"a", scanner);

    if (first_fight == true){
        System.out.println("Player status: HP-"+player.getHP()+" resources-"+player.getres()+" Attack-"+player.get_deal_damage());
        Battle.unlockReward();
        Battle.reward(player, scanner);
        System.out.println("Next round, second fight:");
        boolean second_fight = Battle.main_battle(player, 45,"b", scanner);

        if (second_fight == true){
            System.out.println("You win!");
    
        } 
    }
}
}






