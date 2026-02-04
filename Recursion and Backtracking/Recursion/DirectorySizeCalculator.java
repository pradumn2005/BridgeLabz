import java.util.ArrayList;
import java.util.List;

class FileNode {
    String name;
    int size;
    boolean isDirectory;
    List<FileNode> children;

    public FileNode(String name, int size, boolean isDirectory) {
        this.name = name;
        this.size = size;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
    }

    public void addChild(FileNode node) {
        this.children.add(node);
    }
}

public class DirectorySizeCalculator {
    public static int calculateSize(FileNode node) {
        if (!node.isDirectory) {
            return node.size;
        }
        int totalSize = 0;
        for (FileNode child : node.children) {
            totalSize += calculateSize(child);
        }
        return totalSize;
    }

    public static void main(String[] args) {
        FileNode root = new FileNode("project", 0, true);
        FileNode src = new FileNode("src", 0, true);
        FileNode docs = new FileNode("docs", 0, true);
        
        src.addChild(new FileNode("main.java", 100, false));
        src.addChild(new FileNode("utils.java", 50, false));
        
        docs.addChild(new FileNode("readme.txt", 10, false));
        docs.addChild(new FileNode("setup.pdf", 200, false));
        
        root.addChild(src);
        root.addChild(docs);
        root.addChild(new FileNode("config.xml", 20, false));

        System.out.println("Total Directory Size: " + calculateSize(root) + " KB");
    }
}
