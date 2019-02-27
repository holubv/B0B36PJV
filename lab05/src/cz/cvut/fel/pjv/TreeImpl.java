package cz.cvut.fel.pjv;

public class TreeImpl implements Tree {

    private NodeImpl root;

    @Override
    public void setTree(int[] values) {
        if (values.length == 0) {
            root = null;
            return;
        }
        root = this.convertToNode(values, 0, values.length);
    }

    private NodeImpl convertToNode(int[] values, int start, int end) {
        if (end - start <= 0) {
            return null;
        }

        int mid = (start + end) / 2;

        NodeImpl root = new NodeImpl(values[mid]);
        root.setLeft(this.convertToNode(values, start, mid));
        root.setRight(this.convertToNode(values, mid + 1, end));

        return root;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (this.root != null) {
            this.root.printString(sb, 0);
        }
        return sb.toString();
    }
}
