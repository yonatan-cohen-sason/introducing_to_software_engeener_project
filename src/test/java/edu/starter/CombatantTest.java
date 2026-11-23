package edu.starter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CombatantTest {

    @Test
    void guardianDefenseBlocksSeven() {
        // Arrange
        Combatant unit = new Guardian("player", 130, 5);

        // Act
        unit.defend();
        unit.damage(10);

        // Assert: 130 - (10 - 7) = 127
        assertEquals(127, unit.getHP());
    }
}