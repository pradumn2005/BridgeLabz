class BstNode {
    int roll;
    BstNode left, right;
    public BstNode(int roll) {
        this.roll = roll;
        this.left = this.right = null;
    }
}

public class BstOperations {
    public static BstNode insert(BstNode root, int roll) {
        if (root == null) {
            return new BstNode(roll);
        }
        if (roll < root.roll) {
            root.left = insert(root.left, roll);
        } else if (roll > root.roll) {
            root.right = insert(root.right, roll);
        }
        return root;
    }

    public static BstNode delete(BstNode root, int roll) {
        if (root == null) {
            return root;
        }
        if (roll < root.roll) {
            root.left = delete(root.left, roll);
        } else if (roll > root.roll) {
            root.right = delete(root.right, roll);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.roll = minValue(root.right);
            root.right = delete(root.right, root.roll);
        }
        return root;
    }

    public static int minValue(BstNode root) {
        int min = root.roll;
        while (root.left != null) {
            min = root.left.roll;
            root = root.left;
        }
        return min;
    }

    public static void inorder(BstNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.roll + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] rolls = {15, 10, 20, 8, 12, 17, 25};
        BstNode root = null;
        
        for (int r : rolls) {
            root = insert(root, r);
        }
        
        root = delete(root, 10);
        root = insert(root, 14);
        root = insert(root, 9);
        
        inorder(root);
        System.out.println();
    }
}
