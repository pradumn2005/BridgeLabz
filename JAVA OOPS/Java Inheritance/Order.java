class Order {
    int orderId;
    String orderDate;
}

class ShippedOrder extends Order {
    String trackingNumber;
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    String getOrderStatus() {
        return "Delivered on "+deliveryDate;
    }
}

public class Main6 {
    public static void main(String[] args) {
        DeliveredOrder d=new DeliveredOrder();
        d.orderId=101; d.orderDate="2025-01-01"; d.trackingNumber="TR123"; d.deliveryDate="2025-01-05";
        System.out.println(d.getOrderStatus());
    }
}
