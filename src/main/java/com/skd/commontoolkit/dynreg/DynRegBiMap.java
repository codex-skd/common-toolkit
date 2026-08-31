package com.skd.commontoolkit.dynreg;

import java.util.HashMap;
import java.util.IdentityHashMap;

import com.google.common.collect.BiMap;

import com.skd.commontoolkit.codec.CodecProvider;
import com.skd.commontoolkit.util.AbstractBiMap;
import net.minecraft.resources.ResourceLocation;

/**
 * An implementation of {@link BiMap} which uses a normal {@link HashMap} for the forward map, and
 * uses an {@link IdentityHashMap} for the inverse.
 * <p>
 * This preserves the structure that registry values should be compared by identity when retrieving their keys.
 */
public class DynRegBiMap<R extends CodecProvider<? super R>> extends AbstractBiMap<ResourceLocation, R> {

    public DynRegBiMap() {
        super(new HashMap<>(), new IdentityHashMap<>());
    }

}
