package com.skd.commontoolkit.dynreg;

import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus;

public interface RegistryCallback<R> {

    public void beginReload(DynamicRegistry<R> manager);

    public void onReload(DynamicRegistry<R> manager);

    public static <R> RegistryCallback<R> create(Consumer<DynamicRegistry<R>> beginReload, Consumer<DynamicRegistry<R>> onReload) {
        return new Delegated<>(beginReload, onReload);
    }

    public static <R> RegistryCallback<R> beginOnly(Consumer<DynamicRegistry<R>> beginReload) {
        return new Delegated<>(beginReload, v -> {});
    }

    public static <R> RegistryCallback<R> reloadOnly(Consumer<DynamicRegistry<R>> onReload) {
        return new Delegated<>(v -> {}, onReload);
    }

    @ApiStatus.Internal
    class Delegated<R> implements RegistryCallback<R> {

        private Consumer<DynamicRegistry<R>> beginReload, onReload;

        public Delegated(Consumer<DynamicRegistry<R>> beginReload, Consumer<DynamicRegistry<R>> onReload) {
            this.beginReload = beginReload;
            this.onReload = onReload;
        }

        @Override
        public void beginReload(DynamicRegistry<R> manager) {
            this.beginReload.accept(manager);
        }

        @Override
        public void onReload(DynamicRegistry<R> manager) {
            this.onReload.accept(manager);
        }
    }
}
