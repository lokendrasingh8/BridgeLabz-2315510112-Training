package Hospital;

import java.util.*;

public class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int days) {
        super(id, name, age);
        this.daysAdmitted = days;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * 2000; // per day example
    }

    @Override
    public void addRecord(String record) { records.add(record); }

    @Override
    public List<String> viewRecords() { return records; }
}
