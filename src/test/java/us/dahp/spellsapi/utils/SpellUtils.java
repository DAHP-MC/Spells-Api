package us.dahp.spellsapi.utils;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import us.dahp.spellsapi.models.AbstractSpell;
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
                "TEST SPELL",
                SpellType.SPELL,
                Collections.emptyList(),
                Collections.emptyList(),
                0,
                0,
                0L) {
            @Override
            public void impact(Player caster, float multiplier, List<LivingEntity> entities) {
                return;
            }
        };
    }
}
