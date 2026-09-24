package com.skd.commontoolkit.dynreg;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.skd.commontoolkit.dynreg.tag.DynamicTagKey;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

public class DynamicHolder<R> implements Supplier<R> {

    public static final ResourceLocation EMPTY = ResourceLocation.fromNamespaceAndPath("empty", "empty");

    protected final DynamicRegistry<R> registry;
    protected final ResourceLocation id;

    @Nullable
    protected R value;

    DynamicHolder(DynamicRegistry<R> registry, ResourceLocation id) {
        this.id = id;
        this.registry = registry;
    }

    public boolean isBound() {
        this.bind();
        return this.value != null;
    }

    @Override
    public R get() {
        this.bind();
        Objects.requireNonNull(this.value, "Trying to access unbound value: " + this.id);
        return this.value;
    }

    public Optional<R> getOptional() {
        return this.isBound() ? Optional.of(this.get()) : Optional.empty();
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public DynamicRegistry<R> getRegistry() {
        return this.registry;
    }

    public boolean is(ResourceLocation id) {
        return this.id.equals(id);
    }

    public boolean is(DynamicTagKey<R> tag) {
        return this.registry.getTag(tag).map(set -> set.contains(this)).orElse(false);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof DynamicHolder dh && dh.registry == this.registry && dh.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.registry);
    }

    @Override
    public String toString() {
        return "DynamicHolder{%s / %s}".formatted(this.registry.id, this.id);
    }

    @SuppressWarnings("unchecked")
    void bind() {
        if (this.value != null) return;
        this.value = (R) this.registry.getValue(this.id);
    }

    void unbind() {
        this.value = null;
    }
}
