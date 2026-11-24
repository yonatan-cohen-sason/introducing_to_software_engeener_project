package edu.starter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

class CombatantTest {
    @Test
    void t01_freshStandardHasCorrectStats() {
        // Arrange
        Combatant unit = new Standard("player", 100, 5);

        // Act

        // Assert
        assertEquals(100, unit.getHP());
        assertEquals(10, unit.get_deal_damage());
        assertEquals(5, unit.blockAmount());
    }

    @Test
    void t02_freshGuardianHasCorrectStats() {
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act

        // Assert
        assertEquals(130, unit.getHP());
        assertEquals(8, unit.get_deal_damage());
        assertEquals(7, unit.blockAmount());
    }

    @Test
    void t03_freshStrikerHasCorrectStats() {
        // Arrange
        Combatant unit = new Striker("player",5);

        // Act

        // Assert
        assertEquals(80, unit.getHP());
        assertEquals(12, unit.get_deal_damage());
        assertEquals(5, unit.blockAmount());
    }

    @Test
    void   t04_guardianDefenseBlocksSeven(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.defend();
        unit.damage(10);

        // Assert: 130 - (10 - 7) = 127
        assertEquals(127, unit.getHP());
    }

    @Test
    void t05_strikerDefenseBlocksFive(){
        // Arrange
        Combatant unit = new Striker("player",5);

        // Act
        unit.defend();
        unit.damage(10);

        // Assert: 80 - (10 - 5) = 75
        assertEquals(75, unit.getHP());
    }

    @Test
    void t06_guardianHpNeverNegative(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.damage(200);

        // Assert: Math.max(130 - 200, 0) = 0
        assertEquals(0, unit.getHP());
    }

    @Test
    void t07_strikerHealCappedAtMaxHp(){
        // Arrange
        Combatant unit = new Striker("player",5);

        // Act
        unit.damage(10);
        unit.gain_health(25);

        // Assert: Math.min(80 - 10 + 25, 80) = 80
        assertEquals(80, unit.getHP());
    }

    @Test
    void t08_guardianPowerRewardAddsTwo(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.change_deal_damage(2);

        // Assert: 8 + 2 = 10
        assertEquals(10, unit.get_deal_damage());
    }

    @Test
    void t10_rejectedSpecialDoesNotCostATurn(){
        // Arrange
        Combatant player = new Standard("player", 100, 5);
        Scanner input = new Scanner("3\n3\n1\n1\n");

        // Act
        boolean won = Battle.main_battle(player, 30, "a", input, true);

        // Assert: Special -> enemy 15, player 90, res 2
        //         Special rejected (res 2 < 3) -> no counterattack, player 90
        //         Attack  -> enemy 5,  player 80
        //         Attack  -> enemy 0,  no counterattack
        //         (if the rejected Special cost a turn, HP would be 70)
        assertTrue(won);
        assertEquals(80, player.getHP());
        assertEquals(2, player.getres());
    }

    @Test
    void t13_powerBonusCarriesIntoSecondEncounter(){
        // Arrange
        Combatant player = new Standard("player", 100, 5);
        Battle.main_battle(player, 30, "a", new Scanner("3\n1\n1\n"), true);
        player.change_deal_damage(2);

        // Act
        boolean won = Battle.main_battle(player, 45, "b", new Scanner("1\n1\n1\n1\n"), false);

        // Assert: attack 10 + 2 = 12, enemy 45 -> 33 -> 21 -> 9 -> 0
        //         3 counterattacks of 10: 80 - 30 = 50
        //         (with attack 10, four attacks would not be enough)
        assertTrue(won);
        assertEquals(50, player.getHP());
        assertEquals(12, player.get_deal_damage());
    }


 // boundary tests

    @Test
    void b1_guardianHitOneLessThanHpLeavesOne(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.damage(129);

        // Assert: 130 - 129 = 1
        assertEquals(1, unit.getHP());
    }

    @Test
    void b2_guardianHitExactlyHpLeavesZero(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.damage(130);

        // Assert: 130 - 130 = 0
        assertEquals(0, unit.getHP());
    }

    @Test
    void b3_specialWithExactlyThreeResourceSucceeds(){
        // Arrange
        Combatant player = new Standard("player", 100, 3);
        Combatant enemy = new Standard("enemy", 30);

        // Act
        boolean used = player.special(enemy);

        // Assert: resource 3 - 3 = 0, enemy 30 - 15 = 15
        assertTrue(used);
        assertEquals(0, player.getres());
        assertEquals(15, enemy.getHP());
    }

    @Test
    void b4_guardianBlocksHitSmallerThanBlockAmount(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.defend();
        unit.damage(5);

        // Assert: Math.max(5 - 7, 0) = 0 damage, 130 - 0 = 130
        assertEquals(130, unit.getHP());
    }
}
