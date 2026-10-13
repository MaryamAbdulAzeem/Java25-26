public abstract class Patient {
    protected String name;

    public Patient(String name) {
        this.name = name;
    }

    public abstract void displayInfo();

    public abstract double calculateBill();
}
