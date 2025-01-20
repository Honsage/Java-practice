public class Rectangle extends Figure {
    private final double length;
    private final double width;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double getSquare() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 *  (this.length + this.width);
    }
}
