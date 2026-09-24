package com.skd.commontoolkit.dynreg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.ApiStatus;

import com.skd.commontoolkit.CommonToolkit;
import com.skd.commontoolkit.network.PayloadProvider;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Sync payload for the resolved tag content of a single {@link DynamicRegistry}.
 * <p>
 * Sent server → client during the {@link net.neoforged.neoforge.event.OnDatapackSyncEvent} flow, after the registry's
 * {@code Content} packets but before the {@code End} packet. The client stages the resolved tag map; the {@code End}
 * payload's existing handler binds the staged tags into the registry alongside the staged content.
 */
public record TagSyncPayload(ResourceLocation id, Map<ResourceLocation, List<ResourceLocation>> tags) implements CustomPacketPayload {

    public static final Type<TagSyncPayload> TYPE = new Type<>(CommonToolkit.loc("reload_sync_tags"));

    public static final StreamCodec<RegistryFriendlyByteBuf, TagSyncPayload> CODEC = StreamCodec.of(TagSyncPayload::write, TagSyncPayload::read);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    private static void write(RegistryFriendlyByteBuf buf, TagSyncPayload payload) {
        buf.writeResourceLocation(payload.id);
        ByteBufCodecs.writeCount(buf, payload.tags.size(), Integer.MAX_VALUE);
        for (Map.Entry<ResourceLocation, List<ResourceLocation>> entry : payload.tags.entrySet()) {
            buf.writeResourceLocation(entry.getKey());
            ByteBufCodecs.writeCount(buf, entry.getValue().size(), Integer.MAX_VALUE);
            for (ResourceLocation id : entry.getValue()) {
                buf.writeResourceLocation(id);
            }
        }
    }

    private static TagSyncPayload read(RegistryFriendlyByteBuf buf) {
        ResourceLocation id = buf.readResourceLocation();
        int tagCount = ByteBufCodecs.readCount(buf, Integer.MAX_VALUE);
        Map<ResourceLocation, List<ResourceLocation>> tags = new HashMap<>(tagCount);
        for (int i = 0; i < tagCount; i++) {
            ResourceLocation tagId = buf.readResourceLocation();
            int entryCount = ByteBufCodecs.readCount(buf, Integer.MAX_VALUE);
            List<ResourceLocation> entries = new ArrayList<>(entryCount);
            for (int j = 0; j < entryCount; j++) {
                entries.add(buf.readResourceLocation());
            }
            tags.put(tagId, entries);
        }
        return new TagSyncPayload(id, tags);
    }

    @ApiStatus.Internal
    public static class Provider implements PayloadProvider<TagSyncPayload> {

        @Override
        public Type<TagSyncPayload> getType() {
            return TYPE;
        }

        @Override
        public StreamCodec<? super RegistryFriendlyByteBuf, TagSyncPayload> getCodec() {
            return CODEC;
        }

        @Override
        public void handle(TagSyncPayload msg, IPayloadContext ctx) {
            SyncManagement.acceptTags(msg.id, msg.tags);
        }

        @Override
        public List<ConnectionProtocol> getSupportedProtocols() {
            return List.of(ConnectionProtocol.PLAY);
        }

        @Override
        public Optional<PacketFlow> getFlow() {
            return Optional.of(PacketFlow.CLIENTBOUND);
        }

        @Override
        public String getVersion() {
            return "2";
        }
    }
}
