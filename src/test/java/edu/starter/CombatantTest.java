package edu.starter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CombatantTest {
    @Test
    void T01_NewStandardHasCorrectStats() {
        // Arrange
        Combatant unit = new Standard("player", 100, 5);

        // Act

        // Assert
        assertEquals(100, unit.getHP());
        assertEquals(10, unit.get_deal_damage());
        assertEquals(5, unit.blockAmount());
    }

    @Test
    void T02_NewGuardianHasCorrectStats() {
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act

        // Assert
        assertEquals(130, unit.getHP());
        assertEquals(8, unit.get_deal_damage());
        assertEquals(7, unit.blockAmount());
    }

    @Test
    void T03_NewStrikerHasCorrectStats() {
        // Arrange
        Combatant unit = new Striker("player",5);

        // Act

        // Assert
        assertEquals(80, unit.getHP());
        assertEquals(12, unit.get_deal_damage());
        assertEquals(5, unit.blockAmount());
    }

    @Test
    void   T04_GuardianDefenseBlocksSeven(){
        // Arrange
        Combatant unit = new Guardian("player",5);

        // Act
        unit.defend();
        unit.damage(10);

        // Assert: 130 - (10 - 7) = 127
        assertEquals(127, unit.getHP());
    }

    @Test
    void T05_StrikerDefenseBlocksFive(){
        // Arrange
        Combatant unit = new Striker("player",5);

        // Act
        unit.defend();
        unit.damage(10);

        // Assert: 80 - (10 - 5) = 75
        assertEquals(75, unit.getHP());
    }
}