public class TreeIntNode {
    private int value;
    private TreeIntNode nextNode;

    public TreeIntNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeIntNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TreeIntNode nextNode) {
        this.nextNode = nextNode;
    }
}
