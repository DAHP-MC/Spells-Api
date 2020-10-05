package us.dahp.spellsapi.events;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.junit.jupiter.api.Test;
import us.dahp.spellsapi.models.AbstractSpell;
import us.dahp.spellsapi.models.SpellType;
import us.dahp.spellsapi.utils.SpellUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellSelectionSwitchEventTest {

    @Test
    public void shouldPopulateFieldsCorrectly() {
        // Given
        ServerMock server = MockBukkit.getOrCreateMock();
        PlayerMock player = server.addPlayer("TEST PLAYER");
        AbstractSpell spell = SpellUtils.createBasicSpell("TEST SPELL", SpellType.SPELL);

        // When
        SpellSelectionSwitchEvent event = new SpellSelectionSwitchEvent(player, spell);

        // Then
        assertNotNull(event.getHandlers());
        assertNotNull(SpellCastEvent.getHandlerList());
        assertEquals(event.getPlayer().getName(), player.getName());
        assertEquals(event.getSpell().getName(), spell.getName());
    }
}
