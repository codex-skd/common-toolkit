# Delegation brief — Common Toolkit: finish the 1.21.1 / NeoForge 21.1.249 port

## Mission

`common_toolkit` currently exists only for Minecraft 26.2. We are creating a
**Minecraft 1.21.1 / NeoForge 21.1.249** version of it. The chosen strategy is a
**re-fork from the original upstream** (`Placebo` 9.9.2 for NeoForge 1.21.1),
NOT a back-port of the 26.2 source. The 26.2 repo is a **reference only** for
"what the fork added / removed on top of Placebo" — never copy 26.2-specific
API into this port.

A mechanical baseline is already in place in this repo and **compiles**
(`compileJava` = BUILD SUCCESSFUL). Your job is to reconcile it with the 26.2
fork's feature set while keeping strict 1.21.1 API.

## Paths — ALL inside the work dir (your sandbox blocks reads outside --dir)

| What | Path (relative to work dir) |
|---|---|
| **Work dir** (edit here) | `.` |
| Placebo 1.21.1 Java source (1.21.1 API reference) | `temp/ref/placebo-1.21.1-java/dev/shadowsoffire/placebo/` |
| Placebo 1.21.1 resources | `temp/ref/placebo-1.21.1-resources/` |
| CT 26.2 Java source (feature reference — DO NOT copy 26.2 API) | `temp/ref/ct-26.2-java/com/skd/commontoolkit/` |
| CT 26.2 resources (mods.toml template, mixins json, lang, NOTICE) | `temp/ref/ct-26.2-resources/` |

`temp/` is gitignored — read-only reference, not a deliverable. All output goes under `src/`.

The current baseline in the work dir = Placebo 1.21.1, renamed:
`dev.shadowsoffire.placebo` -> `com.skd.commontoolkit`, `Placebo*` classes ->
`CommonToolkit*`, package `reload/` -> `dynreg/`, modid `placebo` ->
`common_toolkit`, and the Patreon cosmetic subsystem removed. 93 Java files.

## Naming / identity rules (must hold everywhere)

- Java package: `com.skd.commontoolkit` — no `placebo` / `shadowsoffire` anywhere.
- Main class `CommonToolkit`, client `CommonToolkitClient`, config `CommonToolkitConfig`.
- modid string: `common_toolkit`. `ResourceLocation` namespace: `common_toolkit`.
- Translation keys: `common_toolkit.*` (not `placebo.*`).
- Mixin uniqueness-prefix methods: `commontoolkit_*` (not `placebo_*`).

## HARD CONSTRAINTS (do not violate)

1. **Target API = Minecraft 1.21.1 + NeoForge 21.1.249 + Java 21.** Use the
   Placebo 1.21.1 tree as the source of truth for what the 1.21.1 API looks like.
   Do NOT introduce any 26.2-only API, including but not limited to:
   `net.minecraft.resources.Identifier` (use `ResourceLocation`),
   `AddServerReloadListenersEvent` / `AddClientReloadListenersEvent`
   (1.21.1 uses `RegisterClientReloadListenersEvent` + the server reload
   mechanism Placebo already uses), `Minecraft#getDeltaTracker()`
   (1.21.1 has `getTimer()`), `net.neoforged.neoforge.transfer.*`
   (1.21.1 uses `net.neoforged.neoforge.items.*` / `IItemHandler`),
   `Minecraft.getInstance().hasShiftDown()` (1.21.1: `Screen.hasShiftDown()`).
2. **No dependency, mod-version, Minecraft-version or NeoForge-version bumps.**
   `gradle.properties` stays `minecraft_version=1.21.1`, `neo_version=21.1.249`,
   `mod_version=0.0.0-beta.1`. Do not touch `build.gradle` version/toolchain
   lines. Do not add new library dependencies.
3. **Do NOT delete any file except the 7 explicitly listed in Task A.**
4. **Do NOT run git** (no `git add`, `commit`, `push`, `checkout`) and **do NOT
   run gradle** (`gradlew`, `gradlew.bat`). The human operator compiles and
   verifies. If your environment blocks the build anyway, that is expected —
   just make the code correct by inspection against the two reference trees.
5. All code, comments, identifiers, and your final report: **English**.
6. Keep the existing coding style (indentation, import ordering, license
   headers). Files derived from Forge's config system carry an LGPL-2.1 header
   at the top — preserve it verbatim.

## TASK A — Remove the subsystems the 26.2 fork dropped

Delete these 7 files (they exist in the baseline because they were in Placebo,
but `common_toolkit` 26.2 does not have them):

```
src/main/java/com/skd/commontoolkit/cap/ModifiableEnergyStorage.java
src/main/java/com/skd/commontoolkit/loot/StackLootEntry.java
src/main/java/com/skd/commontoolkit/screen/TickableText.java
src/main/java/com/skd/commontoolkit/util/ClientUtil.java
src/main/java/com/skd/commontoolkit/systems/wanderer/BasicWandererTrade.java
src/main/java/com/skd/commontoolkit/systems/wanderer/WandererTrade.java
src/main/java/com/skd/commontoolkit/systems/wanderer/WandererTradesRegistry.java
```

Then fix every reference so the project still compiles, matching how CT 26.2
handled it (compare each file below against
`temp/ref/ct-26.2-java/com/skd/commontoolkit/...`):

- `menu/SimpleDataSlots.java` — CT 26.2 removed the `ModifiableEnergyStorage`
  support (`addEnergy`, the `EnergyDataSlot` inner class). Align this file to the
  26.2 version's shape but on 1.21.1 API.
- `screen/TickableTextList.java` — CT 26.2's version already carries its own
  nested `TickableText` record; reconcile against the 26.2 file (1.21.1 API).
- `CommonToolkitConfig.java` — drop the `clearWandererNormalTrades` /
  `clearWandererRareTrades` fields and their `cfg.getBoolean(... "wandering_trader" ...)`
  lines if CT 26.2's config does not have them (verify against the 26.2 file).
- `CommonToolkit.java` — the baseline already dropped the Patreon payload
  registration. Also make sure there is no leftover `stack_entry` /
  `WandererTradesRegistry` / loot registration. Use CT 26.2 `CommonToolkit.java`
  as the structural template, translated to 1.21.1 API.
- Grep the whole tree for `ClientUtil`, `TickableText` (top-level import),
  `WandererTrade`, `BasicWandererTrade`, `Wanderer`, `ModifiableEnergyStorage`,
  `StackLootEntry` and clean every remaining usage. If a Placebo helper method
  from `ClientUtil` is still needed by surviving code, check whether CT 26.2
  moved it elsewhere (e.g. `CommonToolkitClient` / `CommonToolkitUtil`); if CT
  26.2 simply dropped the call, drop it here too.

## TASK B — Port the 14 files the 26.2 fork ADDED on top of Placebo

These exist in `temp/ref/ct-26.2-java/com/skd/commontoolkit/`
but not in the baseline. Recreate each in the work dir at the same relative
path, taking the 26.2 file as the starting point and **down-porting its API to
1.21.1 / NeoForge 21.1.249** (use the Placebo 1.21.1 tree + the already-working
baseline files as your API reference for how 1.21.1 spells things):

```
datagen/RegisterFieldOrderingsEvent.java
json/OptionalTemplateCodec.java
mixin/DatagenModLoaderMixin.java
dynreg/DynRegPayloads.java
dynreg/RegistrySerializer.java
dynreg/SubtypedSerializer.java
dynreg/SyncManagement.java
dynreg/TagSyncPayload.java
dynreg/tag/DynamicHolderSet.java
dynreg/tag/DynamicTagKey.java
dynreg/tag/DynamicTagManager.java
dynreg/tag/ScannedTags.java
dynreg/tag/TagLoader.java
util/data/DynamicTagProvider.java
```

Notes:
- `dynreg/DynRegPayloads.java` is the 26.2 replacement for the baseline's
  `dynreg/ReloadListenerPayloads.java`. Port `DynRegPayloads` on 1.21.1 payload
  API, then update every referencing file to use it, then delete
  `dynreg/ReloadListenerPayloads.java` **only if** nothing else needs it after
  the switch (this is the one deletion allowed outside Task A — confirm in your
  report).
- The `dynreg/tag/*` package is a dynamic-tag system. On 1.21.1, tag / holder
  API differs from 26.2. Port faithfully: `HolderSet`, `TagKey`,
  `ResourceLocation`, `Registry`, datapack reload listener registration all use
  1.21.1 signatures.
- 1.21.1 custom payloads: `CustomPacketPayload` + `StreamCodec` +
  `PayloadRegistrar` via `RegisterPayloadHandlersEvent` (this is exactly what
  the baseline's `network/PayloadHelper.java` + `payloads/ButtonClickPayload.java`
  already do — copy that pattern).
- `mixin/DatagenModLoaderMixin.java`: after adding it, re-add
  `"DatagenModLoaderMixin"` to the `mixins` array in
  `src/main/resources/common_toolkit.mixins.json` (it was removed from the
  baseline). Keep `compatibilityLevel` = `JAVA_21`.

## TASK C — Reconcile the shared files the 26.2 fork rewrote

~15 files exist in both trees with the same path but diverge by more than the
mechanical rename. For each, the 26.2 divergence is a mix of (a) 26.2 API
changes — DISCARD these, keep 1.21.1 API from the baseline — and (b) real
feature wiring for the dynamic-tag / serializer system added in Task B — KEEP
these, translated to 1.21.1 API.

Highest-diff files (check every one against its 26.2 counterpart):

```
dynreg/DynamicRegistry.java        (largest — tag-system + serializer integration)
dynreg/WeightedDynamicRegistry.java
dynreg/DynamicHolder.java
dynreg/RegistryCallback.java
dynreg/DynRegBiMap.java
datagen/LegacyRecipeProvider.java
datagen/FilteredOrderingFactory.java
datagen/FieldOrderingFactory.java
datagen/DataGenBuilder.java
json/RandomAttributeModifier.java
json/WeightedItemStack.java
registry/DeferredHelper.java
systems/gear/GearSet.java
systems/gear/GearSetRegistry.java
util/data/DynamicRegistryProvider.java
util/data/RuntimeDatagenHelpers.java
codec/MapBackedCodec.java
codec/CodecMap.java
codec/CommonToolkitCodecs.java
menu/CommonToolkitContainerMenu.java
menu/FilteredSlot.java
screen/CommonToolkitContainerScreen.java
tabs/TabFillingRegistry.java
network/PayloadHelper.java
util/DrawsOnLeft.java
util/EnchantmentUtils.java
util/CommonToolkitUtil.java
CommonToolkit.java
CommonToolkitClient.java
```

Rule of thumb per hunk: if the 26.2 change is only "1.21.1 name -> 26.2 name"
(e.g. `ResourceLocation` -> `Identifier`, a moved/renamed vanilla method), keep
the baseline. If the 26.2 change adds/removes a field, method, registration, or
wires the tag system, apply the equivalent on 1.21.1 API.

## TASK D — Metadata

- `src/main/resources/templates/META-INF/neoforge.mods.toml` — verify it still
  matches CT 26.2's template (only `neoforge` + `minecraft` required deps, no
  new deps). `versionRange` for neoforge is `[${neo_version},)` which expands to
  `[21.1.249,)` — correct, leave it.
- `src/main/resources/common_toolkit.mixins.json` — final `mixins` list must be
  exactly the set of files present in `src/main/java/com/skd/commontoolkit/mixin/`
  (non-client) and `client` list = the `mixin/client/` files. After Task B that
  means re-adding `DatagenModLoaderMixin`.
- `src/main/resources/assets/common_toolkit/lang/*.json` — these were copied
  from the 26.2 repo. Make sure every translation key referenced from Java
  (`Component.translatable("common_toolkit....")`) exists in `en_us.json`. If
  the baseline Java still references a key that only exists under the old
  `placebo.` prefix in the Placebo lang file, add the `common_toolkit.`-prefixed
  key to `en_us.json` (copy the English string from
  `temp/ref/placebo-1.21.1-resources/assets/placebo/lang/en_us.json`).

## Deliverable

1. All of the above applied in the work dir.
2. The project must be correct for `./gradlew build` on NeoForge 21.1.249 by
   inspection (the operator runs the actual build).
3. A report file `docs/PORT_REPORT_1.21.1.md` (English) listing:
   - every file created / modified / deleted, one line each, with the reason;
   - any place where you could not fully determine the 1.21.1 API and made a
     best guess (so the operator can double-check);
   - any 26.2 feature you intentionally did NOT port and why.

Do not touch anything outside
`G:/Proyectos/Mods_Minecraft/common_toolkit/neoforge/1.21.1`.
