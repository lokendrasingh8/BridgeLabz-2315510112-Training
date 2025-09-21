package Hospital;

import java.util.*;

public interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}
