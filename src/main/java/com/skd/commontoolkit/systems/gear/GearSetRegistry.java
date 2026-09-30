package com.skd.commontoolkit.systems.gear;

import java.util.List;
import java.util.function.Predicate;

import org.jetbrains.annotations.Nullable;

import com.skd.commontoolkit.CommonToolkit;
import com.skd.commontoolkit.dynreg.RegistrySerializer;
import com.skd.commontoolkit.dynreg.WeightedDynamicRegistry;
import com.skd.commontoolkit.dynreg.tag.DynamicHolderSet;
import com.skd.commontoolkit.systems.gear.GearSet.SetPredicate;
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

    /**
     * Returns a random weighted gear set matching at least one of the given {@link SetPredicate}s
     * (predicates are logically OR'd), recalculating weights based on luck.
     * <p>
     * If {@code predicates} is null or empty, falls back to {@link #getRandomItem(RandomSource, float)}.
     * This overload mirrors the upstream Placebo API where boss/invader data stores gear sets as a
     * {@code List<SetPredicate>} (entries such as {@code "#my_mod:my_tag"} or a plain set id).
     */
    @Nullable
    public GearSet getRandomSet(RandomSource rand, float luck, @Nullable List<SetPredicate> predicates) {
        if (predicates == null || predicates.isEmpty()) {
            return this.getRandomItem(rand, luck);
        }
        Predicate<GearSet> anyMatch = set -> predicates.stream().anyMatch(p -> p.test(set));
        return this.getRandomItem(rand, luck, anyMatch);
    }

}
