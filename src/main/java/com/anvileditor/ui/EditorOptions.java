package com.anvileditor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * The options for what a user wants to do
 * with their world in Anvil Editor.
 * They have the option to open a world,
 * save it, or create a backup of it.
 */
public class EditorOptions extends BorderPane {
    /**
     * Open, save, and backup options
     */
    public EditorOptions() {
        // Grid to arrange the buttons
        GridPane buttonOptions = new GridPane();
        buttonOptions.setAlignment(Pos.CENTER);
        buttonOptions.setHgap(10);
        buttonOptions.setVgap(10);
        buttonOptions.setPadding(new Insets(10));

        // Button options
        Button openWorld = new Button("Open World");
        Button saveWorld = new Button("Save");
        Button backupWorld = new Button("Backup");

        // Add buttons to the grid
        buttonOptions.add(openWorld, 0, 0);
        buttonOptions.add(saveWorld, 1, 0);
        buttonOptions.add(backupWorld, 2, 0);

        // Use the grid as the main content of this component
        setCenter(buttonOptions);
    }
}
