package cz.cvut.fel.pjv;

public class NodeImpl implements Node {

    private int value;

    private NodeImpl lft;
    private NodeImpl rgt;

    public NodeImpl(int value) {
        this.value = value;
    }

    private static void insertSpaces(StringBuffer sb, int spaces) {
        for (int i = 0; i < spaces; i++) {
            sb.append(' ');
        }
    }

    @Override
    public Node getLeft() {
        return this.lft;
    }

    public void setLeft(NodeImpl lft) {
        this.lft = lft;
    }

    @Override
    public Node getRight() {
        return this.rgt;
    }

    public void setRight(NodeImpl rgt) {
        this.rgt = rgt;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public void printString(StringBuffer sb, int indent) {
        insertSpaces(sb, indent);
        sb.append("- ").append(this.value).append("\n");

        if (this.lft != null) {
            this.lft.printString(sb, indent + 1);
        }

        if (this.rgt != null) {
            this.rgt.printString(sb, indent + 1);
        }
    }
}
