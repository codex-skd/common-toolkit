# Common Toolkit — Registro de cambios


## [1.0.1] - 2026-08-12

### Change

- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `common_toolkit-26.2-neoforge-26.2.0.37-beta-1.0.1.jar` (se añade la versión de cargador/NeoForge al nombre del archivo). Empaquetado y documentación; sin cambios de funcionalidad.

## 0.0.0-beta.1
- Port inicial a NeoForge 26.2: base de código reescrita a partir de Placebo 10.0.2 (MC 26.1.2), con mod id `common_toolkit`, paquete `com.skd.commontoolkit` y clase principal `CommonToolkit`.
- Se elimina el sistema de perks cosméticos ligado al Patreon del autor original (ver `NOTICE.md`).

## [0.0.0-beta.2] - 2026-08-05

### Change

- **Recompilado contra NeoForge `26.2.0.37-beta`**: bump de `neo_version` en `gradle.properties` (`26.2.0.32-beta` -> `26.2.0.37-beta`). Verificado con `runServer` (arranque sin errores).

## [1.0.0] - 2026-08-10

### Change

- Primera versión estable del port. Sin cambios funcionales respecto a `0.0.0-beta.2`; verificado funcionando correctamente.
