package edu.starter;
import java.util.Scanner;

public final class Main {
 public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("choose a player: \n 1 - Standard  \n 2 - Guardian \n 3 - Striker: \n");
    String combatant = scanner.nextLine();
    System.out.println("First fight:");
    switch (combatant) {
        case "1": Combatant player = new Standard(100, 5, false);
        case "2": Combatant player = new Guardian(100, 5, false);
        case "3": Combatant player = new Striker(100, 5, false);
        }
    
    
    boolean first_fight = Battle.main_battle(player, 30,"a", scanner, true);

    if (first_fight == true){
        System.out.println("Player status: HP-"+player.getHP()+" resources-"+player.getres()+" Attack-"+player.get_deal_damage());
        Battle.reward(player, scanner);
        System.out.println("Next round, second fight:");
        boolean second_fight = Battle.main_battle(player, 45,"b", scanner, false);

        if (second_fight == true){
            System.out.println("You win!");
    
        } 
    }
}
}






