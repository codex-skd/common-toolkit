package com.skd.commontoolkit.systems.wanderer;

import java.util.ArrayList;
import java.util.List;

import com.skd.commontoolkit.CommonToolkit;
import com.skd.commontoolkit.CommonToolkitConfig;
import com.skd.commontoolkit.dynreg.DynamicRegistry;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

/**
 * Allows loading wandering trader trades from json.
 */
@EventBusSubscriber(modid = CommonToolkit.MODID)
public class WandererTradesRegistry extends DynamicRegistry<WandererTrade> {

    public static final WandererTradesRegistry INSTANCE = new WandererTradesRegistry();

    protected final List<ItemListing> normTrades = new ArrayList<>();
    protected final List<ItemListing> rareTrades = new ArrayList<>();

    public WandererTradesRegistry() {
        super(CommonToolkit.LOGGER, "wanderer_trades", false, true);
    }

    @Override
    protected void registerBuiltinCodecs() {
        this.registerDefaultCodec(CommonToolkit.loc("basic_trade"), BasicWandererTrade.CODEC);
    }

    @Override
    protected void beginReload(ReloadType type) {
        super.beginReload(type);
        this.normTrades.clear();
        this.rareTrades.clear();
    }

    @Override
    protected void onReload(ReloadType type) {
        super.onReload(type);
        this.getValues().forEach(trade -> {
            if (trade.isRare()) {
                this.rareTrades.add(trade);
            }
            else {
                this.normTrades.add(trade);
            }
        });
    }

    @SubscribeEvent
    public static void replaceTrades(WandererTradesEvent e) {
        if (CommonToolkitConfig.clearWandererNormalTrades) {
            e.getGenericTrades().clear();
        }
        if (CommonToolkitConfig.clearWandererRareTrades) {
            e.getRareTrades().clear();
        }
        e.getGenericTrades().addAll(INSTANCE.normTrades);
        e.getRareTrades().addAll(INSTANCE.rareTrades);
    }

}
