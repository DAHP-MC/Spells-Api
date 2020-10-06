package us.dahp.spellsapi.models;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * General spell class. This should be extended when creating a standard spell that casts at a target.
 * When listing commands the following placeholders are allowed:
 * <ul>
 *     <li>&lt;caster&gt; - name of player who casted</li>
 *     <li>&lt;target&gt; - name of player(s) who is/are casted on</li>
 * </ul>
 * @author sirNikolai
 * @since 04/10/2020
 */
public abstract class AbstractSpell {

    private final String name;
    private final SpellType type;

    private final AbstractSpellEffect spellEffect;

    private final SpellDescription description;
    private final List<String> commands;

    private final int durability;
    private final int maxAffectedEntities;

    private final long castTime;

    public AbstractSpell(
            String name,
            SpellType type,
            AbstractSpellEffect spellEffect,
            SpellDescription description,
            List<String> commands,
            int durability,
            int maxAffectedEntities,
            long castTime) {
        this.name = ChatColor.translateAlternateColorCodes('&', name);
        this.type = type;
        this.spellEffect = spellEffect;
        this.description = description;
        this.commands = commands;
        this.durability = durability;
        this.maxAffectedEntities = maxAffectedEntities;
        this.castTime = castTime;
    }

    /**
     * Called when spell hits a block that is not transparent
     *
     * @param caster      Player who cast the spell
     * @param multiplier  the spell multiplier
     * @param targetBlock Block that was hit
     */
    public abstract void impactBlock(Player caster, float multiplier, Block targetBlock);

    /**
     * Called when spell hits entities.
     * Entities will never be null but may be an empty list if no one hit.
     *
     * @param caster     Player who cast the spell.
     * @param multiplier The spell multiplier.
     * @param entities   Entities affected by spell.
     */
    public abstract void impactEntities(Player caster, float multiplier, List<LivingEntity> entities);

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
    public SpellDescription getDescription() {
        return description;
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
