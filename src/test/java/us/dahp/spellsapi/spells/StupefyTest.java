package us.dahp.spellsapi.spells;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sirNikolai
 * @since 05/10/2020
 */
public class StupefyTest {

    private Player caster;
    private Player target;
    private ServerMock serverMock;
    private Stupefy subject;

    @BeforeEach
    public void setup() {
        serverMock = MockBukkit.getOrCreateMock();
        caster = serverMock.addPlayer("Caster");
        target = serverMock.addPlayer("Target");

        subject = new Stupefy();
    }

    @Test
    public void shouldProvideCorrectDamage() {
        // Given
        Player target2 = serverMock.addPlayer("Target2");

        // When
        subject.impactEntities(caster, 1, Collections.singletonList(target));
        subject.impactEntities(caster, 3, Collections.singletonList(target2));

        // Then
        assertEquals(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 3, target.getHealth());
        assertEquals(target2.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 5, target2.getHealth());
    }

    @Test
    public void shouldCapDamageToOneHeart() {
        // Given
        // When
        subject.impactEntities(caster, 500, Collections.singletonList(target));

        // Then
        assertEquals(1, target.getHealth());
    }

    @Test
    public void shouldSetEffect() {
        // Given
        //When
        for(int i = 0; i < 100; i++) {
            subject.impactEntities(caster, 1, Collections.singletonList(target));

            if(!target.getActivePotionEffects().isEmpty()) {
                break;
            }
        }

        // Then
        assertEquals(2, target.getActivePotionEffects().size());
        assertTrue(target
                .getActivePotionEffects()
                .stream()
                .map(p -> p.getType().getName()).collect(Collectors.toList())
                .containsAll(Arrays.asList(PotionEffectType.CONFUSION.getName(), PotionEffectType.SLOW.getName())));
    }
}
