package com.anvileditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import com.anvileditor.ui.ChunkViewer;
import com.anvileditor.ui.EditorOptions;
import com.anvileditor.ui.NbtTreeView;

// Main entry point for the Anvil Editor JavaFX application
public class AnvilEditorApp extends Application {

    // Initializes and displays the application's main window
    @Override
    public void start(Stage stage) {
        // Load the application icon from the resources folder
        var iconStream = getClass().getResourceAsStream("/com/anvileditor/ui/anvileditoricon.png");

        // Set the application window icon if the image exists
        if (iconStream != null) {
            stage.getIcons().add(new Image(iconStream));
        }

        /* 
         * The world options are located on the top of the window;
         * the chunk viewer is on the upper "half" of the window,
         * and the NBT tree viewer is on the lower "half"
         */
        VBox mainLayout = new VBox(new EditorOptions(), new ChunkViewer(), new NbtTreeView());

        // The window size is 650x620 pixels
        Scene scene = new Scene(mainLayout, 650, 620);

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
