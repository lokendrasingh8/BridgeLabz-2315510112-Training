class Employee {
    static String companyName = "Infosys";
    static int totalEmployees = 0;

    final int id;
    String name, designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployee() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName + ", Name: " + name + ", ID: " + id + ", Role: " + designation);
        }
    }
}
