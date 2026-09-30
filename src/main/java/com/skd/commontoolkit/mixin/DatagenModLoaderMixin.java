package com.skd.commontoolkit.mixin;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.skd.commontoolkit.datagen.FieldOrderingFactory;
import net.neoforged.neoforge.data.loading.DatagenModLoader;

/**
 * Captures the datagen output root so {@link FieldOrderingFactory.Impl#getPackRoot()} can strip it
 * from absolute write paths before they are decomposed by
 * {@link com.skd.commontoolkit.datagen.FilteredOrderingFactory.ParsedPath#parse}.
 * <p>
 * If we don't do this, we can't really identify the components of the path being written. We'd run into problems if someone had their mod source in
 * /home/data/...
 */
@Mixin(value = DatagenModLoader.class, remap = false)
public class DatagenModLoaderMixin {

    @Inject(method = "begin", at = @At("HEAD"), require = 1)
    private static void commontoolkit$capturePackRoot(Set<String> mods, Path path, Collection<Path> inputs, Collection<Path> existingPacks,
        Set<String> existingMods, boolean serverGenerators, boolean clientGenerators, boolean devToolGenerators, boolean reportsGenerator,
        boolean structureValidator, boolean flat, String assetIndex, File assetsDir, CallbackInfo ci) {
        FieldOrderingFactory.Impl.setPackRoot(path);
    }

}
