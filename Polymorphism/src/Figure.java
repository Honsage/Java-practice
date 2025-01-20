public abstract class Figure implements Comparable<Figure> {
    private final String type;

    public Figure() {
        this("None");
    }

    public Figure(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public int compareTo(Figure f) {
        return (int) (this.getSquare() - f.getSquare());
    }

    public abstract double getSquare();

    public abstract double getPerimeter();
}
