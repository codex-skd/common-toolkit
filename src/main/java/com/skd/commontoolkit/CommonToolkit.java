package com.skd.commontoolkit;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skd.commontoolkit.color.GradientColor;
import com.skd.commontoolkit.commands.CommonToolkitCommand;
import com.skd.commontoolkit.datagen.FieldOrderingFactory;
import com.skd.commontoolkit.datagen.RegisterFieldOrderingsEvent;
import com.skd.commontoolkit.dynreg.DynRegPayloads;
import com.skd.commontoolkit.dynreg.TagSyncPayload;
import com.skd.commontoolkit.dynreg.tag.DynamicTagManager;
import com.skd.commontoolkit.events.ResourceReloadEvent;
import com.skd.commontoolkit.network.PayloadHelper;
import com.skd.commontoolkit.payloads.ButtonClickPayload;
import com.skd.commontoolkit.systems.gear.GearSetRegistry;
import com.skd.commontoolkit.systems.mixes.MixRegistry;
import com.skd.commontoolkit.tabs.TabFillingRegistry;
import com.skd.commontoolkit.util.CommonToolkitUtil;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@Mod(CommonToolkit.MODID)
@SuppressWarnings("deprecation")
public class CommonToolkit {

    public static final String MODID = "common_toolkit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public CommonToolkit(IEventBus bus) {
        bus.register(this);
        NeoForge.EVENT_BUS.addListener(this::registerCommands);
        NeoForge.EVENT_BUS.addListener(this::serverReload);
        NeoForge.EVENT_BUS.addListener(this::serverStart);
        TextColor.NAMED_COLORS = new HashMap<>(TextColor.NAMED_COLORS);
        bus.addListener(TabFillingRegistry::fillTabs);
        bus.register(new PayloadHelper());
        CommonToolkitConfig.load();
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent e) {
        PayloadHelper.registerPayload(new ButtonClickPayload.Provider());
        PayloadHelper.registerPayload(new DynRegPayloads.Start.Provider());
        PayloadHelper.registerPayload(new DynRegPayloads.Content.Provider<>());
        PayloadHelper.registerPayload(new DynRegPayloads.End.Provider());
        PayloadHelper.registerPayload(new TagSyncPayload.Provider());
        e.enqueueWork(() -> {
            CommonToolkitUtil.registerCustomColor(GradientColor.RAINBOW);
        });
        GearSetRegistry.INSTANCE.registerToBus();
        MixRegistry.INSTANCE.registerToBus();
    }

    @SubscribeEvent
    public void registerFieldOrderings(RegisterFieldOrderingsEvent e) {
        e.register(FieldOrderingFactory.forType(MixRegistry.INSTANCE.getId(), b -> b.put("mix_type", 0)));
    }

    public void registerCommands(RegisterCommandsEvent e) {
        CommonToolkitCommand.register(e.getDispatcher(), e.getBuildContext());
    }

    public void serverReload(AddServerReloadListenersEvent e) {
        e.addListener(loc("common_toolkit_reload_event"), (ResourceManagerReloadListener) res -> NeoForge.EVENT_BUS.post(new ResourceReloadEvent(res, LogicalSide.SERVER)));
        e.addListener(DynamicTagManager.ID, DynamicTagManager.INSTANCE);
    }

    public void serverStart(ServerAboutToStartEvent e) {
        MixRegistry.applyMixes();
    }

    public static Identifier loc(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

}
