package com.skd.commontoolkit.mixin.client;

import org.spongepowered.asm.mixin.Mixin;

import com.skd.commontoolkit.util.DrawsOnLeft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

@Mixin(value = AbstractContainerScreen.class, remap = false)
public class AbstractContainerScreenMixin implements DrawsOnLeft {

}
