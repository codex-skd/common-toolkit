<h1 align="center">&#129513; Common Toolkit</h1>

<p align="center"><strong>A NeoForge library mod providing shared developer utilities: declarative config, networking helpers, dynamic JSON-driven registries with client sync, weighted gear/brewing-mix systems, and creative tab filling.</strong></p>

<p align="center">
<img src="https://img.shields.io/badge/loader-NeoForge-orange?style=plastic&logo=curseforge" alt="NeoForge">
<img src="https://img.shields.io/badge/minecraft-26.2-blue?style=plastic" alt="Minecraft 26.2">
</p>

<br>

---

<br>

<h2>&#10024; Overview</h2>

<table>
<tr>
<td width="65%">
<p>Common Toolkit is not a gameplay mod by itself — it is a <strong>library</strong> that other mods depend on. It bundles a set of infrastructure pieces that are tedious to rebuild from scratch for every mod: config declaration, network payload plumbing, JSON/datapack-driven registries that stay in sync between server and client, and a couple of ready-made registries (gear sets, brewing mixes) built on top of that infrastructure.</p>

<p>If you were told to install this mod, it's because another mod on the pack depends on it — it adds no content on its own.</p>
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
<p>JSON-driven registries that reload with datapacks and automatically sync their contents from server to client over the network — both weighted (for random-selection use cases) and unweighted variants.</p>

<h3>&#128225; Networking Helper</h3>
<p>A thin layer over NeoForge's payload API that removes the repetitive registration/handling boilerplate for custom network packets.</p>

<h3>&#127919; Gear Sets &amp; Brewing Mixes</h3>
<p>Two ready-made dynamic registries built on the framework above: weighted, JSON-configurable equipment sets and custom brewing recipes, meant to be consumed by other mods' game logic.</p>

<h3>&#128230; Creative Tab Filling</h3>
<p>Declarative registry to inject items into existing creative tabs (vanilla or modded) without writing an event handler per mod.</p>

<h3>&#127752; Color &amp; Codec Utilities</h3>
<p>Gradient color helpers and common <code>Codec</code>/<code>StreamCodec</code> building blocks shared across the utilities above.</p>

<br>

<h2>&#128196; Requirements</h2>

<table>
<tr><td><strong>Minecraft</strong></td><td>26.2</td></tr>
<tr><td><strong>NeoForge</strong></td><td>26.2.0.32-beta+</td></tr>
<tr><td><strong>Side</strong></td><td>Client and Server (required on both)</td></tr>
</table>

<br>

<h2>&#127918; How to Use</h2>

<ol>
<li>Install as a <strong>dependency</strong> of another mod that requires it, on both client and server.</li>
<li>No configuration is needed to simply run it — it only exposes APIs and registries for other mods to build on.</li>
</ol>

<br>

---

<br>

<h2>&#128591; Credits</h2>

<p>Common Toolkit is a rewritten, independently branded port of <a href="https://www.curseforge.com/minecraft/mc-mods/placebo">Placebo</a> by <strong>Shadows_of_Fire</strong> (MIT License), retargeted to Minecraft 26.2 under a new mod id, package and API. The original Patreon-gated cosmetic system was removed. See the repository's <code>NOTICE.md</code> for full attribution, including an embedded LGPL-2.1 portion originally from Minecraft Forge's configuration system.</p>

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
  <em>Codex Stalking Dragons — Minecraft Modding</em>
</p>
