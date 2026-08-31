package com.skd.commontoolkit.dynreg.tag;

import java.util.List;
import java.util.Map;

import com.skd.commontoolkit.dynreg.tag.TagLoader.EntryWithSource;
import net.minecraft.resources.ResourceLocation;

/**
 * Pairs a {@link TagLoader} with its scan output so the apply phase of
 * {@link DynamicTagManager} can run resolution against the now-populated registry content.
 * <p>
 * Top-level rather than nested in {@link DynamicTagManager} because Java forbids referencing a nested type
 * from its enclosing class's supertype declaration.
 */
record ScannedTags<R>(TagLoader<R> loader, Map<ResourceLocation, List<EntryWithSource>> raw) {

    Map<ResourceLocation, List<ResourceLocation>> resolve() {
        return this.loader.resolve(this.raw);
    }
}
