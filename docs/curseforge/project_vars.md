# CurseForge — Variables del proyecto

> Las siguientes variables son leídas automáticamente por `../codex-docs/scripts/curseforge-upload.ps1`

project_id = TBD (pendiente de alta manual en CurseForge — no existe endpoint API para crear proyectos)
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
game_versions = TBD (rellenar tras el alta, según el listado real de versiones/entornos de CurseForge para MC 26.2 + NeoForge)
release_type = beta

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | pendiente — se asigna al crear el proyecto en https://www.curseforge.com/software/create |
| `mod_id` | `common_toolkit` |
| `display_name` | `Common Toolkit` (separado, no junto) |

## Datos para el alta manual (formulario "Create Project")

| Campo del formulario | Valor a usar |
|---|---|
| Project Name | `Common Toolkit` |
| Slug/URL | `common-toolkit` (verificar disponibilidad; si está ocupado, `common-toolkit-mod`) |
| Summary (resumen corto) | `A NeoForge library mod providing shared developer utilities: config, networking, dynamic JSON registries, gear/mix systems.` |
| Category | Library / API |
| License | All Rights Reserved (mod propio) — ver `NOTICE.md` en la raíz del repo para la atribución MIT/LGPL-2.1 del código heredado de Placebo |
| Game | Minecraft |
| Mod Loader | NeoForge |
| Client/Server | Both |
| Description | Contenido de `project_description.md` (HTML) |
| Issue tracker | URL del repo (GitHub, tras el mirror) |
| Source URL | URL del repo (GitHub, tras el mirror) |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR (token de cuenta, compartido entre proyectos) |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

## Versión actual

| Variable | Valor |
|----------|-------|
| `minecraft_version` | `26.2` |
| `framework` | `neoforge` |
| `java_version` | `25` |
| `environment` | `Client`, `Server` |

## Rama

```
minecraft/26.2/neoforge-26.2.0.32-beta/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo (primera beta): `26.2-neoforge-beta.1`

## Parámetros del upload

| Campo | Valor | Notas |
|-------|-------|-------|
| `displayName` | `Common Toolkit (0.0.0-beta.1)` | Nombre visible: `display_name (version)` |
| `changelog` | HTML (no Markdown) | Ver estructura abajo |
| `changelogType` | `html` | Obligatorio para que se vea bien |
| `release_type` | `beta` | Primera subida — no promocionar a `release` hasta validar en servidor real |
| `gameVersionNames` | `["Client", "Server", "26.2", "NeoForge"]` | Entorno + MC + modloader |

## Estructura del changelog (HTML)

```html
<h2>v0.0.0-beta.1 - Titulo descriptivo</h2>

<h3>Fix</h3>
<ul>
<li><strong>Problema</strong>: descripcion con <code>codigo</code>.</li>
</ul>

<h3>Technical Changes</h3>
<ul>
<li><code>Clase/metodo()</code> — descripcion.</li>
</ul>

<h3>Notes</h3>
<blockquote>Nota importante para servidores.</blockquote>

<hr>

<p><strong>JAR</strong>: <code>common_toolkit-26.2-neoforge-0.0.0-beta.1.jar</code></p>
```

## Flujo completo (una vez el proyecto exista en CurseForge)

1. Crear el proyecto manualmente con los datos de la tabla de arriba → anotar `curseforge_project_id` aquí.
2. `./gradlew clean build`
3. Actualizar `docs/curseforge/versions/<version>.md` con HTML
4. Actualizar `CHANGELOG.md`
5. `git commit -m "fix: descripcion\n\nvX.Y.Z"` + `git push`
6. `git tag -a 26.2-neoforge-<version> -m "vX.Y.Z: descripcion"` + `git push origin <tag>`
7. Subir JAR a CurseForge (script `curseforge-upload.ps1` una vez haya `project_id`)
8. Verificar con GET que el changelog se vea bien
9. Liberar manualmente desde la web si es necesario
