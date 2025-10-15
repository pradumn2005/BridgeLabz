
interface PaymentProcessor {
    void process();
    default void refund() { System.out.println("Refund processed"); }
}

class PayPal implements PaymentProcessor {
    public void process() { System.out.println("PayPal payment done"); }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PayPal p = new PayPal();
        p.process();
        p.refund();
    }
}
