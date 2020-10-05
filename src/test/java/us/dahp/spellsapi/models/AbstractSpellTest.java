package us.dahp.spellsapi.models;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class AbstractSpellTest {

    @Test
    public void shouldFilterStrings() {
        // Given
        // When
        AbstractSpell spell = new AbstractSpell(
                "&1Test &2Spell",
                SpellType.SPELL,
                null,
                Arrays.asList("&3Line 1", "&4Line 2"),
                Collections.emptyList(),
                1,
                2,
                3) {
            @Override
            public void impact(Player caster, float multiplier, List<LivingEntity> entities) { }
        };

        // Then
        assertEquals("\u00A71Test \u00A72Spell", spell.getName());
        assertArrayEquals(new String[] { "\u00A73Line 1", "\u00A74Line 2" }, spell.getDescription().toArray(new String[0]));
    }

    @Test
    public void shouldAssignValuesProperly() {
        // Given
        // When
        AbstractSpell spell = new AbstractSpell(
                "Test Spell",
                SpellType.SPELL,
                new AbstractSpellEffect() {
                    @Override
                    public void renderTrail(Location startLocation, Location endLocation, long period) { }

                    @Override
                    public void renderEnd(Location startLocation, Location endLocation) { }
                },
                Arrays.asList("Line 1", "Line 2"),
                Collections.singletonList("ABC 123"),
                1,
                2,
                Long.MAX_VALUE) {
            @Override
            public void impact(Player caster, float multiplier, List<LivingEntity> entities) { }
        };

        // Then
        assertEquals("Test Spell", spell.getName());
        assertArrayEquals(new String[] { "Line 1", "Line 2" }, spell.getDescription().toArray(new String[0]));
        assertArrayEquals(new String[] { "ABC 123" }, spell.getCommands().toArray(new String[0]));
        assertEquals(SpellType.SPELL, spell.getType());
        assertNotNull(spell.getSpellEffect());
        assertEquals(1, spell.getDurability());
        assertEquals(Long.MAX_VALUE, spell.getCastTime());
        assertEquals(2, spell.getMaxAffectedEntities());
    }
}
