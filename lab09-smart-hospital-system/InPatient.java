public class InPatient extends Patient implements Admittable, Monitorable, Insurable, Payable {
    private double baseCost;

    public InPatient(String name, double baseCost) {
        super(name);
        this.baseCost = baseCost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient: " + name + " (In-Patient)");
    }

    @Override
    public void admit() {
        System.out.println(name + " has been admitted");
    }

    @Override
    public void checkVitals() {
        System.out.println(name + "'s vitals are stable");
    }

    @Override
    public double applyInsurance() {
        return (0.3 * baseCost);
    }

    @Override
    public void payBill(double baseCost) {
        System.out.println(name + " paid: " + calculateBill());
    }

    @Override
    public double calculateBill() {
        return (baseCost - applyInsurance());
    }
}
