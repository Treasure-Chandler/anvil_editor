package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Displays hierarchical NBT data in the Anvil Editor interface.
 *
 * TreeItem manages the hierarchy, while NbtTreeNode stores
 * the information displayed for each tag.
 */
public class NbtTreeView extends BorderPane {

    private final TreeView<NbtTreeNode> treeView;

    public NbtTreeView() {
        // Create the root tag for the tree
        TreeItem<NbtTreeNode> root =
                new TreeItem<>(new NbtTreeNode("NBT Data", "ROOT", null));

        // Example Level compound
        TreeItem<NbtTreeNode> level =
                new TreeItem<>(new NbtTreeNode("Level", "COMPOUND", null));

        level.getChildren().addAll(
                new TreeItem<>(new NbtTreeNode("xPos", "INT", 1)),
                new TreeItem<>(new NbtTreeNode("zPos", "INT", 0)),
                new TreeItem<>(new NbtTreeNode("Status", "STRING", "full"))
        );

        // Example Entities list containing one entity
        TreeItem<NbtTreeNode> entities =
                new TreeItem<>(new NbtTreeNode("Entities", "LIST", null));

        TreeItem<NbtTreeNode> entity =
                new TreeItem<>(new NbtTreeNode("Entity 0", "COMPOUND", null));

        entity.getChildren().addAll(
                new TreeItem<>(new NbtTreeNode("id", "STRING", "minecraft:cow")),
                new TreeItem<>(new NbtTreeNode("Health", "FLOAT", 20.0f))
        );

        entities.getChildren().add(entity);
        level.getChildren().add(entities);
        root.getChildren().add(level);

        // Set up the JavaFX tree
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.setCellFactory(tree -> new TreeCell<>() {
            @Override
            protected void updateItem(NbtTreeNode node, boolean empty) {
                super.updateItem(node, empty);

                if (empty || node == null) {
                    setGraphic(null);
                    setText(null);
                    return;
                }

                Label name = new Label(node.getName());
                Label type = new Label(node.getType());
                Label value = new Label(
                        node.getValue() == null
                                ? ""
                                : node.getValue().toString());

                name.setPrefWidth(180);
                type.setPrefWidth(100);
                value.setMaxWidth(Double.MAX_VALUE);

                HBox row = new HBox(12, name, type, value);
                HBox.setHgrow(value, Priority.ALWAYS);
                row.setPadding(new Insets(2, 4, 2, 4));

                setText(null);
                setGraphic(row);
            }
        });

        // Expand the main containers to show the sample data
        root.setExpanded(true);
        level.setExpanded(true);
        entities.setExpanded(true);
        entity.setExpanded(true);

        // Add the panel title and tree to the layout
        Label title = new Label("NBT Data");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        title.setPadding(new Insets(8));

        setTop(title);
        setCenter(treeView);
    }

    public TreeView<NbtTreeNode> getTreeView() {
        return treeView;
    }
}
