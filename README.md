# F3 Spec Changer

F3 Spec Changer is a Fabric mod for Minecraft that lets you customize the hardware information displayed in Minecraft's vanilla F3 debug screen.

Instead of displaying your actual hardware information, you can replace the displayed values with any text you want.

## Features

* Change the displayed CPU information.
* Change the displayed GPU information.
* Change the displayed Display information.
* Change the displayed Driver information.
* Simple in-game commands for editing values.
* Works by modifying the vanilla F3 debug screen.

## Commands

| Command        | Description                                |
| -------------- | ------------------------------------------ |
| `/cpuedit`     | Changes the displayed CPU information.     |
| `/gpuedit`     | Changes the displayed GPU information.     |
| `/displayedit` | Changes the displayed Display information. |
| `/driveredit`  | Changes the displayed Driver information.  |

## Installation

1. Install Fabric Loader for Minecraft 26.1.2.
2. Install Fabric API for Minecraft 26.1.2.
3. Download the latest F3 Spec Changer `.jar` file.
4. Place the `.jar` file into your Minecraft `mods` folder.
5. Launch Minecraft.

## Requirements

* Minecraft: 26.1.2
* Fabric Loader
* Fabric API
* Gradle & Gradlew

## Current Limitations

Currently, edited hardware information is not saved between game sessions.

Persistent saving is planned for version 1.1.0, which will allow your custom hardware values to remain after restarting Minecraft.

## Compatibility

F3 Spec Changer is designed to modify the vanilla Minecraft F3 debug screen.

Because of this, it may not be compatible with other mods that:

* Modify the F3 debug screen.
* Replace the vanilla debug overlay.
* Change how hardware information is displayed.

## Development

This project is built using:

* Fabric
* Fabric Loom
* Java

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more information.
