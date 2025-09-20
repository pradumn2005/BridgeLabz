import java.util.*;

class Patient {
    String name;
    Patient(String n){ name=n; }
    public String toString(){ return name; }
}

class Doctor {
    String name;
    Doctor(String n){ name=n; }
    void consult(Patient p){
        System.out.println("Dr. "+name+" consulting "+p);
    }
}

class Hospital {
    String name;
    Hospital(String n){ name=n; }
}

public class Main3 {
    public static void main(String[] args){
        Hospital h=new Hospital("City Hospital");
        Doctor d1=new Doctor("Sharma"); Doctor d2=new Doctor("Singh");
        Patient p1=new Patient("Amit"); Patient p2=new Patient("Rita");
        d1.consult(p1); d1.consult(p2);
        d2.consult(p2);
    }
}
