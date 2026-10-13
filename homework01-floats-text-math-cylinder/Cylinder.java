public class Cylinder {
    // declaring the private variables
    private double radius;
    private double height;

    public Cylinder(double radius, double height) { // defining the parametrized constructor
        this.radius = radius;
        this.height = height;
    }

    public void setRadius(double radius) { // sets the radius
        this.radius = radius;
    }

    public void setHeight(double height) { // sets the height
        this.height = height;
    }

    public double getRadius() {
        return radius; // as radius is a private member, we need a getter function to access ot.
    }

    public double getHeight() {
        return height; // Similarly for the height, we need to access it using the getter function.
    }

    public double findVol() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public double findSA() {
        return (2 * Math.PI * Math.pow(radius, 2)) + (2 * Math.PI * radius * height);
    }

    @Override
    public String toString() {
        return "Cylinder [radius=" + radius + ", height=" + height + "]";
    }
};
