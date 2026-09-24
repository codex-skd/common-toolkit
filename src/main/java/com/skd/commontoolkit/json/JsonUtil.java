package com.skd.commontoolkit.json;

import org.slf4j.Logger;

import com.google.gson.JsonElement;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.conditions.ConditionalOps;
import net.neoforged.neoforge.common.conditions.ICondition;

public class JsonUtil {

    public static boolean checkAndLogEmpty(JsonElement e, ResourceLocation key, ResourceLocation registryId, Logger logger) {
        String s = e.toString();
        if (s.isEmpty() || "{}".equals(s)) {
            logger.error("Ignoring {} item with id {} as it is empty.  Please switch to a condition-false json instead of an empty one.", registryId, key);
            return false;
        }
        return true;
    }

    public static boolean checkConditions(JsonElement e, ResourceLocation key, ResourceLocation registryId, Logger logger, ConditionalOps<JsonElement> ops) {
        if (ICondition.conditionsMatched(ops, e.getAsJsonObject())) {
            return true;
        }
        logger.trace("Skipping loading {} item with id {} as it's conditions were not met", registryId, key);
        return false;
    }
}
