@echo off
setlocal
title Anvil Editor Launcher

echo ==========================================
echo          Anvil Editor Launcher
echo ==========================================
echo.

REM Move to the directory containing this script
cd /d "%~dp0"

REM Check that the Maven Wrapper exists
if not exist "mvnw.cmd" (
    echo ERROR: mvnw.cmd was not found.
    echo Make sure you are running this script
    echo from a complete Anvil Editor repository.
    pause
    exit /b 1
)

REM Check that Java is available
where java >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java was not found.
    echo Install a JDK and configure JAVA_HOME.
    echo.
    echo See the installation instructions in README.md.
    pause
    exit /b 1
)

REM Check JAVA_HOME if it is configured
if defined JAVA_HOME (
    if not exist "%JAVA_HOME%\bin\java.exe" (
        echo ERROR: JAVA_HOME points to an invalid directory:
        echo %JAVA_HOME%
        pause
        exit /b 1
    )
)

echo Checking Java version...
java -version
echo.

echo Compiling Anvil Editor...
call mvnw.cmd clean compile
if errorlevel 1 (
    echo.
    echo ERROR: Compilation failed.
    pause
    exit /b 1
)

echo.
echo Launching Anvil Editor...
call mvnw.cmd javafx:run

if errorlevel 1 (
    echo.
    echo ERROR: Anvil Editor failed to launch.
    pause
    exit /b 1
)

endlocal
