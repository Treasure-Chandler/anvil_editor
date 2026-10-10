package ui;

/**
 * Represents a single node in the NBT tree displayed by the Anvil Editor UI.
 * Each node contains a name, an NBT data type, and its associated value.
 * 
 * Nested NBT structures, such as compounds and lists, can be represented
 * by connecting nodes to their children in the tree.
 */
public class NbtTreeNode {
    // NBT name
    private String name;

    // NBT data type, such as INT, STRING, COMPOUND, or LIST
    private String type;

    // The value stored in this tag, if applicable
    private Object value;

    /**
     * Creates a tree node representing an individual NBT tag
     * @param name  The name of the NBT tag
     * @param type  The NBT data type
     * @param value The tag's associated value
    */
    public NbtTreeNode(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    /* Returns the NBT's name, type, and/or value */
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    /**
     * Controls the default text representation of this node
     */
    @Override
    public String toString() {
        if (value == null) {
            return name + " (" + type + ")";
        }

        return name + " (" + type + "): " + value;
    }
}
