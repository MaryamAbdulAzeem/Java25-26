public class TestingPatient {
    public static void main(String[] args) {
        // exercise 1
        Patient[] patients = new Patient[3];

        // Initialize patients (the baseCost parameter is from exercise 2)
        patients[0] = new InPatient("Ali", 1000);
        patients[1] = new InPatient("Sara", 2000); // Sara
        patients[2] = new InPatient("Omar", 1500); // Omar

        // Loop through patients
        for (int i = 0; i < patients.length; i++) {
            // Display info
            patients[i].displayInfo();

            // Admit patient
            ((Admittable) patients[i]).admit();

            // Check vitals
            ((Monitorable) patients[i]).checkVitals();

            System.out.println();
        }

        // exercise 2
        double totalRevenue = 0;

        for (int i = 0; i < patients.length; i++) {
            double bill = ((InPatient) patients[i]).calculateBill();
            totalRevenue += bill;
            ((Payable) patients[i]).payBill(bill); // pay bill
        }

        System.out.println("Total Revenue: " + totalRevenue); // display the total revenue
    }
}
