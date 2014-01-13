
public class IntLinkedList {
    private IntListNode firstNode;

    // IntLinkedList stores a list of unique integers
    public IntLinkedList() {
    }

    // O(1) (+ O(n) for the contains method)
    public void insert(int value) {
        // TODO: Add the integer, or take no action if it's already in the list
        if (firstNode == null){
            firstNode = new IntListNode(value);
        }
        else{
            while(!this.contains(value)){
                IntListNode newNode = new IntListNode(value);
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
        }
    }

    // O(n)
    public boolean contains(int value) {
        // TODO: Print out if the linked list contains the given integer
        IntListNode node = firstNode;
        while (node != null) {
            if (node.getValue() == value) {
                return true;
            }
            node = node.getNextNode();
        }
        return false;
    }

    // O(n)
    public void remove(int value) {
        // TODO: Remove the given integer from the list, or take no action if it's not in the list
        if (this.contains(value)){
            IntListNode node = firstNode;
            IntListNode nextNode = firstNode.getNextNode();
            while(node != null){
                if(firstNode.getValue() == value){
                    if(nextNode == null){
                        firstNode = null;
                    }
                    else{
                        firstNode = firstNode.getNextNode();
                    }
                    break;
                }
                else if(nextNode.getValue() == value){
                    node.setNextNode(nextNode.getNextNode());
                    break;
                }
                node = node.getNextNode();
                nextNode = node.getNextNode();
            }
        }
    }

    public void print() {
        IntListNode node = firstNode;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNextNode();
        }
    }
}
