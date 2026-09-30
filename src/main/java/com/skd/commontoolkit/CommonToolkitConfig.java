package com.skd.commontoolkit;

import com.skd.commontoolkit.config.Configuration;

public class CommonToolkitConfig {

    public static boolean clearWandererNormalTrades;
    public static boolean clearWandererRareTrades;

    public static void load() {
        Configuration cfg = new Configuration(CommonToolkit.MODID);
        cfg.setTitle("CommonToolkit Config");

        clearWandererNormalTrades = cfg.getBoolean("Clear Generic Trades", "wandering_trader", false, "If the generic trade list will be cleared before datapack loaded trades are added.\nServer-authoritative.");
        clearWandererRareTrades = cfg.getBoolean("Clear Rare Trades", "wandering_trader", false, "If the rare trade list will be cleared before datapack loaded trades are added.\nServer-authoritative.");

        if (cfg.hasChanged()) {
            cfg.save();
        }
    }

}
