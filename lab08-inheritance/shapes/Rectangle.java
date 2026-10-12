public class Rectangle extends Shape {
    double width = 1.0;
    double height = 1.0;

    public Rectangle(String color, double width, double height) {
        super(color);
        if (width > 0) {
            this.width = width;
        }
        if (height > 0) {
            this.height = height;
        }
    }

    @Override
    public String getArea() {
        return String.format("%.2f", (width * height));
    }

    @Override
    public String toString() {
        return String.format("Rectangle[color=%s, width = %.2f, height = %.2f, area = %s]", getColor(), width, height, getArea());
    }
}
