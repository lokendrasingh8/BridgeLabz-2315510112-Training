package Hospital;
import java.util.*;

public class HospitalMain {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        InPatient p1 = new InPatient("P001","Sita",30,5);
        p1.addRecord("Admitted for observation");
        OutPatient p2 = new OutPatient("P002","Ram",28,500);
        p2.addRecord("General checkup");

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails() + ", Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                System.out.println("Records: " + ((MedicalRecord)p).viewRecords());
            }
            System.out.println("---");
        }
    }
}
