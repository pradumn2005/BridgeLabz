class FileNode {
    String name;
    FileNode left, right;
    public FileNode(String name) {
        this.name = name;
        this.left = this.right = null;
    }
}

public class FileSystemTraversal {
    public static void inorder(FileNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.name);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        FileNode root = new FileNode("root");
        root.left = new FileNode("home");
        root.right = new FileNode("var");
        root.left.left = new FileNode("user");
        root.left.right = new FileNode("docs");
        root.right.right = new FileNode("log");
        root.left.left.left = new FileNode("config");
        
        inorder(root);
    }
}
