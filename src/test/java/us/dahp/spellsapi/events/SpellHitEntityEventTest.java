package us.dahp.spellsapi.events;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import be.seeseemelk.mockbukkit.entity.SimpleMobMock;
import org.junit.jupiter.api.Test;
import us.dahp.spellsapi.models.AbstractSpell;
import us.dahp.spellsapi.models.SpellType;
import us.dahp.spellsapi.utils.SpellUtils;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellHitEntityEventTest {

    @Test
    public void shouldPopulateFieldsCorrectly() {
        // Given
        ServerMock server = MockBukkit.getOrCreateMock();
        PlayerMock player = server.addPlayer("TEST PLAYER");
        SimpleMobMock entity1 = new SimpleMobMock(server, UUID.randomUUID());
        SimpleMobMock entity2 = new SimpleMobMock(server, UUID.randomUUID());

        AbstractSpell spell = SpellUtils.createBasicSpell("TEST SPELL", SpellType.SPELL);

        // When
        SpellHitEntityEvent event = new SpellHitEntityEvent(player, spell, Arrays.asList(entity1, entity2));

        // Then
        assertNotNull(event.getHandlers());
        assertNotNull(SpellCastEvent.getHandlerList());
        assertEquals(event.getPlayer().getName(), player.getName());
        assertEquals(event.getSpell().getName(), spell.getName());

        UUID[] entityUUIDs = event.getHitEntites().stream().map(e -> e.getUniqueId()).toArray(size -> new UUID[size]);

        assertArrayEquals(entityUUIDs, new UUID[]{entity1.getUniqueId(), entity2.getUniqueId()});
    }
}
