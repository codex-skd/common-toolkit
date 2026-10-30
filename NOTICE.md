# Third-Party Attribution

Common Toolkit is a rewritten/rebranded port of **Placebo** by Shadows_of_Fire (Brennan Ward), originally licensed under the MIT License. The overall mod id, Java package, main class, assets and API surface were changed; substantial portions of the underlying logic were carried over and adapted for Minecraft 26.2.

## Placebo — MIT License

```
MIT License

Copyright (c) 2019 Brennan Ward

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Embedded Minecraft Forge code (LGPL-2.1)

Placebo's configuration system (`dev.shadowsoffire.placebo.config`, ported here as `com.skd.commontoolkit.config`) is itself derived from **Minecraft Forge**'s legacy configuration system, licensed under the **GNU Lesser General Public License v2.1**. The original LGPL header is preserved verbatim at the top of every source file derived from it, as required by the license. Full source of this mod is distributed alongside the compiled artifact (see the project's GitLab/GitHub repository), satisfying LGPL-2.1's source-availability requirement.

```
Minecraft Forge
Copyright (c) 2016-2018.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation version 2.1
of the License.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
```

## Removed from the original

The Patreon-gated cosmetic perk system present in upstream Placebo (`patreon/`, `patreon/wings/`, `PatreonDisablePayload`, the `PatreonTrails.txt`/`PatreonWings.txt` supporter lists) was **not** ported. It was tied to the original author's personal Patreon and is out of scope for an independently branded mod.
