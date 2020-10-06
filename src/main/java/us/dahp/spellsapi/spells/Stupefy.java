package us.dahp.spellsapi.spells;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import us.dahp.spellsapi.models.AbstractSpell;
import us.dahp.spellsapi.models.AbstractSpellEffect;
import us.dahp.spellsapi.models.SpellDescription;
import us.dahp.spellsapi.models.SpellType;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Basic charm. Does a small amount of damage and chance of slowness and confusion.
 * Chance of potion effects: 40%
 *
 * @author sirNikolai
 * @since 05/10/2020
 */
public class Stupefy extends AbstractSpell {
    public Stupefy() {
        super(
                "Stupefy",
                SpellType.CHARM,
                new AbstractSpellEffect() {
                    @Override
                    public void renderTrail(Location startLocation, Location endLocation, long period) {
                        endLocation.getWorld().spawnParticle(
                                Particle.SPELL_MOB,
                                endLocation.getX(),
                                endLocation.getY(),
                                endLocation.getZ(),
                                0,
                                0.99,
                                0.12,
                                0.12,
                                1);
                    }

                    @Override
                    public void renderEnd(Location startLocation, Location endLocation) {
                        endLocation.getWorld().spawnParticle(
                                Particle.REDSTONE,
                                endLocation.getX(),
                                endLocation.getY(),
                                endLocation.getZ(),
                                20,
                                0.5D,
                                0.5D,
                                0.5D,
                                0.0D);
                    }
                },
                new SpellDescription(
                        "STEW-puh-fye",
                        SpellType.CHARM,
                        3,
                        1,
                        1,
                        Collections.singletonList("Renders a victim unconscious temporarily.")),
                Collections.emptyList(),
                1,
                1,
                1L);
    }

    @Override
    public void impactBlock(Player caster, float multiplier, Block targetBlock) { }

    @Override
    public void impactEntities(Player caster, float multiplier, List<LivingEntity> entities) {
        for (LivingEntity e : entities) {
            e.damage(getFinalizedDamage(e, multiplier));

            if(ThreadLocalRandom.current().nextInt(5) > 2) {
                e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Math.round(5.0F * multiplier * 20.0F), 2));
                e.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Math.round(5.0F * multiplier * 20.0F), 2));
            }
        }
    }

    private double getFinalizedDamage(LivingEntity target, float multiplier) {
        return ((3.0F + multiplier) > target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue())
                ? (target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 1.0D)
                : (2.0F + multiplier);
    }
}
