@echo off
setlocal
title Anvil Editor Launcher

echo ==========================================
echo          Anvil Editor Launcher
echo ==========================================
echo.

REM Move to the directory containing this script
cd /d "%~dp0"

REM Configuring JAVA_HOME:
REM Keep an existing JAVA_HOME if it points to a valid JDK
if defined JAVA_HOME if exist "%JAVA_HOME%\bin\javac.exe" goto check_java

REM Check the common Eclipse Adoptium JDK 21 locations
for /d %%D in ("C:\Program Files\Eclipse Adoptium\jdk-21*") do (
    if exist "%%~D\bin\javac.exe" (
        set "JAVA_HOME=%%~D"
        goto check_java
    )
)

REM Check the common Oracle JDK 21 locations
for /d %%D in ("C:\Program Files\Java\jdk-21*") do (
    if exist "%%~D\bin\javac.exe" (
        set "JAVA_HOME=%%~D"
        goto check_java
    )
)

echo ERROR: A JDK installation could not be found!
echo Please install JDK 21. You can find the installation link in the repository.
pause
exit /b 1

:check_java
REM Add this JDK to PATH for this script session
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Using Java from:
echo %JAVA_HOME%
echo.
java -version
echo.

REM Verify Maven Wrapper
if not exist "mvnw.cmd" (
    echo ERROR: mvnw.cmd was not found.
    pause
    exit /b 1
)

REM Compile and launch
echo Compiling Anvil Editor...
call mvnw.cmd compile
if errorlevel 1 (
    echo.
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo.
echo Launching Anvil Editor...
call mvnw.cmd javafx:run
if errorlevel 1 (
    echo.
    echo ERROR: Anvil Editor failed to launch!
    pause
    exit /b 1
)

endlocal
