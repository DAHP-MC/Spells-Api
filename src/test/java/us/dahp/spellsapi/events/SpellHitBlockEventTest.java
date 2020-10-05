package us.dahp.spellsapi.events;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.WorldMock;
import be.seeseemelk.mockbukkit.block.BlockMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.Location;
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
public class SpellHitBlockEventTest {

    @Test
    public void shouldPopulateFieldsCorrectly() {
        // Given
        ServerMock server = ServerMockUtils.getServerMockSafe();
        PlayerMock player = server.addPlayer("TEST PLAYER");
        BlockMock block = new BlockMock(new Location(new WorldMock(), 0,0,0));

        AbstractSpell spell = SpellUtils.createBasicSpell("TEST SPELL", SpellType.SPELL);

        // When
        SpellHitBlockEvent event = new SpellHitBlockEvent(player, spell, block);

        // Then
        assertNotNull(event.getHandlers());
        assertNotNull(SpellCastEvent.getHandlerList());
        assertEquals(event.getPlayer().getName(), player.getName());
        assertEquals(event.getSpell().getName(), spell.getName());
        assertNotNull(event.getHitBlock());
    }
}
