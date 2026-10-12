package com.anvileditor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Displays chunk data in the Anvil Editor interface
 * (which is the upper half), along with a chunk map
 * of the player's current dimension
 */
public class ChunkViewer extends BorderPane {

    // Displays the currently selected chunk's coordinates
    private final Label selectedChunkLabel = new Label("Selected Chunk: [1,0]");

    /**
     * Upper half of the editor interface
     */
    public ChunkViewer() {
        // Grid to arrange the world tree and chunk map side by side
        GridPane chunkViewer = new GridPane();
        chunkViewer.setHgap(10);
        chunkViewer.setVgap(10);
        chunkViewer.setPadding(new Insets(10));

        // World tree on the left side
        VBox worldPanel = createWorldPanel();

        // Chunk map on the right side
        VBox mapPanel = createChunkMapPanel();

        // Place the world tree in the first column
        chunkViewer.add(worldPanel, 0, 0);

        // Place the chunk map in the second column
        chunkViewer.add(mapPanel, 1, 0);

        // Give the map column the remaining available horizontal space
        javafx.scene.layout.ColumnConstraints worldColumn = new javafx.scene.layout.ColumnConstraints(200);

        javafx.scene.layout.ColumnConstraints mapColumn = new javafx.scene.layout.ColumnConstraints();

        mapColumn.setHgrow(javafx.scene.layout.Priority.ALWAYS);

        chunkViewer.getColumnConstraints().addAll(worldColumn, mapColumn);

        // Use the grid as the main content of this component
        setCenter(chunkViewer);

        // Display the selected chunk information underneath the grid
        selectedChunkLabel.setPadding(new Insets(8, 10, 8, 10));
        setBottom(selectedChunkLabel);
    }

    /**
     * Dimension and chunk tree on the left side of the window
     */
    private VBox createWorldPanel() {
        Label worldTitle = new Label("World");

        // Hierarchy of dimensions and chunk coordinates
        TreeItem<String> root = new TreeItem<>("World");
        TreeItem<String> overworld = new TreeItem<>("Overworld");
        TreeItem<String> nether = new TreeItem<>("Nether");
        TreeItem<String> end = new TreeItem<>("End");
        TreeItem<String> overworldChunks = new TreeItem<>("Chunk");
        TreeItem<String> netherChunks = new TreeItem<>("Chunk");
        TreeItem<String> endChunks = new TreeItem<>("Chunk");

        // Add the dimension chunk tree items
        overworldChunks.getChildren().add(new TreeItem<>("[0,0]"));
        overworldChunks.getChildren().add(new TreeItem<>("[0,1]"));
        overworldChunks.getChildren().add(new TreeItem<>("[1,0]"));
        overworldChunks.getChildren().add(new TreeItem<>("[1,1]"));

        netherChunks.getChildren().add(new TreeItem<>("[0,0]"));
        netherChunks.getChildren().add(new TreeItem<>("[0,1]"));
        netherChunks.getChildren().add(new TreeItem<>("[1,0]"));
        netherChunks.getChildren().add(new TreeItem<>("[1,1]"));

        endChunks.getChildren().add(new TreeItem<>("[0,0]"));
        endChunks.getChildren().add(new TreeItem<>("[0,1]"));
        endChunks.getChildren().add(new TreeItem<>("[1,0]"));
        endChunks.getChildren().add(new TreeItem<>("[1,1]"));

        overworld.getChildren().add(overworldChunks);
        nether.getChildren().add(netherChunks);
        end.getChildren().add(endChunks);

        // Add the dimension dropdowns
        root.getChildren().add(overworld);
        root.getChildren().add(nether);
        root.getChildren().add(end);

        // Display the hierarchy in a JavaFX TreeView
        TreeView<String> worldTree = new TreeView<>(root);
        worldTree.setShowRoot(false);

        // Expand the Overworld and its chunk list initially
        overworld.setExpanded(true);
        overworldChunks.setExpanded(true);

        // Update the selected chunk label when a chunk is selected
        worldTree.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null && newValue.getValue().startsWith("[")) {
                        selectedChunkLabel.setText("Selected Chunk: " + newValue.getValue());
                    }
                });

        VBox panel = new VBox(8, worldTitle, worldTree);
        panel.setPadding(new Insets(5));
        panel.setPrefWidth(200);

        return panel;
    }

    /**
     * Simple grid representing the chunk map.
     */
    private VBox createChunkMapPanel() {
        Label mapTitle = new Label("Chunk Map");

        GridPane chunkMap = new GridPane();
        chunkMap.setHgap(2);
        chunkMap.setVgap(2);
        chunkMap.setAlignment(Pos.CENTER);

        // Create a sample 4-by-4 map
        for (int z = 0; z < 4; z++) {
            for (int x = 0; x < 4; x++) {
                final int chunkX = x;
                final int chunkZ = z;

                Button chunkCell = new Button();
                chunkCell.setPrefSize(45, 45);
                chunkCell.setMinSize(45, 45);
                chunkCell.setMaxSize(45, 45);

                // Select a chunk by clicking its map cell
                chunkCell.setOnAction(event -> {
                    selectedChunkLabel.setText("Selected Chunk: [" + chunkX + "," + chunkZ + "]");
                });

                chunkMap.add(chunkCell, x, z);
            }
        }

        VBox panel = new VBox(8, mapTitle, chunkMap);
        panel.setAlignment(Pos.TOP_CENTER);
        panel.setPadding(new Insets(5));

        return panel;
    }
}
