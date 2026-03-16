package io.github.andriyko69.villagerbed.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class VillagerBedConfig {

    public enum BedReplacementMode {
        VANILLA_ONLY,
        ALL_BEDS,
        NONE
    }

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.EnumValue<BedReplacementMode> BED_REPLACEMENT_MODE;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("villager_beds");

        BED_REPLACEMENT_MODE = builder
                .comment(
                        "Controls which beds in village structures are replaced with Villager Beds.",
                        "VANILLA_ONLY = replace only vanilla beds",
                        "ALL_BEDS = replace any BedBlock",
                        "NONE = disable structure replacement"
                )
                .defineEnum("bedReplacementMode", BedReplacementMode.VANILLA_ONLY);

        builder.pop();

        SPEC = builder.build();
    }

    private VillagerBedConfig() {
    }
}