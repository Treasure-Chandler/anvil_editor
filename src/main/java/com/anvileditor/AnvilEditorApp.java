package com.anvileditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.anvileditor.ui.NbtTreeView;

// Main entry point for the Anvil Editor JavaFX application
public class AnvilEditorApp extends Application {

    // Initializes and displays the application's main window
    @Override
    public void start(Stage stage) {
        // NBT tree interface that will be displayed in the window
        NbtTreeView nbtTreeView = new NbtTreeView();

        // The window size is 800x600 pixels
        Scene scene = new Scene(nbtTreeView, 800, 600);

        // Configure the title and window
        stage.setTitle("Anvil Editor");
        stage.setScene(scene);

        // Load the window
        stage.show();
    }

    // Application entry point; launch() initializes JavaFX components and calls start()
    public static void main(String[] args) {
        launch(args);
    }
}
