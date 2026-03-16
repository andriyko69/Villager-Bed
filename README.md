# Villager Bed

Villager Bed adds a special bed that generates in villages and can only be used by villagers.

Players cannot sleep in these beds, preventing early-game players from claiming village beds while keeping normal villager behavior intact.

## Features

- **Villager-only beds**  
  Players cannot sleep in Villager Beds.

- **Village generation replacement**  
  Beds generated in villages are replaced with Villager Beds.

- **Villagers behave normally**  
  Villagers still claim the bed as their home and sleep in it normally.

- **Configurable behavior**  
  You can control which beds are replaced in structures.

## Configuration

`villagerbed-common.toml`

`bedReplacementMode`

- `VANILLA_ONLY` – replace only vanilla beds (default)
- `ALL_BEDS` – replace any bed block found in structures
- `NONE` – disable structure replacement

## Compatibility

By default the mod only replaces **vanilla beds**, leaving beds added by other mods untouched.