public class Square extends Rectangle {
    double side;

    public Square(String color, double width, double height, double side) {
        super(color, side, side);
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("Square[color=%s, side=%.2f, area=%s]", getColor(), side, getArea());
    }
}
