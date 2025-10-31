class WrapperToPrimitive {
    public static void main(String[] args) {
        Double obj = 45.67;  // Wrapper object


        double d = obj.doubleValue();
        int i = (int) obj.doubleValue();


        System.out.println("Wrapper object value: " + obj);
        System.out.println("Primitive double value: " + d);
        System.out.println("Primitive int value (after casting): " + i);
    }
}
