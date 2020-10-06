# DA Spells API

## Badges
| License | Javadoc |
| ------- | ------- |
| [![License](https://img.shields.io/github/license/DAHP-MC/Spells-Api)](LICENSE)| [![Javadocs](https://img.shields.io/badge/Javadocs-0.0.1.SNAPSHOT-orange.svg)](https://dahp-mc.github.io/Spells-Api/index.html) |

## Brief
This project contains everything needed to create spells and listen to spell events in DA Spells.

## Events 
| Event Name | Description | Is Cancellable | Other Notes |
| ---------- | ----------- | -------------- | ----------- |
| SpellSelectionSwitchEvent | Called when a player changes their selected spell | false | |
| SpellCastEvent | Called when a spell is cast | true | |
| SpellPostCastEvent | Called after spell is cast and durability and timer taken into account. | false | |
| SpellHitBlockEvent | Called when a spell hits a block. | true | Block will be _null_ if spell hits entity. |
| SpellHitEntityEvent | Called when a spell hits an entity. | true | Entities will be null if it hits a block. Spell may impact more than one entity. |
| SpellLearnEvent | When a player learns a new spell | true | |
| SpellLevelUpEvent | When a player's spell levels up | false | |

## Example Usage
Using [Stupefy](https://github.com/DAHP-MC/Spells-Api/blob/master/src/main/java/us/dahp/spellsapi/spells/Stupefy.java) as an example.
When creating a spell the class or sub package must be located in `us.dahp.spellsapi.spells` package.

### Super Class
It should extend the appropriate Spell abstraction (`AbstractSpell`, `AbstractSelfSpell`, `AbstractSurroundingSpell`):
```java
public class Stupefy extends AbstractSpell {
    // ...
}
```

### Constructor
Constructors should be parameterless or contain `JavaPlugin` if needing a main class instance.
Majority of the parameters that need to be provided are self explanatory or explained in the [Javadocs](https://dahp-mc.github.io/Spells-Api/index.html).

#### Spell Description
[SpellDescription](https://github.com/DAHP-MC/Spells-Api/blob/master/src/main/java/us/dahp/spellsapi/models/SpellDiscussion.java) is just a standardized method for easier importing on our part.
Again this is very much self explanatory and not much has to be worried about other than creating it.
 
#### Spell Effect
This is also an abstract class which has two methods.

The trail renders every tick (the *x*th tick is denoted in the period variable) and here only sound and particle events should be provided.
End location here is just the current location where the spell is. Period should be used for some modifiers (for example if using sin or cos for effect)
```java
    @Override
    public void renderTrail(Location startLocation, Location endLocation, long period) { }
```

End will render when the spell reaches end of life. This is either when the timer runs out, spell hits a block, or hits an entity.
Similar to above, this should only contain sounds and particles.
```java
    @Override
    public void renderEnd(Location startLocation, Location endLocation) { }
```
### Override Methods
You will need to fill in two methods `impactEntities` and `impactBlock` (only for `AbstractSpell`).
```java
    @Override
    public void impactBlock(Player caster, float multiplier, Block targetBlock) { }
```

```java
    @Override
    public void impactEntities(Player caster, float multiplier, List<LivingEntity> entities) { }
```

Many spells, even if regular ones, will not affect blocks so that method can be left blank.
Note that if `SpellHitEntityEvent` or `SpellHitBlockEvent` are cancelled then these methods will not execute.

### Unit Tests
All spells should come accompanied with unit tests for as many case scenarios as possible. For example, [stupefy tests](https://github.com/DAHP-MC/Spells-Api/blob/master/src/test/java/us/dahp/spellsapi/spells/StupefyTest.java) for the following:

 - Damaging a target entity with varying multipliers
 - Damaging a target entity with capped damage
 - Potion effects
 
### Utilising Events
If you want to use events (such as spell events or Bukkit events), you can provide them in a different file, or the same as the spell.
**You must** register the listener though in the constructor for the spell, this would mean providing a JavaPlugin variable in the constructor.
For example, if Stupefy used events (and was the listener class) it would have this constructor:
```java
public Stupefy(JavaPlugin plugin) {
    // ...
    Bukkit.getPluginManager().registerEvents(this, plugin);
}
```

## Created Spells
| Spell Name | Spell Type | Description | Creator |
| ---------- | ---------- | ----------- | ------- |
| Stupefy    | Charm       | Does small damage to a target player. Chance of confusion and slowness. | [Nik](https://github.com/sirNikolai) |