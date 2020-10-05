package us.dahp.spellsapi.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import us.dahp.spellsapi.models.AbstractSpell;
import us.dahp.spellsapi.models.AbstractSpellEffect;
import us.dahp.spellsapi.models.SpellDescription;
import us.dahp.spellsapi.models.SpellType;

import java.util.Collections;
import java.util.List;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellUtils {

    private SpellUtils() {}

    public static AbstractSpell createBasicSpell(String spellName, SpellType type) {
        return new AbstractSpell(
                spellName,
                type,
                new AbstractSpellEffect() {
                    @Override
                    public void renderTrail(Location startLocation, Location endLocation, long period) { }

                    @Override
                    public void renderEnd(Location startLocation, Location endLocation) { }
                },
                createBasicDescription(spellName, type),
                Collections.emptyList(),
                0,
                0,
                0L) {
            @Override
            public void impactEntities(Player caster, float multiplier, List<LivingEntity> entities) { }

            @Override
            public void impactBlock(Player caster, float multiplier, Block block) { }
        };
    }

    public static SpellDescription createBasicDescription(String pronounciation, SpellType spellType) {
        return new SpellDescription(
                pronounciation,
                spellType,
                0,
                0,
                0,
                Collections.emptyList());
    }
}
