# Common Toolkit — Registro de cambios


## [Unreleased]

### Change

- **Licencia en el código publicado**: el snapshot público incluye ahora `NOTICE.md` (licencia MIT y atribución de Placebo) y `COPYING.LESSER` (LGPL-2.1); antes solo iban dentro del JAR.
- **Enlace del mod**: `displayURL` de `neoforge.mods.toml` apunta ahora al repositorio público de GitHub (`github.com/codex-skd/common-toolkit`).
- **Documentación**: el README y el CHANGELOG ya no citan ficheros de documentación interna que no forman parte del código publicado.

## [1.1.2] - 2026-10-30

### Changed

- **Variables de CurseForge**: `docs/curseforge/project_vars.md` pasa a `docs/curseforge/project.env` (formato env: `PROJECT_ID`, `GAME_VERSIONS`, `RELEASE_TYPE`, `RELATIONS`). La documentación genérica se centraliza en `codex-docs/reference/CURSEFORGE.md` y los scripts de subida y consulta leen el nuevo fichero.
- **Sin cambios en el mod**: solo documentación y tooling. Versión **exenta de subida a CurseForge** (no hay JAR nuevo que publicar); se versiona por ser un cambio de proceso importante.

## [1.1.1] - 2026-10-29

### Changed

- **Tokens de CurseForge**: el token de subida y la clave Core ya no se guardan en `docs/curseforge/project_vars.md`; se leen de las variables de entorno de usuario `API_MOD_UPLOAD_CURSEFORGE` y `API_MOD_GET_CURSEFORGE`. Los scripts de subida y consulta se han adaptado y la documentación se ha actualizado.
- **Sin cambios en el mod**: solo documentación y tooling. Versión **exenta de subida a CurseForge** (no hay JAR nuevo que publicar); se versiona por ser un cambio de proceso importante.

## [1.1.0] - 2026-08-19

### Change

- **Actualización de NeoForge**: actualizado de 26.2.0.45-beta a 26.2.0.57.
- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `common_toolkit-26.2-neoforge-26.2.0.57-1.1.0.jar`.
- **Documentación del workflow**: actualizada la documentación interna para reflejar la nueva rama de trabajo.

## [1.0.2] - 2026-08-17

### Change

- **Actualización de NeoForge**: actualizado de 26.2.0.37-beta a 26.2.0.45-beta.
- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `common_toolkit-26.2-neoforge-26.2.0.45-beta-1.0.2.jar`.
- **Documentación del workflow**: actualizada la documentación interna para reflejar la nueva rama de trabajo.

---

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
