# 🌌 RecallPotion

A lightweight, specialized Paper plugin designed to bring balance and immersion to the traditional Home System.

### 📜 Overview

**RecallPotion** was originally developed for personal server use. Its primary goal is to **add a tangible cost** to home-bound transportation. Instead of relying on a simple, cost-free `/home` command, players must now craft a magical catalyst—the **Recall Potion**—to return to their spawn point or bed.

-----

### ✨ Features

  * **Immersive Teleportation**: Consuming the potion teleports the player to their bed spawn location or the world spawn.
  * **Custom Brewing Mechanics**: Leverages the `PotionMix` API to introduce a unique brewing recipe.
  * **Data Component Integration**: Uses modern Minecraft data components for custom colors (`#334156`) and a permanent enchantment glint.
  * **Dynamic Brewing Speed**: Adjusts brewing time specifically for this recipe to ensure a balanced crafting experience.
  * **Adventure API**: Fully supports modern text components for clean, non-buggy item naming.

-----

### 🧪 The Recipe

To craft a **Recall Potion**, use a Brewing Stand with the following ingredients:

| Input (Bottom) | Ingredient (Top) | Result | Brewing Time |
| :--- | :--- | :--- | :--- |
| **Thick Potion** | **Echo Shard** 💎 | **§3Recall Potion** | **120s** (2400 Ticks) |

> **Note**: The resulting potion features a deep teal color and a distinct magical glow.

-----

### 🛠️ Technical Details

  * **`BrewingRegistry`**: Manages the registration of the custom `PotionMix` using `NamespacedKey`.
  * **`BrewingListener`**: Monitors `BrewingStartEvent` to intercept and set the specific 2400-tick brewing duration for Echo Shards.
  * **`PlayerItemConsumeEvent`**: Handles the logic for teleportation, playing the `BLOCK_PORTAL_TRAVEL` sound upon consumption.

-----

### 🚀 Installation

1.  Download the latest `.jar` from the [Releases](https://github.com/User-Time/recallPotion/releases/latest) page.
2.  Place the file into your server's `plugins` folder.
3.  Restart your server.
4.  Ensure your players have set a bed or anchor, then start brewing\!

-----

### ⚖️ License

This project is licensed under the **Apache License 2.0**. Feel free to use, modify, and distribute it for your own server needs\!
