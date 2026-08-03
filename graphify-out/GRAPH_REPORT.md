# Graph Report - .  (2026-08-04)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 1668 nodes · 3457 edges · 65 communities (56 shown, 9 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 173 edges (avg confidence: 0.8)
- Token cost: 2,796 input · 619 output

## Graph Freshness
- Built from commit: `b782cdf3`
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

## Communities (65 total, 9 thin omitted)

### Community 0 - "Bi-Directional Map"
Cohesion: 0.06
Nodes (20): BiMap, ForwardingMap, ForwardingMapEntry, ForwardingSet, ObjectInputStream, ObjectOutputStream, DynRegBiMap, Identifier (+12 more)

### Community 1 - "Container Menu"
Cohesion: 0.05
Nodes (38): AbstractContainerMenu, AbstractContainerScreen, ItemStacksResourceHandler, MenuAccess, ResourceHandler, ResourceHandlerSlot, Slot, InternalItemHandler (+30 more)

### Community 2 - "Codec Operations"
Cohesion: 0.07
Nodes (33): Codec, CodecMap, BiMap, DataResult, DynamicOps, Identifier, Nullable, Override (+25 more)

### Community 3 - "Custom Packet Payloads"
Cohesion: 0.08
Nodes (35): CustomPacketPayload, Content, DynRegPayloads, End, ByteBuf, ConnectionProtocol, Either, FriendlyByteBuf (+27 more)

### Community 4 - "Attribute Handling"
Cohesion: 0.07
Nodes (29): AttributeModifier, Float2FloatFunction, Operation, CommonToolkitCodecs, BiMap, Codec, Deprecated, Identifier (+21 more)

### Community 5 - "Data Generation"
Cohesion: 0.06
Nodes (28): DataGenerator, GatherDataEventGenerator, Overwrite, PackResources, PackType, FieldOrderingFactory, Impl, Identifier (+20 more)

### Community 6 - "Block Entities"
Cohesion: 0.06
Nodes (34): BlockEntity, BooleanConsumer, BooleanSupplier, DataSlot, EntityBlock, IntConsumer, IntSupplier, SimpleEnergyHandler (+26 more)

### Community 7 - "Dynamic Registry Management"
Cohesion: 0.07
Nodes (19): CodecException, MustBeInvokedByOverriders, DynamicRegistry, AddServerReloadListenersEvent, BiMap, ByteBuf, Codec, Identifier (+11 more)

### Community 8 - "Codec Providers"
Cohesion: 0.06
Nodes (30): CodecProvider, Codec, ReloadType, DEDICATED_CLIENT, INTEGRATED_CLIENT, SERVER, IDimensional, ILuckyWeighted (+22 more)

### Community 9 - "Payload Handlers"
Cohesion: 0.07
Nodes (30): HandlerThread, IPayloadHandler, RegisterPayloadHandlersEvent, ConnectionProtocol, IPayloadContext, Override, PacketFlow, SubscribeEvent (+22 more)

### Community 12 - "Font Handling"
Cohesion: 0.09
Nodes (18): Font, FormattedCharSequence, FormattedCharSink, MutableFloat, AbstractContainerScreenMixin, Mixin, FormattedText, GuiGraphicsExtractor (+10 more)

### Community 13 - "Configuration Loading"
Cohesion: 0.09
Nodes (8): Entry, CommonToolkitConfig, Configuration, CharMatcher, Logger, Override, Pattern, UnicodeInputStreamReader

### Community 14 - "Config Element Types"
Cohesion: 0.05
Nodes (10): ConfigGuiType, BOOLEAN, COLOR, CONFIG_CATEGORY, DOUBLE, INTEGER, MOD_ID, STRING (+2 more)

### Community 15 - "Dynamic Holder Management"
Cohesion: 0.11
Nodes (7): DynamicHolder, Identifier, Override, SuppressWarnings, Direct, Override, RandomSource

### Community 16 - "Event Handling"
Cohesion: 0.11
Nodes (20): Event, IModBusEvent, LogicalSide, Internal, RegisterFieldOrderingsEvent, AnvilLandEvent, BlockPos, BlockState (+12 more)

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
Cohesion: 0.14
Nodes (8): Internal, Named, DynamicTagKey, ByteBuf, Codec, Identifier, Override, StreamCodec

### Community 23 - "Entity Types"
Cohesion: 0.10
Nodes (20): AttachmentType, EntityFactory, EntityType, Feature, Fluid, IAttachmentHolder, MobCategory, NewRegistryEvent (+12 more)

### Community 24 - "Data Provider Management"
Cohesion: 0.13
Nodes (11): DataProvider, DynamicTagProvider, CachedOutput, Identifier, Override, PackOutput, PathProvider, Provider (+3 more)

### Community 25 - "Server Events"
Cohesion: 0.14
Nodes (16): ServerStartedEvent, ServerStoppedEvent, CommonToolkitTaskQueue, DelayedTask, Impl, EventBusSubscriber, FunctionalInterface, Identifier (+8 more)

### Community 26 - "Pose Stack Operations"
Cohesion: 0.12
Nodes (19): Int2IntFunction, PoseStack, AnchorPoint, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_RIGHT, MIDDLE_CENTER, MIDDLE_LEFT (+11 more)

### Community 27 - "Tag Lookup"
Cohesion: 0.17
Nodes (14): Lookup, SequencedSet, Identifier, ScannedTags, EntryWithSource, ConditionalOps, Identifier, JsonElement (+6 more)

### Community 28 - "Client Reload Listeners"
Cohesion: 0.12
Nodes (13): AddClientReloadListenersEvent, FMLClientSetupEvent, ItemTooltipEvent, MouseScrollingEvent, Pre, CommonToolkitClient, EventBusSubscriber, ItemStack (+5 more)

### Community 29 - "Registry Conditions"
Cohesion: 0.16
Nodes (12): ICondition, RegistryBootstrap, RegistrySetBuilder, DataGenBuilder, DataProviderFactory, Factory, FunctionalInterface, GatherDataEvent (+4 more)

### Community 30 - "Data Generator Populator"
Cohesion: 0.16
Nodes (11): DataGenPopulator, DynamicRegistryProvider, CachedOutput, Deprecated, Factory, GatherDataEvent, Identifier, Override (+3 more)

### Community 31 - "Common Toolkit Setup"
Cohesion: 0.15
Nodes (10): FMLCommonSetupEvent, IEventBus, Mod, RegisterCommandsEvent, CommonToolkit, AddServerReloadListenersEvent, Identifier, Logger (+2 more)

### Community 32 - "Dynamic Holder Set"
Cohesion: 0.13
Nodes (9): DynamicHolderSet, Codec, Either, RegistryFriendlyByteBuf, StreamCodec, SuppressWarnings, GearSetRegistry, Nullable (+1 more)

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
Cohesion: 0.27
Nodes (6): ServerAboutToStartEvent, Mix, Override, PotionBrewing, SuppressWarnings, MixRegistry

### Community 40 - "Block Entity Types"
Cohesion: 0.19
Nodes (10): BlockEntityType, Block, BlockEntitySupplier, BlockEntityTicker, Nullable, TickingBlockEntityType, TickSide, CLIENT (+2 more)

### Community 41 - "Server Player Management"
Cohesion: 0.20
Nodes (8): ServerPlayer, CommonToolkitUtil, BlockPos, Component, Deprecated, ItemStack, SafeVarargs, SuppressWarnings

### Community 42 - "Reload Listener"
Cohesion: 0.27
Nodes (9): SimplePreparableReloadListener, Logger, DynamicTagManager, ConditionalOps, Identifier, JsonElement, Override, ProfilerFiller (+1 more)

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
Cohesion: 0.40
Nodes (5): Override, ProfilerFiller, ResourceManager, RunnableReloader, Unit

### Community 51 - "Json Utility"
Cohesion: 0.50
Nodes (5): ConditionalOps, Identifier, JsonElement, Logger, JsonUtil

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
Cohesion: 0.40
Nodes (5): Type, CLIENT, COMMON, SERVER, SYNCED

### Community 59 - "Custom Stats"
Cohesion: 0.50
Nodes (3): Identifier, Registrar, StatFormatter

### Community 60 - "Build Scripts"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Knowledge Gaps
- **42 isolated node(s):** `CLIENT`, `SERVER`, `CLIENT_AND_SERVER`, `ConfigFlags`, `COMMON` (+37 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **9 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `DynamicRegistry` connect `Dynamic Registry Management` to `Dynamic Holder Set`, `Codec Operations`, `Custom Packet Payloads`, `Server Start Events`, `Codec Providers`, `Reload Listener`, `Dynamic Holder Management`, `Dynamic Tag Keys`, `Data Provider Management`, `Tag Lookup`, `Data Generator Populator`?**
  _High betweenness centrality (0.166) - this node is a cross-community bridge._
- **Why does `Configuration` connect `Configuration Loading` to `Event Handling`, `Pose Stack Operations`, `Property Management`, `Configuration Categories`?**
  _High betweenness centrality (0.163) - this node is a cross-community bridge._
- **Why does `ConfigCategory` connect `Configuration Categories` to `Configuration Elements`, `Property Management`, `Configuration Loading`, `Config Element Validation`?**
  _High betweenness centrality (0.102) - this node is a cross-community bridge._
- **What connects `CLIENT`, `SERVER`, `CLIENT_AND_SERVER` to the rest of the system?**
  _42 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Bi-Directional Map` be split into smaller, more focused modules?**
  _Cohesion score 0.05647517039922103 - nodes in this community are weakly interconnected._
- **Should `Container Menu` be split into smaller, more focused modules?**
  _Cohesion score 0.05311871227364185 - nodes in this community are weakly interconnected._
- **Should `Codec Operations` be split into smaller, more focused modules?**
  _Cohesion score 0.06692242114236999 - nodes in this community are weakly interconnected._