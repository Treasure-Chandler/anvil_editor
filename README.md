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
- **JDK 21 or newer** — the project compiles for Java 21. The application was tested on JDK 25.
- **Visual Studio Code** (recommended).
- **Extension Pack for Java for VS Code** (recommended).

Maven is included through the Maven Wrapper, so a separate Maven installation is not required!

### 1. Clone the Repository

Clone the repository and open the project folder in VS Code.

### 2. Configure Java

Ensure that `JAVA_HOME` points to your installed JDK directory. For example, in PowerShell:

```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-25.0.4.101-hotspot"
```

Replace the example path with your actual JDK installation directory.

You may configure `JAVA_HOME` permanently through your Windows Environment Variables if desired.

### 3. Launch the Editor

From the repository root, run this launcher script:

```powershell
.\run-anvil-editor.bat
```

The script compiles the project and launches Anvil Editor using the repository's Maven Wrapper. Maven and JavaFX dependencies are downloaded automatically when needed, so a separate Maven installation is not required.<br>

### Installation Troubleshooting
   - **Java not found:** Install JDK 21 and verify your JAVA_HOME configuration.
   - **Compilation fails:** Check the error output and ensure your repository is up to date.
   - **Dependencies fail to download:** Check your internet connection and retry the script.

The first launch may take longer while Maven downloads the required tools and dependencies.

## References

* [Minecraft Wiki — Bedrock Edition level format](https://minecraft.wiki/w/Bedrock_Edition_level_format)
* [Mojang — leveldb-mcpe](https://github.com/jocopa3/leveldb-mcpe)
* [maple-shaft — leveldb-mcpe-java-api](https://github.com/maple-shaft/leveldb-mcpe-java-api)
* [Amulet Map Editor](https://github.com/Amulet-Team/Amulet-Map-Editor)
* [Java Documentation](https://docs.oracle.com/en/java/)
* [JavaFX Documentation](https://openjfx.io/)
