public class Circle extends Figure {
    private final double radius;

    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
