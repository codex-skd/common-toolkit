package com.skd.commontoolkit;

import org.jetbrains.annotations.Nullable;

import com.skd.commontoolkit.events.ResourceReloadEvent;
import com.skd.commontoolkit.util.SpecialTooltipItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = CommonToolkit.MODID)
public class CommonToolkitClient {

    public static long ticks = 0;
    private static int scrollIdx = 0;
    private static ItemStack currentTooltipItem = ItemStack.EMPTY;
    private static long tooltipTick = 0;

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent e) {
        NeoForge.EVENT_BUS.addListener(CommonToolkitClient::tick);
        NeoForge.EVENT_BUS.addListener(CommonToolkitClient::tooltip);
        NeoForge.EVENT_BUS.addListener(CommonToolkitClient::scroll);
        NeoForge.EVENT_BUS.addListener(CommonToolkitClient::scroll2);
    }


    @SubscribeEvent
    public static void clientResource(RegisterClientReloadListenersEvent e) {
        e.registerReloadListener((ResourceManagerReloadListener) res -> NeoForge.EVENT_BUS.post(new ResourceReloadEvent(res, LogicalSide.CLIENT)));
    }


    public static float getColorTicks() {
        return (ticks + Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(false)) / 0.5F;
    }

    @Nullable
    public static PotionBrewing getBrewingRegistry() {
        ClientLevel level = Minecraft.getInstance().level;
        return level == null ? null : level.potionBrewing();
    }

    public static int getTooltipScrollIndex() {
        return scrollIdx;
    }

    public static int getTooltipScrollIndex(int size) {
        return Math.floorMod(scrollIdx, size);
    }

    public static void tick(ClientTickEvent.Post e) {
        ticks++;
    }

    public static void scroll(ScreenEvent.MouseScrolled.Pre e) {
        if (currentTooltipItem.getItem() instanceof SpecialTooltipItem && tooltipTick == CommonToolkitClient.ticks && Screen.hasShiftDown()) {
            scrollIdx += e.getScrollDeltaY() < 0 ? 1 : -1;
            e.setCanceled(true);
        }
    }

    public static void scroll2(InputEvent.MouseScrollingEvent e) {
        if (currentTooltipItem.getItem() instanceof SpecialTooltipItem && tooltipTick == CommonToolkitClient.ticks && Screen.hasShiftDown()) {
            scrollIdx += e.getScrollDeltaY() < 0 ? 1 : -1;
            e.setCanceled(true);
        }
    }

    public static void tooltip(ItemTooltipEvent e) {
        currentTooltipItem = e.getItemStack();
        tooltipTick = CommonToolkitClient.ticks;
    }
}
