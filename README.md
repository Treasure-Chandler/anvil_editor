# Anvil Editor

**A desktop tool for exploring and editing Minecraft: Bedrock Edition world data!**

Anvil Editor is an application designed to make Minecraft: Bedrock Edition world data easier to inspect, navigate, and modify. By providing an interface for LevelDB records and NBT data, Anvil Editor aims to make world data more accessible without requiring users to manually interpret binary files.

## Overview

Minecraft: Bedrock Edition stores world information using a LevelDB-based database and structured binary data formats. Working with these files directly can be hard without the right tools or knowledge.

Anvil Editor aims to provide a user-friendly interface for browsing world records, exploring nested NBT structures, and safely editing (supported) values.

## Features

Coming soon! Currently in development...

## Installation and Setup

### Prerequisites

Before running Anvil Editor, install:
- **JDK 21 or newer** — the project compiles for Java 21. The application was tested on JDK 25.
- **Visual Studio Code** (recommended).
- **Extension Pack for Java for VS Code** (recommended).

Maven is included through the Maven Wrapper, so a separate Maven installation is not required!

### 1. Clone the Repository

Clone the repository and open the project folder in VS Code. Then, open a terminal at the repository root; it needs to be where `pom.xml` and `mvnw.cmd` are located.

### 2. Configure Java

Ensure that `JAVA_HOME` points to your installed JDK directory. For example, in PowerShell:

```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-25.0.4.101-hotspot"
```

Replace the path with your actual JDK installation directory.

Then, check that Java is available:

```powershell
Test-Path "$env:JAVA_HOME\bin\java.exe"
java -version
```

The first command should return `True`.

**Note:** The `$env:JAVA_HOME` command configures Java only for the current PowerShell session. You may configure `JAVA_HOME` permanently through your Windows Environment Variables if desired.

### 3. Verify the Maven Wrapper

Run the following command from the repository root:

```powershell
.\mvnw.cmd -version
```

The wrapper will automatically download the configured Maven version if it is not already available.

### 4. Compile the Project

Compile the source code and check for errors:

```powershell
.\mvnw.cmd clean compile
```

### 5. Run Anvil Editor

Finally, launch JavaFX with:

```powershell
.\mvnw.cmd javafx:run
```

The first build or launch may take longer while Maven downloads the required dependencies.<br>

### Installation Troubleshooting
   - **`mvn` is not recognized:** Use `.\mvnw.cmd` instead of `mvn`. You won't need a separate Maven installation for this app.
   - **Java cannot be found:** Verify that `JAVA_HOME` points to the JDK installation directory and that `bin\java.exe` exists.
   - **Dependencies fail to download:** Check your internet connection and retry the command.
   - **JavaFX warnings appear:** Some JavaFX native-access warnings may appear on newer JDK versions. If the application launches successfully, these warnings did not prevent the tested build from running, and you won't need to worry about them affecting the app's functionality.

## References

* [Minecraft Wiki — Bedrock Edition level format](https://minecraft.wiki/w/Bedrock_Edition_level_format)
* [Mojang — leveldb-mcpe](https://github.com/Mojang/leveldb-mcpe)
* [maple-shaft — leveldb-mcpe-java-api](https://github.com/maple-shaft/leveldb-mcpe-java-api)
* [Amulet Map Editor](https://github.com/Amulet-Team/Amulet-Map-Editor)
* [Java Documentation](https://docs.oracle.com/en/java/)
* [JavaFX Documentation](https://openjfx.io/)
