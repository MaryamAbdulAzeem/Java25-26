public class Shape {
    private String color;

    public Shape() {
        this.color = "red";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getArea() {
        return "0.0";
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}
