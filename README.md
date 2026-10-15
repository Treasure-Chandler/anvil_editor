# Anvil Editor

**A desktop tool for exploring and editing Minecraft: Bedrock Edition world data!**

Anvil Editor is an application designed to make Minecraft: Bedrock Edition world data easier to inspect, navigate, and modify. By providing an interface for LevelDB records and NBT data, Anvil Editor aims to make world data more accessible without requiring users to manually interpret binary files.

## Overview

Minecraft: Bedrock Edition stores world information using a LevelDB-based database and structured binary data formats. Working with these files directly can be hard without the right tools or knowledge.

Anvil Editor aims to provide a user-friendly interface for browsing world records, exploring nested NBT structures, and safely editing (supported) values.

## Features

Coming soon! Currently in development...

## Quick Start

### Prerequisites

Before running Anvil Editor, install:
- **JDK 21 or newer** — the project mainly compiles for Java 21, though you can use a newer JDK if needed.
   - Install for [Windows](https://www.oracle.com/java/technologies/downloads/#jdk21-windows), [MacOS](https://www.oracle.com/java/technologies/downloads/#jdk21-mac), or [Linux](https://www.oracle.com/java/technologies/downloads/#jdk21-linux)
- **[Visual Studio Code](https://code.visualstudio.com/download?_exp_download=d53503e735)** (recommended).
- **[Extension Pack for Java for VS Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)** (recommended).

Maven is included through the Maven Wrapper, so a separate Maven installation is not required!

### 1. Clone the Repository

Clone the repository and open the project folder in VS Code.

### 2. Launch the Editor

From the repository root, run this launcher script:

```powershell
.\run-anvil-editor.bat
```

The launcher automatically searches common installation locations for a JDK, configures `JAVA_HOME` for the current session, compiles the project, then launches Anvil Editor.

If your JDK is installed in a non-standard location, you may need to configure `JAVA_HOME` manually. You can configure `JAVA_HOME` permanently through your system's environment variables if desired.

Maven and JavaFX dependencies are downloaded automatically when needed. Keep in mind, the first launch may take longer while Maven downloads the required tools and dependencies.<br>

### Installation Troubleshooting
   - **Java not found:** Install JDK 21 and verify your JAVA_HOME configuration.
   - **Compilation fails:** Check the error output and ensure your repository is up to date.
   - **Dependencies fail to download:** Check your internet connection and retry the script.

## References

* [Minecraft Wiki — Bedrock Edition level format](https://minecraft.wiki/w/Bedrock_Edition_level_format)
* [Mojang — leveldb-mcpe](https://github.com/jocopa3/leveldb-mcpe)
* [maple-shaft — leveldb-mcpe-java-api](https://github.com/maple-shaft/leveldb-mcpe-java-api)
* [Amulet Map Editor](https://github.com/Amulet-Team/Amulet-Map-Editor)
* [Java Documentation](https://docs.oracle.com/en/java/)
* [JavaFX Documentation](https://openjfx.io/)
