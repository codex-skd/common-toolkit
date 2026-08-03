package com.skd.commontoolkit.screen;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public abstract class CommonToolkitContainerScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> implements MenuAccess<T> {

    public CommonToolkitContainerScreen(T menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    public CommonToolkitContainerScreen(T menu, Inventory inv, Component title, int imageWidth, int imageHeight) {
        super(menu, inv, title, imageWidth, imageHeight);
    }

}
