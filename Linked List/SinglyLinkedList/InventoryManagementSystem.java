class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String name, int id, int qty, double price) {
        this.itemName = name;
        this.itemId = id;
        this.quantity = qty;
        this.price = price;
    }
}

public class InventoryManagementSystem {
    ItemNode head;

    public void addItem(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeItem(int id) {
        if (head == null) return;
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += (temp.quantity * temp.price);
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    String tName = current.itemName; current.itemName = current.next.itemName; current.next.itemName = tName;
                    int tId = current.itemId; current.itemId = current.next.itemId; current.next.itemId = tId;
                    int tQty = current.quantity; current.quantity = current.next.quantity; current.next.quantity = tQty;
                    double tPrice = current.price; current.price = current.next.price; current.next.price = tPrice;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void display() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " - Qty: " + temp.quantity);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inv = new InventoryManagementSystem();
        inv.addItem("Laptop", 101, 5, 1000.0);
        inv.addItem("Mouse", 102, 50, 20.0);
        inv.display();
        inv.calculateTotalValue();
        inv.sortByName();
        inv.display();
    }
}
