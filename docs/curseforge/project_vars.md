# CurseForge — Variables del proyecto

> Las siguientes variables son leídas automáticamente por `../../codex-docs/scripts/curseforge-upload.ps1`

project_id = 1638419
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
game_versions = 9638, 9639, 11779, 10150
release_type = beta

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | `1638419` |
| `mod_id` | `common_toolkit` |
| `display_name` | `Common Toolkit` (separado, no junto) |
| `slug` / URL | `common-toolkit` |

> El proyecto de CurseForge es **compartido entre las versiones de Minecraft** de este mod
> (26.2 y 1.21.1). Cada JAR se sube al mismo `project_id`; CurseForge las separa por las
> game versions declaradas en el fichero.

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR (token de cuenta, compartido entre proyectos) |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

## Versión actual (rama 1.21.1)

| Variable | Valor |
|----------|-------|
| `minecraft_version` | `1.21.1` |
| `neo_version` (loader) | `21.1.249` |
| `framework` | `neoforge` |
| `java_version` | `21` |
| `mod_version` | `0.0.0-beta.1` |
| `environment` | `Client`, `Server` (requerido en ambos) |

## Rama

```
minecraft/1.21.1/neoforge-21.1.249/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo (primera beta del port): `1.21.1-neoforge-0.0.0-beta.1`

## Parámetros del upload

| Campo | Valor | Notas |
|-------|-------|-------|
| `displayName` | `Common Toolkit (0.0.0-beta.1)` | Nombre visible: `display_name (mod_version)` — lo compone el script |
| `changelog` | HTML (contenido literal de `docs/curseforge/versions/<version>.md`) | No resumir ni modificar |
| `changelogType` | `html` | Obligatorio para que se vea bien |
| `releaseType` | `beta` | Primera beta del port a 1.21.1. Releases estables usarán `release` |
| `gameVersions` | `[9638, 9639, 11779, 10150]` | **IDs numéricos**, no nombres. Client + Server + 1.21.1 + NeoForge |
| `JAR` | `common_toolkit-1.21.1-neoforge-21.1.249-0.0.0-beta.1.jar` | En `build/libs/` tras `./gradlew clean build` |

### IDs de `gameVersions` para 1.21.1

Verificados 2026-08-31 contra `GET https://minecraft.curseforge.com/api/game/versions`
(cabecera `X-Api-Token`) y contra un fichero 1.21.1 ya publicado de `armor_cosmetic`:

| Nombre | ID | gameVersionTypeID |
|--------|-----|--------|
| `Client` | `9638` | 75208 |
| `Server` | `9639` | 75208 |
| `1.21.1` | `11779` | 77784 |
| `NeoForge` | `10150` | 68441 |

> Ojo: la API devuelve **tres** entradas con nombre `1.21.1` (`11779` typeId 77784,
> `12735` typeId 1, `16115` typeId 615). La correcta para ficheros NeoForge es **`11779`**
> — es la que usan los ficheros 1.21.1 ya publicados. Verificar siempre contra un fichero
> real antes de cambiarla.

## Entorno "Client & Server"

No requiere paso manual: CurseForge lo deriva de las game versions. `game_versions` **debe
incluir siempre `9638` (Client) y `9639` (Server)** además de MC y NeoForge. Con ambos, el
fichero se publica como `Client & Server` automáticamente.

## Descripción del proyecto

No hay endpoint de API para actualizar la descripción general. Se edita manualmente desde la
web de CurseForge pegando el HTML de `docs/curseforge/project_description.md`. La descripción
es **común al proyecto** (no por versión de MC) — al publicar el port 1.21.1 hay que revisar
que la descripción de la web refleje ambas ramas (ver la tabla de versiones en
`project_description.md`).

## Verificar con GET

```bash
curl -s "https://api.curseforge.com/v1/mods/1638419/files/<FILE_ID>" \
  -H "x-api-key: \$2a\$10\$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO"
```

## Flujo completo

1. Proyecto ya creado (`project_id = 1638419`), compartido con la rama 26.2.
2. `./gradlew clean build`
3. Crear/actualizar `docs/curseforge/versions/<version>.md` (HTML)
4. Actualizar `CHANGELOG.md`
5. `git commit -m "chore: release <version>" + git push`
6. `git tag -a 1.21.1-neoforge-<version> -m "v<version>: <descripción>"` + `git push origin <tag>`
7. Subir JAR: `powershell -File ../../codex-docs/scripts/curseforge-upload.ps1` (desde este repo)
8. Verificar con GET que el changelog se vea bien
9. Liberar manualmente desde la web si es necesario
10. Actualizar la descripción del proyecto en la web si cambió `project_description.md`
