# Graph Report - 1.21.1  (2026-08-31)

## Corpus Check
- 120 files · ~100,980 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 1727 nodes · 3477 edges · 83 communities (76 shown, 7 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 171 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `09503e2a`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- Override
- DynRegPayloads.java
- GearSet
- PayloadProvider
- CodecMap
- Property
- StepFunction
- Builder
- ConfigElement
- DataGenBuilder.java
- TickableTextList
- Configuration
- IConfigElement
- BlockEntity
- MenuUtil.java
- OptionalStackCodec.java
- MixRegistry
- ConfigCategory
- LegacyRecipeProvider
- CommonToolkitTaskQueue.java
- DynamicRegistry
- DeferredHelper.java
- DynamicRegistry.java
- Offset.java
- Port Report — Common Toolkit 1.21.1 / NeoForge 21.1.249
- DynamicTagProvider.java
- DeferredHelper
- CommonToolkitClient.java
- DynamicHolder
- .register
- DynamicTagKey
- TagLoader.java
- DynamicHolderSet
- CachedObject
- TabFillingRegistry
- CommonToolkitContainerMenu
- SimpleDataSlots.java
- DataGenPopulator
- Type
- RegistrySerializer
- DeferredSet
- CommonToolkit.java
- .write
- Override
- TickingBlockEntityType.java
- .blockEntity
- CommonToolkitUtil
- ResourceLocation
- NBTAdapter.java
- Registry
- CurseForge — Variables del proyecto
- Flujo de trabajo — Common Toolkit (NeoForge)
- RegisterFieldOrderingsEvent
- .quickMoveStack
- CommonToolkitCodecs.java
- AnvilLandEvent
- .register
- Delegation brief — Common Toolkit: finish the 1.21.1 / NeoForge 21.1.249 port
- CommonToolkitContainerScreen.java
- LockedSlot.java
- FilteredSlot
- .getId
- .addSlotListener
- AnvilBlockMixin.java
- RunnableReloader
- EnchantmentUtils
- JsonUtil.java
- InternalItemHandler
- GradientColor.java
- ConfigFlags.java
- LinearEquation
- HashCacheMixin.java
- .menuType
- RandomSource
- [0.0.0-beta.1] - 2026-08-31
- Type
- .Registrar
- gradlew
- ScreenUtil

## God Nodes (most connected - your core abstractions)
1. `DynamicRegistry` - 89 edges
2. `Property` - 72 edges
3. `DeferredHelper` - 56 edges
4. `ConfigCategory` - 47 edges
5. `Configuration` - 41 edges
6. `DynamicHolder` - 39 edges
7. `ConfigElement` - 33 edges
8. `DynamicTagKey` - 31 edges
9. `AbstractBiMap` - 31 edges
10. `IConfigElement` - 29 edges

## Surprising Connections (you probably didn't know these)
- `JsonMix` --implements--> `CodecProvider`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/systems/mixes/JsonMix.java → src/main/java/com/skd/commontoolkit/codec/CodecProvider.java
- `ConfigCategory` --references--> `Property`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigCategory.java → src/main/java/com/skd/commontoolkit/config/Property.java
- `ConfigElement` --references--> `ConfigCategory`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigElement.java → src/main/java/com/skd/commontoolkit/config/ConfigCategory.java
- `Configuration` --references--> `ConfigCategory`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/Configuration.java → src/main/java/com/skd/commontoolkit/config/ConfigCategory.java
- `ConfigElement` --references--> `Type`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigElement.java → src/main/java/com/skd/commontoolkit/config/ConfigFlags.java

## Import Cycles
- None detected.

## Communities (83 total, 7 thin omitted)

### Community 0 - "Override"
Cohesion: 0.06
Nodes (20): BiMap, ForwardingMap, ForwardingMapEntry, ForwardingSet, ObjectInputStream, ObjectOutputStream, DynRegBiMap, ResourceLocation (+12 more)

### Community 1 - "DynRegPayloads.java"
Cohesion: 0.08
Nodes (35): CustomPacketPayload, Content, DynRegPayloads, End, ByteBuf, ConnectionProtocol, Either, FriendlyByteBuf (+27 more)

### Community 2 - "GearSet"
Cohesion: 0.06
Nodes (28): IntrusiveBase, CodecProvider, Codec, IDimensional, ILuckyWeighted, Level, Logger, Nullable (+20 more)

### Community 3 - "PayloadProvider"
Cohesion: 0.07
Nodes (30): HandlerThread, IPayloadHandler, RegisterPayloadHandlersEvent, ConnectionProtocol, IPayloadContext, Override, PacketFlow, SubscribeEvent (+22 more)

### Community 4 - "CodecMap"
Cohesion: 0.09
Nodes (26): Codec, CodecMap, BiMap, DataResult, DynamicOps, Nullable, Override, Pair (+18 more)

### Community 6 - "StepFunction"
Cohesion: 0.07
Nodes (26): AttributeModifier, Float2FloatFunction, Operation, ResourceLocation, ChancedEffectInstance, Codec, Holder, MobEffect (+18 more)

### Community 7 - "Builder"
Cohesion: 0.07
Nodes (21): Overwrite, PackType, FieldOrderingFactory, Impl, Internal, JsonElement, Nullable, Object2IntOpenHashMap (+13 more)

### Community 9 - "DataGenBuilder.java"
Cohesion: 0.08
Nodes (30): DataGenerator, DataProvider, ExistingFileHelper, GatherDataEventGenerator, ICondition, PackResources, RegistryBootstrap, RegistrySetBuilder (+22 more)

### Community 10 - "TickableTextList"
Cohesion: 0.08
Nodes (21): DisplayMode, Font, FormattedCharSequence, FormattedCharSink, Matrix4f, MultiBufferSource, MutableFloat, AbstractContainerScreenMixin (+13 more)

### Community 11 - "Configuration"
Cohesion: 0.09
Nodes (8): Entry, CommonToolkitConfig, Configuration, CharMatcher, Logger, Override, Pattern, UnicodeInputStreamReader

### Community 12 - "IConfigElement"
Cohesion: 0.05
Nodes (10): ConfigGuiType, BOOLEAN, COLOR, CONFIG_CATEGORY, DOUBLE, INTEGER, MOD_ID, STRING (+2 more)

### Community 13 - "BlockEntity"
Cohesion: 0.10
Nodes (23): BlockEntity, EntityBlock, BlockPos, BlockState, Level, TickingBlockEntity, BlockEntityTicker, BlockEntityType (+15 more)

### Community 14 - "MenuUtil.java"
Cohesion: 0.11
Nodes (22): InteractionResult, MenuConstructor, MenuProvider, BlockPos, FunctionalInterface, IContainerFactory, Inventory, MenuSupplier (+14 more)

### Community 15 - "OptionalStackCodec.java"
Cohesion: 0.11
Nodes (24): Item, MapCodec, MapLike, ModifyConstant, RecordBuilder, RegistryOps, HandToJsonCommand, CommandSourceStack (+16 more)

### Community 16 - "MixRegistry"
Cohesion: 0.14
Nodes (19): ServerAboutToStartEvent, codec(), forType(), Codec, Holder, Ingredient, MapCodec, Mix (+11 more)

### Community 17 - "ConfigCategory"
Cohesion: 0.09
Nodes (4): ConfigCategory, CharMatcher, Entry, Override

### Community 18 - "LegacyRecipeProvider"
Cohesion: 0.17
Nodes (14): NonNullList, RecipeOutput, RecipeProvider, ShapedRecipePattern, Holder, Ingredient, ItemStack, Override (+6 more)

### Community 19 - "CommonToolkitTaskQueue.java"
Cohesion: 0.14
Nodes (16): ServerStartedEvent, ServerStoppedEvent, CommonToolkitTaskQueue, DelayedTask, Impl, EventBusSubscriber, FunctionalInterface, Override (+8 more)

### Community 20 - "DynamicRegistry"
Cohesion: 0.14
Nodes (8): DynamicRegistry, ByteBuf, OnDatapackSyncEvent, StreamCodec, Delegated, Internal, Override, RegistryCallback

### Community 21 - "DeferredHelper.java"
Cohesion: 0.10
Nodes (19): AttachmentType, EntityFactory, EntityType, Feature, Fluid, IAttachmentHolder, MobCategory, NewRegistryEvent (+11 more)

### Community 22 - "DynamicRegistry.java"
Cohesion: 0.14
Nodes (14): CodecException, SimplePreparableReloadListener, AddReloadListenerEvent, BiMap, Logger, DynamicTagManager, ConditionalOps, JsonElement (+6 more)

### Community 23 - "Offset.java"
Cohesion: 0.12
Nodes (19): Int2IntFunction, PoseStack, AnchorPoint, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_RIGHT, MIDDLE_CENTER, MIDDLE_LEFT (+11 more)

### Community 24 - "Port Report — Common Toolkit 1.21.1 / NeoForge 21.1.249"
Cohesion: 0.08
Nodes (21): neoforge.mods.toml, Notes for the operator, Port Report — Common Toolkit 1.21.1 / NeoForge 21.1.249, Post-delegation fixes (operator, verified against `./gradlew build` + `runServer`), Summary, Task A+B — Additional deleted file (1), Task A — Deleted files (7), Task A — Modified files (reference cleanup) (+13 more)

### Community 25 - "DynamicTagProvider.java"
Cohesion: 0.14
Nodes (10): DynamicTagProvider, CachedOutput, Override, PackOutput, PathProvider, Provider, ResourceLocation, TagEntry (+2 more)

### Community 26 - "DeferredHelper"
Cohesion: 0.22
Nodes (6): DeferredHolder, RangedAttribute, DeferredHelper, Attribute, MobEffectInstance, Potion

### Community 27 - "CommonToolkitClient.java"
Cohesion: 0.12
Nodes (13): FMLClientSetupEvent, ItemTooltipEvent, MouseScrollingEvent, Pre, RegisterClientReloadListenersEvent, CommonToolkitClient, EventBusSubscriber, ItemStack (+5 more)

### Community 28 - "DynamicHolder"
Cohesion: 0.15
Nodes (4): DynamicHolder, Override, ResourceLocation, SuppressWarnings

### Community 29 - ".register"
Cohesion: 0.11
Nodes (10): DataComponentType, DeferredBlock, IngredientType, LootItemCondition, LootItemConditionType, LootPoolEntryType, RegisterEvent, SimpleParticleType (+2 more)

### Community 30 - "DynamicTagKey"
Cohesion: 0.16
Nodes (7): Named, DynamicTagKey, ByteBuf, Codec, Override, ResourceLocation, StreamCodec

### Community 31 - "TagLoader.java"
Cohesion: 0.21
Nodes (12): Lookup, SequencedSet, EntryWithSource, ConditionalOps, JsonElement, Logger, Override, ResourceLocation (+4 more)

### Community 32 - "DynamicHolderSet"
Cohesion: 0.14
Nodes (8): DynamicHolderSet, Either, RegistryFriendlyByteBuf, StreamCodec, SuppressWarnings, GearSetRegistry, Nullable, RandomSource

### Community 33 - "CachedObject"
Cohesion: 0.20
Nodes (11): ItemStackMixin, ItemStack, Mixin, Override, ResourceLocation, SuppressWarnings, CachedObject, CachedObjectSource (+3 more)

### Community 34 - "TabFillingRegistry"
Cohesion: 0.21
Nodes (11): ITabFiller, BuildCreativeModeTabContentsEvent, CreativeModeTab, ItemLike, BuildCreativeModeTabContentsEvent, CreativeModeTab, Internal, ItemLike (+3 more)

### Community 35 - "CommonToolkitContainerMenu"
Cohesion: 0.19
Nodes (10): AbstractContainerMenu, IItemHandler, CommonToolkitContainerMenu, Inventory, ItemStack, Level, MenuType, Override (+2 more)

### Community 36 - "SimpleDataSlots.java"
Cohesion: 0.22
Nodes (9): BooleanConsumer, BooleanSupplier, DataSlot, IntConsumer, IntSupplier, IDataAutoRegister, Override, LambdaDataSlot (+1 more)

### Community 37 - "DataGenPopulator"
Cohesion: 0.16
Nodes (7): MustBeInvokedByOverriders, DataGenPopulator, Internal, ReloadType, DEDICATED_CLIENT, INTEGRATED_CLIENT, SERVER

### Community 38 - "Type"
Cohesion: 0.12
Nodes (10): Pattern, Pattern, tryParse(), Type, BOOLEAN, COLOR, DOUBLE, INTEGER (+2 more)

### Community 39 - "RegistrySerializer"
Cohesion: 0.29
Nodes (7): Codec, Nullable, Override, RegistryFriendlyByteBuf, StreamCodec, RegistrySerializer, Simple

### Community 41 - "CommonToolkit.java"
Cohesion: 0.19
Nodes (9): FMLCommonSetupEvent, IEventBus, Mod, RegisterCommandsEvent, CommonToolkit, AddReloadListenerEvent, Logger, SubscribeEvent (+1 more)

### Community 42 - ".write"
Cohesion: 0.23
Nodes (11): CommandSourceStack, DynamicCommandExceptionType, LiteralArgumentBuilder, SerializeLootTableCommand, Codec, Deprecated, Gson, JsonElement (+3 more)

### Community 43 - "Override"
Cohesion: 0.19
Nodes (3): Direct, Override, RandomSource

### Community 44 - "TickingBlockEntityType.java"
Cohesion: 0.19
Nodes (10): BlockEntityType, Block, BlockEntitySupplier, BlockEntityTicker, Nullable, TickingBlockEntityType, TickSide, CLIENT (+2 more)

### Community 45 - ".blockEntity"
Cohesion: 0.17
Nodes (9): BlockItem, DeferredItem, Experimental, Block, BlockEntitySupplier, BlockEntityType, Holder, SafeVarargs (+1 more)

### Community 46 - "CommonToolkitUtil"
Cohesion: 0.20
Nodes (8): ServerPlayer, CommonToolkitUtil, BlockPos, Component, Deprecated, ItemStack, SafeVarargs, SuppressWarnings

### Community 47 - "ResourceLocation"
Cohesion: 0.21
Nodes (6): JsonElement, Nullable, Override, ProfilerFiller, ResourceLocation, ResourceManager

### Community 48 - "NBTAdapter.java"
Cohesion: 0.32
Nodes (10): CompoundTag, JsonDeserializationContext, JsonDeserializer, JsonSerializationContext, JsonSerializer, Codec, JsonElement, Override (+2 more)

### Community 49 - "Registry"
Cohesion: 0.22
Nodes (7): DataMapType, RegistryBuilder, Codec, Deprecated, Registry, ResourceKey, Type

### Community 50 - "CurseForge — Variables del proyecto"
Cohesion: 0.15
Nodes (12): CurseForge — Variables del proyecto, Descripción del proyecto, Entorno "Client & Server", Flujo completo, IDs de `gameVersions` para 1.21.1, Parámetros del upload, Proyecto, Rama (+4 more)

### Community 51 - "Flujo de trabajo — Common Toolkit (NeoForge)"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Common Toolkit (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 52 - "RegisterFieldOrderingsEvent"
Cohesion: 0.27
Nodes (7): Event, IModBusEvent, LogicalSide, Internal, RegisterFieldOrderingsEvent, ResourceManager, ResourceReloadEvent

### Community 53 - ".quickMoveStack"
Cohesion: 0.33
Nodes (6): ItemStack, Player, Slot, QuickMoveHandler, QuickMoveMenu, QuickMoveRule

### Community 54 - "CommonToolkitCodecs.java"
Cohesion: 0.33
Nodes (5): CommonToolkitCodecs, BiMap, Codec, Deprecated, ResourceLocation

### Community 55 - "AnvilLandEvent"
Cohesion: 0.36
Nodes (5): AnvilLandEvent, BlockPos, BlockState, FallingBlockEntity, Level

### Community 56 - ".register"
Cohesion: 0.27
Nodes (7): CommandBuildContext, CommandDispatcher, CommonToolkitCommand, CommandSourceStack, GetDimensionTypeCommand, CommandSourceStack, LiteralArgumentBuilder

### Community 57 - "Delegation brief — Common Toolkit: finish the 1.21.1 / NeoForge 21.1.249 port"
Cohesion: 0.18
Nodes (10): Delegation brief — Common Toolkit: finish the 1.21.1 / NeoForge 21.1.249 port, Deliverable, HARD CONSTRAINTS (do not violate), Mission, Naming / identity rules (must hold everywhere), Paths — ALL inside the work dir (your sandbox blocks reads outside --dir), TASK A — Remove the subsystems the 26.2 fork dropped, TASK B — Port the 14 files the 26.2 fork ADDED on top of Placebo (+2 more)

### Community 58 - "CommonToolkitContainerScreen.java"
Cohesion: 0.31
Nodes (7): AbstractContainerScreen, MenuAccess, CommonToolkitContainerScreen, Component, GuiGraphics, Inventory, Override

### Community 59 - "LockedSlot.java"
Cohesion: 0.31
Nodes (6): Slot, Inventory, ItemStack, Override, Player, LockedSlot

### Community 60 - "FilteredSlot"
Cohesion: 0.38
Nodes (5): SlotItemHandler, FilteredSlot, ItemStack, Override, Player

### Community 61 - ".getId"
Cohesion: 0.24
Nodes (3): Codec, Codec, ResourceLocation

### Community 62 - ".addSlotListener"
Cohesion: 0.22
Nodes (4): Deprecated, IDataUpdateListener, ItemStack, SlotUpdateListener

### Community 63 - "AnvilBlockMixin.java"
Cohesion: 0.36
Nodes (8): AnvilBlockMixin, BlockPos, BlockState, CallbackInfo, FallingBlockEntity, Inject, Level, Mixin

### Community 64 - "RunnableReloader"
Cohesion: 0.40
Nodes (5): Override, ProfilerFiller, ResourceManager, RunnableReloader, Unit

### Community 66 - "JsonUtil.java"
Cohesion: 0.50
Nodes (5): ConditionalOps, JsonElement, Logger, ResourceLocation, JsonUtil

### Community 67 - "InternalItemHandler"
Cohesion: 0.43
Nodes (3): ItemStackHandler, InternalItemHandler, ItemStack

### Community 68 - "GradientColor.java"
Cohesion: 0.33
Nodes (3): GradientColor, Override, TextColor

### Community 69 - "ConfigFlags.java"
Cohesion: 0.29
Nodes (5): ConfigFlags, Loadability, LOCKED, RELOADABLE, RESTARTABLE

### Community 71 - "HashCacheMixin.java"
Cohesion: 0.53
Nodes (4): HashCacheMixin, CallbackInfo, Inject, Mixin

### Community 72 - ".menuType"
Cohesion: 0.40
Nodes (3): IContainerFactory, MenuSupplier, MenuType

### Community 74 - "[0.0.0-beta.1] - 2026-08-31"
Cohesion: 0.40
Nodes (4): [0.0.0-beta.1] - 2026-08-31, Added, Common Toolkit (1.21.1) — Registro de cambios, Technical

### Community 75 - "Type"
Cohesion: 0.40
Nodes (5): Type, CLIENT, COMMON, SERVER, SYNCED

### Community 76 - ".Registrar"
Cohesion: 0.50
Nodes (3): ResourceLocation, Registrar, StatFormatter

### Community 77 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Knowledge Gaps
- **91 isolated node(s):** `CLIENT`, `SERVER`, `CLIENT_AND_SERVER`, `ConfigFlags`, `COMMON` (+86 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **7 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `DynamicRegistry` connect `DynamicRegistry` to `DynamicHolderSet`, `DynRegPayloads.java`, `GearSet`, `DataGenPopulator`, `RegistrySerializer`, `DataGenBuilder.java`, `ResourceLocation`, `MixRegistry`, `DynamicRegistry.java`, `DynamicTagProvider.java`, `DynamicHolder`, `.getId`, `DynamicTagKey`, `TagLoader.java`?**
  _High betweenness centrality (0.157) - this node is a cross-community bridge._
- **Why does `Configuration` connect `Configuration` to `ConfigCategory`, `RegisterFieldOrderingsEvent`, `Property`, `Offset.java`?**
  _High betweenness centrality (0.150) - this node is a cross-community bridge._
- **Why does `ConfigCategory` connect `ConfigCategory` to `ConfigElement`, `Configuration`, `Property`, `Type`?**
  _High betweenness centrality (0.104) - this node is a cross-community bridge._
- **What connects `CLIENT`, `SERVER`, `CLIENT_AND_SERVER` to the rest of the system?**
  _91 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Override` be split into smaller, more focused modules?**
  _Cohesion score 0.05582603050957481 - nodes in this community are weakly interconnected._
- **Should `DynRegPayloads.java` be split into smaller, more focused modules?**
  _Cohesion score 0.07553143374038897 - nodes in this community are weakly interconnected._
- **Should `GearSet` be split into smaller, more focused modules?**
  _Cohesion score 0.062310949788263764 - nodes in this community are weakly interconnected._