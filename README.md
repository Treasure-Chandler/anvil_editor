# Anvil Editor

**A desktop tool for exploring and editing Minecraft: Bedrock Edition world data!**

Anvil Editor is an application designed to make Minecraft: Bedrock Edition world data easier to inspect, navigate, and modify. By providing an interface for LevelDB records and NBT data, Anvil Editor aims to make world data more accessible without requiring users to manually interpret binary files.

## Overview

Minecraft: Bedrock Edition stores world information using a LevelDB-based database and structured binary data formats. Working with these files directly can be hard without the right tools or knowledge.

Anvil Editor aims to provide a user-friendly interface for browsing world records, exploring nested NBT structures, and safely editing (supported) values.

## Features

Coming soon! Currently in development...

## Requirements and Setup

Anvil Editor is built with Java and JavaFX and uses Maven to manage dependencies and run the application.

### Requirements

- **JDK 21:** Required to compile and run the application
- **Visual Studio Code:** Recommended for development
- **Extension Pack for Java:** Recommended for Java development in VS Code (if you would like)
- **Maven:** Used to manage dependencies, compile the project, and launch the application

### Running the Application

1. Install JDK 21 from [Eclipse Temurin](https://adoptium.net/) or another JDK distribution.
2. Verify that Java is installed by running this command in a terminal:

   ```powershell
   java -version
   ```

3. Clone the repository and open it in VS Code.
4. Ensure that the project contains its `pom.xml` file and allow VS Code to import the Maven project.
5. From the repository root, run the following command to compile the project:

   ```powershell
   mvn clean compile
   ```

6. Launch the application using:

   ```powershell
   mvn javafx:run
   ```

### Using the Maven Wrapper

If the repository includes the Maven Wrapper files (`mvnw`, `mvnw.cmd`, and `.mvn/wrapper/`), you do not need to install Maven separately. The wrapper downloads and uses the configured Maven version.

On Windows, run:

```powershell
.\mvnw.cmd clean compile
.\mvnw.cmd javafx:run
```

On macOS or Linux, run:

```bash
./mvnw clean compile
./mvnw javafx:run
```

You will still need a compatible JDK installed. If the project does not yet contain the Maven Wrapper files, use the regular Maven commands above.

## References

* [Minecraft Wiki — Bedrock Edition level format](https://minecraft.wiki/w/Bedrock_Edition_level_format)
* [Mojang — leveldb-mcpe](https://github.com/Mojang/leveldb-mcpe)
* [maple-shaft — leveldb-mcpe-java-api](https://github.com/maple-shaft/leveldb-mcpe-java-api)
* [Amulet Map Editor](https://github.com/Amulet-Team/Amulet-Map-Editor)
* [Java Documentation](https://docs.oracle.com/en/java/)
* [JavaFX Documentation](https://openjfx.io/)
