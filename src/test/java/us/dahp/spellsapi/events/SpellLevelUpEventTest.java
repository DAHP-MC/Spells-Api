package us.dahp.spellsapi.events;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.junit.jupiter.api.Test;
import us.dahp.spellsapi.models.AbstractSpell;
import us.dahp.spellsapi.models.SpellType;
import us.dahp.spellsapi.utils.ServerMockUtils;
import us.dahp.spellsapi.utils.SpellUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellLevelUpEventTest {

    @Test
    public void shouldPopulateFieldsCorrectly() {
        // Given
        ServerMock server = ServerMockUtils.getServerMockSafe();
        PlayerMock player = server.addPlayer("TEST PLAYER");
        AbstractSpell spell = SpellUtils.createBasicSpell("TEST SPELL", SpellType.SPELL);

        // When
        SpellLevelUpEvent event = new SpellLevelUpEvent(player, spell, 500);

        // Then
        assertNotNull(event.getHandlers());
        assertNotNull(SpellCastEvent.getHandlerList());
        assertEquals(event.getPlayer().getName(), player.getName());
        assertEquals(event.getSpell().getName(), spell.getName());
        assertEquals(500, event.getNewLevel());
    }
}
