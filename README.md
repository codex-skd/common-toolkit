# Common Toolkit

A library mod for NeoForge (MC 1.21.1) providing shared developer utilities for other mods: configuration, networking helpers, dynamic JSON-driven registries with client sync, weighted gear/brewing-mix registries, creative tab filling, color/codec helpers, and related infrastructure.

This is a from-scratch **rewrite/port** of [Placebo](https://www.curseforge.com/minecraft/mc-mods/placebo) by Shadows_of_Fire (MIT License), under a new mod id, package, and API surface. This `1.21.1` branch is a **re-fork from the upstream Placebo 1.21.1 sources** (Placebo 9.9.2, NeoForge 21.1.187), re-applying the Common Toolkit identity and the 26.2 line's feature additions on top of the 1.21.1 API — it is not a drop-in replacement and mods depending on the original Placebo API will not work against it. The Patreon-gated cosmetic system present in the original (wings/trails perks) was intentionally removed; it was tied to the original author's Patreon and has no place in an independently branded mod.

## Features

- **Configuration**: Declarative common/client/server config with an in-game config screen.
- **Dynamic Registries**: JSON-driven, datapack-reloadable registries with automatic client sync over the network (weighted and unweighted variants).
- **Dynamic Tags**: `#namespace:tag` references for the dynamic registries, resolved after content load and synced to the client.
- **Networking Helper**: Simplified payload registration/handling on top of the NeoForge networking API.
- **Gear Sets & Brewing Mixes**: Weighted, JSON-configurable registries for equipment sets and custom brewing recipes, ready for other mods to plug into.
- **Creative Tab Filling**: Declarative registry to inject items into existing creative tabs without event-handler boilerplate.
- **Color & Codec Utilities**: Gradient colors and common `Codec`/`StreamCodec` helpers.
- **Developer API**: Intended to be depended on by other mods, the same way the original Placebo was.

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.249+ (client and server)
- Java 21+

## Build

```bash
gradlew build
```

The jar will be generated at `build/libs/common_toolkit-1.21.1-neoforge-21.1.249-<version>.jar`.

See [docs/PORT_REPORT_1.21.1.md](docs/PORT_REPORT_1.21.1.md) for the port details.

## Credits

- Ported from [Placebo](https://www.curseforge.com/minecraft/mc-mods/placebo) by **Shadows_of_Fire** (MIT License). See [NOTICE.md](NOTICE.md) for the full license text and per-file attributions.
- **License**: distributed under the **GNU LGPL v2.1 or later** (`COPYING.LESSER`), because the `com.skd.commontoolkit.config` package derives from Minecraft Forge's LGPL-2.1 legacy config code. The Placebo-derived remainder is additionally available under the **MIT License** (see `NOTICE.md`). A `-sources.jar` is published with every release.
- Developed by **Stalking Dragons** — [https://codex.skdragons.com/](https://codex.skdragons.com/).
