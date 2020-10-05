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
TODO: this

## Created Spells
| Spell Name | Spell Type | Description | Creator |
| ---------- | ---------- | ----------- | ------- |
| Stupefy    | Charm       | Does small damage to a target player. Chance of confusion and slowness. | [Nik](https://github.com/sirNikolai) |