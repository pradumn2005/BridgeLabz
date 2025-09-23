class Personn {
    String name;
    int id;
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    public void performDuties() { System.out.println("Cooking"); }
}

class Waiter extends Person implements Worker {
    public void performDuties() { System.out.println("Serving"); }
}

public class Main10 {
    public static void main(String[] args) {
        Worker w=new Chef();
        w.performDuties();
    }
}
