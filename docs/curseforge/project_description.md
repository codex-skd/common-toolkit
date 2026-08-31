<h1 align="center">&#129513; Common Toolkit</h1>

<p align="center"><strong>A NeoForge library mod providing shared developer utilities: declarative config, networking helpers, dynamic JSON-driven registries with client sync, weighted gear/brewing-mix systems, and creative tab filling.</strong></p>

<p align="center">
<img src="https://img.shields.io/badge/loader-NeoForge-orange?style=plastic&logo=curseforge" alt="NeoForge">
<img src="https://img.shields.io/badge/minecraft-1.21.1%20%7C%2026.2-blue?style=plastic" alt="Minecraft 1.21.1 and 26.2">
<img src="https://img.shields.io/badge/type-library-brightgreen?style=plastic" alt="Library">
</p>

<br>

---

<br>

<h2>&#10024; Overview</h2>

<table>
<tr>
<td width="65%">
<p>Common Toolkit is not a gameplay mod by itself &mdash; it is a <strong>library</strong> that other mods depend on. It bundles a set of infrastructure pieces that are tedious to rebuild from scratch for every mod: config declaration, network payload plumbing, JSON/datapack-driven registries that stay in sync between server and client, dynamic tags for those registries, and a couple of ready-made registries (gear sets, brewing mixes) built on top of that infrastructure.</p>

<p>If you were told to install this mod, it's because another mod on the pack depends on it &mdash; it adds no content on its own.</p>
</td>
<td width="35%" align="center">
<a href="https://codex.skdragons.com/" target="_blank"><img src="https://node-files.skdragons.com/uploads/MINECRAFT/Codex/logo_codex_stalking_dragons.png" alt="Codex Stalking Dragons" width="160"></a>
</td>
</tr>
</table>

<br>

<h2>&#127919; Features</h2>

<h3>&#9881;&#65039; Configuration</h3>
<p>Declarative common/client/server config definitions with an in-game config screen, without the boilerplate of hand-rolling a <code>ModConfigSpec</code> for every value.</p>

<h3>&#128260; Dynamic Registries</h3>
<p>JSON-driven registries that reload with datapacks and automatically sync their contents from server to client over the network &mdash; both weighted (for random-selection use cases) and unweighted variants.</p>

<h3>&#127991;&#65039; Dynamic Tags</h3>
<p>A tag system for the dynamic registries above: <code>#namespace:tag</code> references in datapack JSON, resolved after content load and synced to the client, mirroring how vanilla tags work for built-in registries.</p>

<h3>&#128225; Networking Helper</h3>
<p>A thin layer over NeoForge's payload API that removes the repetitive registration/handling boilerplate for custom network packets.</p>

<h3>&#127919; Gear Sets &amp; Brewing Mixes</h3>
<p>Two ready-made dynamic registries built on the framework above: weighted, JSON-configurable equipment sets and custom brewing recipes, meant to be consumed by other mods' game logic.</p>

<h3>&#128230; Creative Tab Filling</h3>
<p>Declarative registry to inject items into existing creative tabs (vanilla or modded) without writing an event handler per mod.</p>

<h3>&#127752; Color &amp; Codec Utilities</h3>
<p>Gradient color helpers and common <code>Codec</code>/<code>StreamCodec</code> building blocks shared across the utilities above.</p>

<br>

<h2>&#129521; Mod Structure</h2>

<p>Internally the library is organised into self-contained subsystems. Other mods pick only the pieces they need &mdash; nothing here runs unless a dependent mod calls into it.</p>

<table>
<tr><th align="left">Area</th><th align="left">What it provides</th></tr>
<tr><td><code>config</code></td><td>Declarative configuration system (common/client/server) with an in-game screen. Derived from Minecraft Forge's legacy config system (LGPL-2.1, see <code>NOTICE.md</code>).</td></tr>
<tr><td><code>dynreg</code></td><td>Core dynamic-registry framework: datapack reload, server&#8594;client sync, weighted and unweighted variants, per-registry serializers.</td></tr>
<tr><td><code>dynreg/tag</code></td><td>Dynamic tags for those registries: tag keys, holder sets, datapack tag loading and client sync.</td></tr>
<tr><td><code>network</code> / <code>payloads</code></td><td>Payload registration/handling helpers over the NeoForge networking API.</td></tr>
<tr><td><code>systems/gear</code></td><td>Weighted, JSON-configurable equipment-set registry built on <code>dynreg</code>.</td></tr>
<tr><td><code>systems/mixes</code></td><td>JSON-configurable custom brewing-mix registry built on <code>dynreg</code>.</td></tr>
<tr><td><code>tabs</code></td><td>Declarative creative-tab injection registry.</td></tr>
<tr><td><code>codec</code> / <code>json</code> / <code>color</code></td><td>Shared <code>Codec</code>/<code>StreamCodec</code> building blocks, JSON helpers and gradient-colour utilities.</td></tr>
<tr><td><code>menu</code> / <code>screen</code></td><td>Container-menu and screen helpers (data slots, filtered slots, tickable text).</td></tr>
<tr><td><code>block_entity</code> / <code>datagen</code> / <code>commands</code></td><td>Ticking block-entity helpers, data-generation helpers, and debug commands (<code>/common_toolkit</code>).</td></tr>
</table>

<br>

<h2>&#128196; Requirements</h2>

<table>
<tr><td><strong>Minecraft</strong></td><td>1.21.1</td></tr>
<tr><td><strong>NeoForge</strong></td><td>21.1.249+</td></tr>
<tr><td><strong>Java</strong></td><td>21+</td></tr>
<tr><td><strong>Side</strong></td><td>Client and Server (required on both)</td></tr>
</table>

<br>

<h2>&#128230; Available Versions</h2>

<table>
<tr><th align="left">Minecraft</th><th align="left">NeoForge</th><th align="left">Java</th><th align="left">Latest build</th><th align="left">Status</th></tr>
<tr><td>1.21.1</td><td>21.1.249+</td><td>21</td><td><code>0.0.0-beta.1</code></td><td>Beta &mdash; re-fork port from upstream Placebo 1.21.1</td></tr>
<tr><td>26.2</td><td>26.2.0.32-beta+</td><td>25</td><td><code>1.1.0</code></td><td>Stable</td></tr>
</table>

<p><em>Both versions share this CurseForge project. Pick the file that matches your Minecraft version &mdash; the API surface is the same across both, only the underlying platform differs.</em></p>

<br>

<h2>&#127918; How to Use</h2>

<ol>
<li>Install as a <strong>dependency</strong> of another mod that requires it, on both client and server.</li>
<li>No configuration is needed to simply run it &mdash; it only exposes APIs and registries for other mods to build on.</li>
</ol>

<br>

---

<br>

<h2>&#128591; Credits</h2>

<p>Common Toolkit is a rewritten, independently branded port of <a href="https://www.curseforge.com/minecraft/mc-mods/placebo">Placebo</a> by <strong>Shadows_of_Fire</strong> (MIT License), under a new mod id, package and API. The <code>1.21.1</code> build is a re-fork from the upstream Placebo 1.21.1 sources; the <code>26.2</code> build targets the current NeoForge line. The original Patreon-gated cosmetic system was not ported. See the repository's <code>NOTICE.md</code> for full attribution, including an embedded LGPL-2.1 portion originally from Minecraft Forge's configuration system.</p>

<p>Developed by <strong>Stalking Dragons</strong>.</p>

<br>
<br>

<p align="center">
  <a href="https://codex.skdragons.com/" target="_blank">
    <img src="https://node-files.skdragons.com/uploads/MINECRAFT/Codex/logo_codex_stalking_dragons.png" alt="Codex Stalking Dragons" width="200">
  </a>
  <br>
  <a href="https://codex.skdragons.com/">https://codex.skdragons.com/</a>
  <br>
  <em>Codex Stalking Dragons &mdash; Minecraft Modding</em>
</p>
