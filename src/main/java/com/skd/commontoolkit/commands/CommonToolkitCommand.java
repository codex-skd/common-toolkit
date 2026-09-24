package com.skd.commontoolkit.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommonToolkitCommand {

    public static void register(CommandDispatcher<CommandSourceStack> pDispatcher, CommandBuildContext ctx) {
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal("common_toolkit");
        SerializeLootTableCommand.register(builder);
        HandToJsonCommand.register(builder);
        GetDimensionTypeCommand.register(builder);
        pDispatcher.register(builder);
    }

}
