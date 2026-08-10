# Graph Report - 26.2  (2026-08-10)

## Corpus Check
- 122 files · ~100,093 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 1718 nodes · 3498 edges · 83 communities (73 shown, 10 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 173 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `1243d089`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- Bi-Directional Map
- Container Menu
- Codec Operations
- Custom Packet Payloads
- Attribute Handling
- Data Generation
- Block Entities
- Dynamic Registry Management
- Codec Providers
- Payload Handlers
- Configuration Elements
- Property Management
- Font Handling
- Configuration Loading
- Config Element Types
- Dynamic Holder Management
- Event Handling
- Interaction Results
- Map Codec Operations
- Modify Constants
- Configuration Categories
- Recipe Management
- Dynamic Tag Keys
- Entity Types
- Data Provider Management
- Server Events
- Pose Stack Operations
- Tag Lookup
- Client Reload Listeners
- Registry Conditions
- Data Generator Populator
- Common Toolkit Setup
- Dynamic Holder Set
- Item Stack Mixin
- Tab Filler
- Deferred Helper
- Deferred Holders
- Data Component Types
- Deferred Set
- Server Start Events
- Block Entity Types
- Server Player Management
- Reload Listener
- Json Mix Operations
- NBT Adapter
- Block Items
- Command Dispatcher
- Config Element Validation
- Runnable Reloader
- Enchantment Utilities
- DataGenPopulator
- Json Utility
- Gradient Color
- Config Flags
- Linear Equation
- Hash Cache Mixin
- Menu Operations
- Random Range
- Sync Types
- Custom Stats
- Build Scripts
- Slot Update Listener
- Screen Utility
- Mod Icon
- Flujo de trabajo — Common Toolkit (NeoForge)
- CurseForge — Variables del proyecto
- Common Toolkit
- ResourceReloadEvent.java
- CLAUDE.md — common_toolkit (26.2)
- Common Toolkit — Registro de cambios
- Type
- TickingBlockEntityType.java
- GearSet
- WeightedItemStack
- .elementCodec
- GearSetRegistry.java
- ILuckyWeighted

## God Nodes (most connected - your core abstractions)
1. `DynamicRegistry` - 88 edges
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
- `ConfigCategory` --references--> `Property`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigCategory.java → src/main/java/com/skd/commontoolkit/config/Property.java
- `ConfigElement` --references--> `ConfigCategory`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigElement.java → src/main/java/com/skd/commontoolkit/config/ConfigCategory.java
- `Configuration` --references--> `ConfigCategory`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/Configuration.java → src/main/java/com/skd/commontoolkit/config/ConfigCategory.java
- `ConfigElement` --references--> `Type`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigElement.java → src/main/java/com/skd/commontoolkit/config/ConfigFlags.java
- `ConfigElement` --implements--> `IConfigElement`  [EXTRACTED]
  src/main/java/com/skd/commontoolkit/config/ConfigElement.java → src/main/java/com/skd/commontoolkit/config/IConfigElement.java

## Import Cycles
- None detected.

## Communities (83 total, 10 thin omitted)

### Community 0 - "Bi-Directional Map"
Cohesion: 0.06
Nodes (20): BiMap, ForwardingMap, ForwardingMapEntry, ForwardingSet, ObjectInputStream, ObjectOutputStream, DynRegBiMap, Identifier (+12 more)

### Community 1 - "Container Menu"
Cohesion: 0.06
Nodes (33): AbstractContainerMenu, ItemStacksResourceHandler, ResourceHandler, ResourceHandlerSlot, Slot, InternalItemHandler, ItemResource, CommonToolkitContainerMenu (+25 more)

### Community 2 - "Codec Operations"
Cohesion: 0.09
Nodes (26): Codec, CodecMap, BiMap, DataResult, DynamicOps, Identifier, Nullable, Override (+18 more)

### Community 3 - "Custom Packet Payloads"
Cohesion: 0.07
Nodes (36): CustomPacketPayload, OnDatapackSyncEvent, Content, DynRegPayloads, End, ByteBuf, ConnectionProtocol, Either (+28 more)

### Community 4 - "Attribute Handling"
Cohesion: 0.07
Nodes (29): AttributeModifier, Float2FloatFunction, Operation, CommonToolkitCodecs, BiMap, Codec, Deprecated, Identifier (+21 more)

### Community 5 - "Data Generation"
Cohesion: 0.06
Nodes (28): DataGenerator, GatherDataEventGenerator, Overwrite, PackResources, PackType, FieldOrderingFactory, Impl, Identifier (+20 more)

### Community 6 - "Block Entities"
Cohesion: 0.10
Nodes (23): BlockEntity, EntityBlock, BlockPos, BlockState, Level, TickingBlockEntity, BlockEntityTicker, BlockEntityType (+15 more)

### Community 7 - "Dynamic Registry Management"
Cohesion: 0.22
Nodes (7): Codec, Nullable, Override, RegistryFriendlyByteBuf, StreamCodec, RegistrySerializer, Simple

### Community 8 - "Codec Providers"
Cohesion: 0.19
Nodes (10): IDimensional, Identifier, Level, Logger, Nullable, Override, RandomSource, SafeVarargs (+2 more)

### Community 9 - "Payload Handlers"
Cohesion: 0.07
Nodes (30): HandlerThread, IPayloadHandler, RegisterPayloadHandlersEvent, ConnectionProtocol, IPayloadContext, Override, PacketFlow, SubscribeEvent (+22 more)

### Community 12 - "Font Handling"
Cohesion: 0.12
Nodes (11): Font, FormattedCharSequence, FormattedCharSink, MutableFloat, FormattedText, GuiGraphicsExtractor, Override, TickableText (+3 more)

### Community 13 - "Configuration Loading"
Cohesion: 0.09
Nodes (8): Entry, CommonToolkitConfig, Configuration, CharMatcher, Logger, Override, Pattern, UnicodeInputStreamReader

### Community 14 - "Config Element Types"
Cohesion: 0.05
Nodes (10): ConfigGuiType, BOOLEAN, COLOR, CONFIG_CATEGORY, DOUBLE, INTEGER, MOD_ID, STRING (+2 more)

### Community 15 - "Dynamic Holder Management"
Cohesion: 0.19
Nodes (4): DynamicHolder, Identifier, Override, SuppressWarnings

### Community 16 - "Event Handling"
Cohesion: 0.13
Nodes (17): Event, IModBusEvent, Internal, RegisterFieldOrderingsEvent, AnvilLandEvent, BlockPos, BlockState, FallingBlockEntity (+9 more)

### Community 17 - "Interaction Results"
Cohesion: 0.11
Nodes (22): InteractionResult, MenuConstructor, MenuProvider, BlockPos, FunctionalInterface, IContainerFactory, Inventory, MenuSupplier (+14 more)

### Community 18 - "Map Codec Operations"
Cohesion: 0.13
Nodes (25): MapCodec, Codec, DataResult, DynamicOps, Holder, Identifier, Item, ItemStack (+17 more)

### Community 19 - "Modify Constants"
Cohesion: 0.11
Nodes (23): ModifyConstant, RegistryOps, HandToJsonCommand, CommandSourceStack, DynamicCommandExceptionType, Gson, ItemStack, JsonElement (+15 more)

### Community 20 - "Configuration Categories"
Cohesion: 0.09
Nodes (4): ConfigCategory, CharMatcher, Entry, Override

### Community 21 - "Recipe Management"
Cohesion: 0.15
Nodes (17): NonNullList, Recipe, RecipeOutput, RecipeProvider, Runner, ShapedRecipePattern, Holder, Identifier (+9 more)

### Community 22 - "Dynamic Tag Keys"
Cohesion: 0.13
Nodes (6): Direct, Either, Override, Named, DynamicTagKey, Override

### Community 23 - "Entity Types"
Cohesion: 0.10
Nodes (20): AttachmentType, EntityFactory, EntityType, Feature, Fluid, IAttachmentHolder, MobCategory, NewRegistryEvent (+12 more)

### Community 24 - "Data Provider Management"
Cohesion: 0.14
Nodes (10): DynamicTagProvider, CachedOutput, Identifier, Override, PackOutput, PathProvider, Provider, TagEntry (+2 more)

### Community 25 - "Server Events"
Cohesion: 0.14
Nodes (16): ServerStartedEvent, ServerStoppedEvent, CommonToolkitTaskQueue, DelayedTask, Impl, EventBusSubscriber, FunctionalInterface, Identifier (+8 more)

### Community 26 - "Pose Stack Operations"
Cohesion: 0.12
Nodes (19): Int2IntFunction, PoseStack, AnchorPoint, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_RIGHT, MIDDLE_CENTER, MIDDLE_LEFT (+11 more)

### Community 27 - "Tag Lookup"
Cohesion: 0.21
Nodes (12): Lookup, SequencedSet, EntryWithSource, ConditionalOps, Identifier, JsonElement, Logger, Override (+4 more)

### Community 28 - "Client Reload Listeners"
Cohesion: 0.12
Nodes (13): AddClientReloadListenersEvent, FMLClientSetupEvent, ItemTooltipEvent, MouseScrollingEvent, Pre, CommonToolkitClient, EventBusSubscriber, ItemStack (+5 more)

### Community 29 - "Registry Conditions"
Cohesion: 0.08
Nodes (27): DataProvider, ICondition, RegistryBootstrap, RegistrySetBuilder, DataGenBuilder, DataProviderFactory, Factory, FunctionalInterface (+19 more)

### Community 30 - "Data Generator Populator"
Cohesion: 0.14
Nodes (6): DynamicHolderSet, Codec, RandomSource, RegistryFriendlyByteBuf, StreamCodec, SuppressWarnings

### Community 31 - "Common Toolkit Setup"
Cohesion: 0.14
Nodes (11): FMLCommonSetupEvent, IEventBus, Mod, RegisterCommandsEvent, ServerAboutToStartEvent, CommonToolkit, AddServerReloadListenersEvent, Identifier (+3 more)

### Community 32 - "Dynamic Holder Set"
Cohesion: 0.19
Nodes (11): BooleanConsumer, BooleanSupplier, DataSlot, IntConsumer, IntSupplier, SimpleEnergyHandler, EnergyDataSlot, IDataAutoRegister (+3 more)

### Community 33 - "Item Stack Mixin"
Cohesion: 0.20
Nodes (11): ItemStackMixin, Identifier, ItemStack, Mixin, Override, SuppressWarnings, CachedObject, CachedObjectSource (+3 more)

### Community 34 - "Tab Filler"
Cohesion: 0.21
Nodes (11): ITabFiller, BuildCreativeModeTabContentsEvent, CreativeModeTab, ItemLike, BuildCreativeModeTabContentsEvent, CreativeModeTab, Internal, ItemLike (+3 more)

### Community 35 - "Deferred Helper"
Cohesion: 0.22
Nodes (9): DataMapType, Experimental, DeferredHelper, Codec, Holder, Registry, ResourceKey, SuppressWarnings (+1 more)

### Community 36 - "Deferred Holders"
Cohesion: 0.20
Nodes (5): DeferredHolder, RangedAttribute, Attribute, MobEffectInstance, Potion

### Community 37 - "Data Component Types"
Cohesion: 0.15
Nodes (6): DataComponentType, DeferredBlock, IngredientType, RegisterEvent, SimpleParticleType, MapCodec

### Community 39 - "Server Start Events"
Cohesion: 0.24
Nodes (9): ReloadType, DEDICATED_CLIENT, INTEGRATED_CLIENT, SERVER, Mix, Override, PotionBrewing, SuppressWarnings (+1 more)

### Community 40 - "Block Entity Types"
Cohesion: 0.40
Nodes (5): Override, ProfilerFiller, ResourceManager, RunnableReloader, Unit

### Community 41 - "Server Player Management"
Cohesion: 0.20
Nodes (8): ServerPlayer, CommonToolkitUtil, BlockPos, Component, Deprecated, ItemStack, SafeVarargs, SuppressWarnings

### Community 42 - "Reload Listener"
Cohesion: 0.24
Nodes (10): SimplePreparableReloadListener, DynamicTagManager, ConditionalOps, Identifier, JsonElement, Override, ProfilerFiller, ResourceManager (+2 more)

### Community 43 - "Json Mix Operations"
Cohesion: 0.32
Nodes (12): codec(), forType(), Codec, Holder, Ingredient, MapCodec, Mix, SuppressWarnings (+4 more)

### Community 44 - "NBT Adapter"
Cohesion: 0.32
Nodes (10): CompoundTag, JsonDeserializationContext, JsonDeserializer, JsonSerializationContext, JsonSerializer, Codec, JsonElement, Override (+2 more)

### Community 45 - "Block Items"
Cohesion: 0.24
Nodes (6): BlockItem, DeferredItem, Block, BlockEntitySupplier, BlockEntityType, SafeVarargs

### Community 46 - "Command Dispatcher"
Cohesion: 0.27
Nodes (7): CommandDispatcher, CommonToolkitCommand, CommandBuildContext, CommandSourceStack, GetDimensionTypeCommand, CommandSourceStack, LiteralArgumentBuilder

### Community 47 - "Config Element Validation"
Cohesion: 0.12
Nodes (10): Pattern, Pattern, tryParse(), Type, BOOLEAN, COLOR, DOUBLE, INTEGER (+2 more)

### Community 48 - "Runnable Reloader"
Cohesion: 0.19
Nodes (12): AbstractContainerScreen, MenuAccess, AbstractContainerScreenMixin, Mixin, CommonToolkitContainerScreen, Component, Inventory, DrawsOnLeft (+4 more)

### Community 50 - "DataGenPopulator"
Cohesion: 0.22
Nodes (3): MustBeInvokedByOverriders, DataGenPopulator, Internal

### Community 51 - "Json Utility"
Cohesion: 0.36
Nodes (4): ByteBuf, Codec, Identifier, StreamCodec

### Community 52 - "Gradient Color"
Cohesion: 0.33
Nodes (3): GradientColor, Override, TextColor

### Community 53 - "Config Flags"
Cohesion: 0.29
Nodes (5): ConfigFlags, Loadability, LOCKED, RELOADABLE, RESTARTABLE

### Community 55 - "Hash Cache Mixin"
Cohesion: 0.53
Nodes (4): HashCacheMixin, CallbackInfo, Inject, Mixin

### Community 56 - "Menu Operations"
Cohesion: 0.40
Nodes (3): IContainerFactory, MenuSupplier, MenuType

### Community 58 - "Sync Types"
Cohesion: 0.09
Nodes (17): CodecException, DynamicRegistry, AddServerReloadListenersEvent, BiMap, ByteBuf, Identifier, JsonElement, Logger (+9 more)

### Community 59 - "Custom Stats"
Cohesion: 0.50
Nodes (3): Identifier, Registrar, StatFormatter

### Community 60 - "Build Scripts"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 66 - "Flujo de trabajo — Common Toolkit (NeoForge)"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Common Toolkit (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 67 - "CurseForge — Variables del proyecto"
Cohesion: 0.18
Nodes (10): CurseForge — Variables del proyecto, Datos para el alta manual (formulario "Create Project"), Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama, Tag (+2 more)

### Community 68 - "Common Toolkit"
Cohesion: 0.18
Nodes (9): Embedded Minecraft Forge code (LGPL-2.1), Placebo — MIT License, Removed from the original, Third-Party Attribution, Build, Common Toolkit, Credits, Features (+1 more)

### Community 69 - "ResourceReloadEvent.java"
Cohesion: 0.57
Nodes (3): LogicalSide, ResourceManager, ResourceReloadEvent

### Community 70 - "CLAUDE.md — common_toolkit (26.2)"
Cohesion: 0.50
Nodes (3): CLAUDE.md — common_toolkit (26.2), Prioridad de instrucciones, Workflow del mod

### Community 71 - "Common Toolkit — Registro de cambios"
Cohesion: 0.29
Nodes (6): 0.0.0-beta.1, [0.0.0-beta.2] - 2026-08-05, [1.0.0] - 2026-08-10, Change, Change, Common Toolkit — Registro de cambios

### Community 74 - "Type"
Cohesion: 0.40
Nodes (5): Type, CLIENT, COMMON, SERVER, SYNCED

### Community 76 - "TickingBlockEntityType.java"
Cohesion: 0.19
Nodes (10): BlockEntityType, Block, BlockEntitySupplier, BlockEntityTicker, Nullable, TickingBlockEntityType, TickSide, CLIENT (+2 more)

### Community 77 - "GearSet"
Cohesion: 0.23
Nodes (7): CodecProvider, Codec, GearSet, Codec, EquipmentSlot, LivingEntity, Override

### Community 78 - "WeightedItemStack"
Cohesion: 0.33
Nodes (6): Codec, EquipmentSlot, ItemStackTemplate, LivingEntity, Override, WeightedItemStack

### Community 80 - "GearSetRegistry.java"
Cohesion: 0.38
Nodes (3): GearSetRegistry, Nullable, RandomSource

### Community 81 - "ILuckyWeighted"
Cohesion: 0.33
Nodes (3): ILuckyWeighted, SuppressWarnings, Weighted

## Knowledge Gaps
- **74 isolated node(s):** `CLIENT`, `SERVER`, `CLIENT_AND_SERVER`, `ConfigFlags`, `COMMON` (+69 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **10 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Configuration` connect `Configuration Loading` to `Pose Stack Operations`, `Property Management`, `Configuration Categories`, `ResourceReloadEvent.java`?**
  _High betweenness centrality (0.156) - this node is a cross-community bridge._
- **Why does `DynamicRegistry` connect `Sync Types` to `Custom Packet Payloads`, `Dynamic Registry Management`, `Codec Providers`, `Server Start Events`, `Reload Listener`, `.elementCodec`, `Dynamic Holder Management`, `DataGenPopulator`, `Json Utility`, `Dynamic Tag Keys`, `Data Provider Management`, `Tag Lookup`, `Registry Conditions`, `Data Generator Populator`, `Common Toolkit Setup`?**
  _High betweenness centrality (0.153) - this node is a cross-community bridge._
- **Why does `ConfigCategory` connect `Configuration Categories` to `Configuration Elements`, `Property Management`, `Configuration Loading`, `Config Element Validation`?**
  _High betweenness centrality (0.098) - this node is a cross-community bridge._
- **What connects `CLIENT`, `SERVER`, `CLIENT_AND_SERVER` to the rest of the system?**
  _74 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Bi-Directional Map` be split into smaller, more focused modules?**
  _Cohesion score 0.05647517039922103 - nodes in this community are weakly interconnected._
- **Should `Container Menu` be split into smaller, more focused modules?**
  _Cohesion score 0.06001984126984127 - nodes in this community are weakly interconnected._
- **Should `Codec Operations` be split into smaller, more focused modules?**
  _Cohesion score 0.09142857142857143 - nodes in this community are weakly interconnected._