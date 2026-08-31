package com.skd.commontoolkit;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.skd.commontoolkit.color.GradientColor;
import com.skd.commontoolkit.commands.CommonToolkitCommand;
import com.skd.commontoolkit.events.ResourceReloadEvent;
import com.skd.commontoolkit.loot.StackLootEntry;
import com.skd.commontoolkit.network.PayloadHelper;
import com.skd.commontoolkit.payloads.ButtonClickPayload;
import com.skd.commontoolkit.dynreg.ReloadListenerPayloads;
import com.skd.commontoolkit.systems.gear.GearSetRegistry;
import com.skd.commontoolkit.systems.mixes.MixRegistry;
import com.skd.commontoolkit.systems.wanderer.WandererTradesRegistry;
import com.skd.commontoolkit.tabs.TabFillingRegistry;
import com.skd.commontoolkit.util.CommonToolkitUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CommonToolkit.MODID)
@SuppressWarnings("deprecation")
public class CommonToolkit {

    public static final String MODID = "common_toolkit";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public CommonToolkit(IEventBus bus) {
        bus.register(this);
        NeoForge.EVENT_BUS.addListener(this::registerCommands);
        NeoForge.EVENT_BUS.addListener(this::serverReload);
        NeoForge.EVENT_BUS.addListener(this::serverStart);
        TextColor.NAMED_COLORS = new HashMap<>(TextColor.NAMED_COLORS);
        bus.addListener(TabFillingRegistry::fillTabs);
        bus.register(new PayloadHelper());
        NeoForge.EVENT_BUS.start(); // Startup the Neo bus as an experiment to see what kinds of things this breaks. We may do this in Neo at some point.
        CommonToolkitConfig.load();
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent e) {
        PayloadHelper.registerPayload(new ButtonClickPayload.Provider());
        PayloadHelper.registerPayload(new ReloadListenerPayloads.Start.Provider());
        PayloadHelper.registerPayload(new ReloadListenerPayloads.Content.Provider<>());
        PayloadHelper.registerPayload(new ReloadListenerPayloads.End.Provider());
        e.enqueueWork(() -> {
            CommonToolkitUtil.registerCustomColor(GradientColor.RAINBOW);
        });
        GearSetRegistry.INSTANCE.registerToBus();
        WandererTradesRegistry.INSTANCE.registerToBus();
        MixRegistry.INSTANCE.registerToBus();
    }

    @SubscribeEvent
    public void register(RegisterEvent e) {
        e.register(Registries.LOOT_POOL_ENTRY_TYPE, helper -> {
            helper.register(loc("stack_entry"), StackLootEntry.TYPE);
        });
    }

    public void registerCommands(RegisterCommandsEvent e) {
        CommonToolkitCommand.register(e.getDispatcher(), e.getBuildContext());
    }

    public void serverReload(AddReloadListenerEvent e) {
        e.addListener((ResourceManagerReloadListener) res -> NeoForge.EVENT_BUS.post(new ResourceReloadEvent(res, LogicalSide.SERVER)));
    }

    public void serverStart(ServerAboutToStartEvent e) {
        MixRegistry.applyMixes();
    }

    public static ResourceLocation loc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

}
