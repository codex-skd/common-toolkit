package com.skd.commontoolkit.systems.gear;

import org.jetbrains.annotations.Nullable;

import com.skd.commontoolkit.CommonToolkit;
import com.skd.commontoolkit.dynreg.RegistrySerializer;
import com.skd.commontoolkit.dynreg.WeightedDynamicRegistry;
import com.skd.commontoolkit.dynreg.tag.DynamicHolderSet;
import net.minecraft.util.RandomSource;

public class GearSetRegistry extends WeightedDynamicRegistry<GearSet> {

    public static final GearSetRegistry INSTANCE = new GearSetRegistry();

    public GearSetRegistry() {
        super(CommonToolkit.LOGGER, CommonToolkit.loc("gear_sets"), RegistrySerializer.simple(GearSet.CODEC));
    }

    /**
     * Returns a random weighted gear set drawn from the given holder set, recalculating weights based on luck.
     * <p>
     * If {@code filter} is null or empty, falls back to {@link #getRandomItem(RandomSource, float)}.
     */
    @Nullable
    public GearSet getRandomSet(RandomSource rand, float luck, @Nullable DynamicHolderSet<GearSet> filter) {
        if (filter == null || filter.size() == 0) {
            return this.getRandomItem(rand, luck);
        }
        return this.getRandomFromSet(filter, rand, luck);
    }

}
