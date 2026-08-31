package com.skd.commontoolkit.dynreg;

import java.util.HashMap;
import java.util.IdentityHashMap;

import com.google.common.collect.BiMap;

import com.skd.commontoolkit.util.AbstractBiMap;
import net.minecraft.resources.ResourceLocation;

public class DynRegBiMap<R> extends AbstractBiMap<ResourceLocation, R> {

    public DynRegBiMap() {
        super(new HashMap<>(), new IdentityHashMap<>());
    }
}
