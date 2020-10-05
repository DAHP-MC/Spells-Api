package us.dahp.spellsapi.models;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * General spell class. This should be extended when creating a standard spell that casts at a target.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public abstract class AbstractSpell {

    private final String name;
    private final SpellType type;

    private final AbstractSpellEffect spellEffect;

    private final List<String> description;
    private final List<String> commands;

    private final int durability;
    private final int maxAffectedEntities;

    private final long castTime;

    public AbstractSpell(
            String name,
            SpellType type,
            AbstractSpellEffect spellEffect,
            List<String> description,
            List<String> commands,
            int durability,
            int maxAffectedEntities,
            long castTime) {
        this.name = ChatColor.translateAlternateColorCodes('&', name);
        this.type = type;
        this.spellEffect = spellEffect;
        this.description = description.stream().map(s -> ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toList());
        this.commands = commands;
        this.durability = durability;
        this.maxAffectedEntities = maxAffectedEntities;
        this.castTime = castTime;
    }

    /**
     * Called when spell hits entities.
     * Entities will never be null but may be an empty list if no one hit.
     *
     * @param caster     Player who cast the spell.
     * @param multiplier The spell multiplier.
     * @param entities   Entities affected by spell.
     */
    public abstract void impact(Player caster, float multiplier, List<LivingEntity> entities);

    /**
     * Gets name of spell.
     *
     * @return Name of spell.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets type of spell.
     *
     * @return Type of spell.
     */
    public SpellType getType() {
        return type;
    }

    /**
     * Gets the description of the spell.
     *
     * @return Spell description.
     */
    public List<String> getDescription() {
        return Collections.unmodifiableList(description);
    }

    /**
     * Gets the commands that will be run by the server on the player.
     * Order is not specified.
     *
     * @return Gets list of commands to be run.
     */
    public List<String> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    /**
     * Get the durability cost for given spell.
     *
     * @return Durability for spell.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Get the maximum amount of entities that can be affected by the spell.
     *
     * @return Number of entities that can be affected.
     */
    public int getMaxAffectedEntities() {
        return maxAffectedEntities;
    }

    /**
     * Get the cooldown (in seconds) that the spell has after casting.
     *
     * @return Cooldown (in seconds) for the spell.
     */
    public long getCastTime() {
        return castTime;
    }

    /**
     * Retrieves the spell effect for given spell.
     *
     * @return Spell effect that the plugin calls.
     */
    public AbstractSpellEffect getSpellEffect() {
        return spellEffect;
    }
}
