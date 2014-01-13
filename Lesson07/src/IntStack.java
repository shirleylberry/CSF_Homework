
public class IntStack {
    IntListNode firstNode;

    public IntStack() {
    }

    // O(1)
    public void push(int value) {
        // TODO: Add a value to the top of the stack
        if (firstNode == null){
            firstNode = new IntListNode(value);
        }
        else
        {
            IntListNode newNode = new IntListNode(value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
    }

    // O(1)
    public int pop() {
        // TODO: Pop the first value off the stack
        int poppedVal = firstNode.getValue();
        // oldFirstNode == firstNode;
        firstNode = firstNode.getNextNode();
        // oldFirstNode = null;
        return poppedVal;
    }

    // O(n)
    public int size() {
        // TODO: Fill out this method
        int size = 0;
        IntListNode node = firstNode;
        while(node != null){
            size++;
            node = node.getNextNode();
        }
        return size;
    }
}
