package ru.honsage.practice;

import java.io.Serializable;
import java.util.Arrays;

public class EquationSolution implements Serializable {
    private final double a;
    private final double b;
    private final double c;
    private final double discriminant;
    private final double[] roots;
    private final String message;

    public EquationSolution(double a, double b, double c,
                            double discriminant, double[] roots,
                            String message) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = discriminant;
        this.roots = roots;
        this.message = message;
    }

    public double[] getRoots() {
        return this.roots;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return String.format("""
                        Equation: %.2fx^2 + %.2fx + %.2f = 0
                        Discriminant: %.2f
                        Roots: %s
                        Message: %s""",
                a, b, c, discriminant, Arrays.toString(roots), message);
    }
}
