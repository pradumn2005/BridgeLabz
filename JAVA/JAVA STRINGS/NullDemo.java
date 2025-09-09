class NullDemo {
    public static void main(String args[]) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch(Exception e) {
            System.out.println("NullPointerException handled");
        }
    }
}
