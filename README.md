# Common Toolkit

A library mod for **Fabric, Forge and NeoForge** (Minecraft 1.21.1, 26.1.2, 26.2 and 26.3) providing shared developer utilities for other mods: configuration, networking helpers, dynamic JSON-driven registries with client sync, weighted gear/brewing-mix registries, creative tab filling, color/codec helpers, and related infrastructure.

This is a from-scratch **rewrite/port** of [Placebo](https://www.curseforge.com/minecraft/mc-mods/placebo) by Shadows_of_Fire (MIT License), retargeted to Minecraft under a new mod id, package, and API surface — it is not a drop-in replacement and mods depending on the original Placebo API will not work against it. The Patreon-gated cosmetic system present in the original (wings/trails perks) was intentionally removed; it was tied to the original author's Patreon and has no place in an independently branded mod.

## Features

- **Configuration**: Declarative common/client/server config with an in-game config screen.
- **Dynamic Registries**: JSON-driven, datapack-reloadable registries with automatic client sync over the network (weighted and unweighted variants).
- **Networking Helper**: Simplified payload registration/handling on top of the networking API of each mod loader.
- **Gear Sets & Brewing Mixes**: Weighted, JSON-configurable registries for equipment sets and custom brewing recipes, ready for other mods to plug into.
- **Creative Tab Filling**: Declarative registry to inject items into existing creative tabs without event-handler boilerplate.
- **Color & Codec Utilities**: Gradient colors and common `Codec`/`StreamCodec` helpers.
- **Developer API**: Intended to be depended on by other mods, the same way the original Placebo was.

Some helpers that rely on loader-specific systems (for example NeoForge data attachments or data maps) are only available on the loaders that provide them.

## Requirements

Client and server. Pick the build that matches your Minecraft version and mod loader:

| Minecraft | NeoForge | Forge | Fabric (Loader / API) | Java |
|---|---|---|---|---|
| 1.21.1 | 21.1.259+ | 52.1.21+ | 0.19.5+ / 0.116.17+ | 21 |
| 26.1.2 | 26.1.2.78+ | 64.1.4+ | 0.19.5+ / 0.155.3+ | 25 |
| 26.2 | 26.2.0.57+ | 65.1.4+ | 0.19.5+ / 0.161.0+ | 25 |
| 26.3 | 26.3.0.26-beta+ | 66.0.11+ | 0.19.5+ / 0.161.0+ | 25 |

## Build

```bash
gradlew build
```

The jar will be generated at `build/libs/common_toolkit-<minecraft_version>-<loader>-<loader_version>-<version>.jar`.

## Credits

- Ported from [Placebo](https://www.curseforge.com/minecraft/mc-mods/placebo) by **Shadows_of_Fire** (MIT License). See [NOTICE.md](NOTICE.md) for the full license text and per-file attributions.
- **License**: distributed under the **GNU LGPL v2.1 or later** (`COPYING.LESSER`), because the `com.skd.commontoolkit.config` package derives from Minecraft Forge's LGPL-2.1 legacy config code. The Placebo-derived remainder is additionally available under the **MIT License** (see `NOTICE.md`). A `-sources.jar` is published with every release.
- Developed by **Stalking Dragons** — [https://codex.skdragons.com/](https://codex.skdragons.com/).
