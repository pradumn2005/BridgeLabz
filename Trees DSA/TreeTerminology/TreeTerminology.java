class Node {
    String position;
    Node left, right;
    public Node(String position) {
        this.position = position;
        this.left = this.right = null;
    }
}

public class TreeTerminology {
    public static void main(String[] args) {
        Node root = new Node("CEO");
        root.left = new Node("CTO");
        root.right = new Node("CFO");
        root.left.left = new Node("Dev Lead");
        root.right.right = new Node("HR");
        root.left.left.left = new Node("Dev1");
        root.left.left.right = new Node("Dev2");
        
        System.out.println("Tree structure initialized.");
    }
}
