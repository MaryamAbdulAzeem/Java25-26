public class Computer {
    public String personName;
    public double cost;
    public double cpuSpeed;
    public int age;
    public int memorySize;

    public String getPersonName() {
        return personName;
    }

    public double getCost() {
        return cost;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public int getAge() {
        return age;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public Computer() {
    }

    public void setAll(String personName, double cost, double cpuSpeed, int age, int memorySize) {
        this.personName = personName;
        this.cost = cost;
        this.cpuSpeed = cpuSpeed;
        this.age = age;
        this.memorySize = memorySize;
    }

    public Computer(String personName, double cost, double cpuSpeed, int age, int memorySize) {
        this.setAll(personName, cost, cpuSpeed, age, memorySize);
    }

    public double sell() {
        if (age > 24) {
            return cost * 0.50;
        }
        return cost * 0.75;
    }

    public int ageInSeconds() {
        return age * 30 * 24 * 3600;
    }

    public String toString() {
        return "The info for computer is: Name: " + personName + " Purchasing Cost: " + cost + " Selling Cost: " + sell() +
