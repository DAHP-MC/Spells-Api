package us.dahp.spellsapi.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sirNikolai
 * @since 05/10/2020
 */
public class SpellDescriptionTest {

    @Test
    public void shouldCreateAppropriateLore() {
        // Given
        SpellDescription description = new SpellDescription(
                "ABC-123",
                SpellType.CHARM,
                4,
                Long.MAX_VALUE,
                3,
                Arrays.asList("&1TEST1", "&2Test2"));

        // When
        List<String> generatedLore = description.generateLore();

        // Then
        assertEquals(8, generatedLore.size());
        assertEquals("\u00A7e(ABC-123)", generatedLore.get(0));
        assertEquals("\u00A77Type: \u00A78Charm", generatedLore.get(1));
        assertEquals("\u00A7cDamage: \u00A74\u2665\u2665\u2665\u2665", generatedLore.get(2));
        assertEquals("\u00A7dCooldown: \u00A75" + Long.MAX_VALUE, generatedLore.get(3));
        assertEquals("\u00A72Durability: \u00A7a3", generatedLore.get(4));
        assertEquals("", generatedLore.get(5));
        assertEquals("\u00A71TEST1", generatedLore.get(6));
        assertEquals("\u00A72Test2", generatedLore.get(7));
    }
}
