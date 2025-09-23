abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    public Patient(int id,String n,int a){patientId=id;name=n;age=a;}
    public void getPatientDetails(){System.out.println(patientId+" "+name+" "+age);}
    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String rec);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    public InPatient(int id,String n,int a,double r){super(id,n,a);roomCharge=r;}
    public double calculateBill(){return roomCharge*5;}
    public void addRecord(String rec){System.out.println("InPatient Record "+rec);}
    public void viewRecords(){System.out.println("InPatient Records");}
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    public OutPatient(int id,String n,int a,double f){super(id,n,a);consultationFee=f;}
    public double calculateBill(){return consultationFee;}
    public void addRecord(String rec){System.out.println("OutPatient Record "+rec);}
    public void viewRecords(){System.out.println("OutPatient Records");}
}

public class Main7 {
    public static void main(String[] args) {
        Patient p=new InPatient(1,"Raj",30,1000);
        p.getPatientDetails();
        System.out.println(p.calculateBill());
    }
}
