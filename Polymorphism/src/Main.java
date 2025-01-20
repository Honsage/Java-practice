import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Circle());
        figures.add(new Circle(5.21));
        figures.add(new Rectangle(3, 4));
        figures.add(new Rectangle(12.7, 3.4));
        figures.add(new Square(6.7));

        System.out.println("Information about elements of Figure arrayList:");
        for(var f : figures) {
            System.out.println(
                    f.getType() + " "
                    + f.getPerimeter() + " "
                    + f.getSquare()
            );
        }

        Collections.sort(figures);

        System.out.println("\nInformation about elements of sorted Figure arrayList:");
        for(var f : figures) {
            System.out.println(
                    f.getType() + " "
                            + f.getPerimeter() + " "
                            + f.getSquare()
            );
        }
    }
}