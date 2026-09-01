# Common Toolkit (1.21.1) — Registro de cambios

Rama `minecraft/1.21.1/neoforge-21.1.249/production`. Historial independiente de la rama 26.2.

## [0.0.0-beta.3] - 2026-09-01

### Added

- **`GearSetRegistry.getRandomSet(RandomSource, float, List<GearSet.SetPredicate>)`** — sobrecarga que
  refleja la API de Placebo upstream, donde los datos de bosses/invasores guardan los gear sets como
  `List<SetPredicate>` (entradas tipo `"#mi_mod:mi_tag"` o un id de set). Los predicados se combinan con
  OR lógico. Sin esto, portar `BasicBossData` de Apotheosis 1.21 obligaba a reescribir su codec a
  `DynamicHolderSet`, rompiendo el parseo de los ficheros `apothic_invaders` / `apothic_elites` que usan
  refs de tag con prefijo `#`.

## [0.0.0-beta.2] - 2026-08-31

### Fixed

- **Crash en carga inicial** (`DatagenModLoaderMixin`): el `@Inject` apuntaba a `DatagenModLoader.begin` con una firma obsoleta de Forge (5 booleans + `Runnable` / `DataGenerator` / `Consumer`), incompatible con NeoForge 21.1.249 que usa `(Set, Path, Collection, Collection, Set, 6x boolean, String, File)`. Corregida la firma del mixin para coincidir con `net.neoforged.neoforge.data.loading.DatagenModLoader` real; elimina el `MixinApplyError: Invalid descriptor` que cerraba el juego al iniciar.

## [0.0.0-beta.1] - 2026-08-31

### Added

- **Port inicial a Minecraft 1.21.1 / NeoForge 21.1.249** (Java 21). Estrategia: **re-fork** desde el Placebo original para 1.21.1 (Placebo 9.9.2, NeoForge 21.1.187), reaplicando la identidad de Common Toolkit y las adiciones del fork 26.2 sobre la API 1.21.1 — no es un back-port del código 26.2.
- Paridad de funcionalidad con la rama 26.2: config declarativa, registros dinámicos JSON con sync a cliente, **sistema de tags dinámicos** (`dynreg/tag`), helper de red, gear sets, brewing mixes, creative tab filling, utilidades de color/codec.
- Sistema de perks cosméticos de Patreon: **no portado** (igual que en 26.2, ver `NOTICE.md`).

### Technical

- Logging unificado en SLF4J en todo el mod.
- `dynreg/tag/*` adaptado a la API 1.21.1 (`HolderSet`, `TagEntry.Lookup#element(ResourceLocation)`, `ResourceLocation.tryParse` nullable).
- `neoforge.mods.toml`: añadidos `modLoader`/`loaderVersion` (`loader_version_range=[1,)`), que la plantilla del 26.2 omite y 1.21.1 exige.
- `OptionalTemplateCodec` (dependía de `ItemStackTemplate`, inexistente en 1.21.1) descartado; `WeightedItemStack` usa `OptionalStackCodec` + `ItemStack` como en Placebo 1.21.1.
- Verificado: `./gradlew build` correcto; `./gradlew runServer` arranca sin errores de carga ni de mixin.
- Detalle completo del port en `docs/PORT_REPORT_1.21.1.md`.
