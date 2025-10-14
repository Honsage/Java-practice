package ru.honsage.practice.server;

import ru.honsage.practice.EquationSolution;
import ru.honsage.practice.QuadraticEquationsSolver;

import java.rmi.RemoteException;

public class QuadraticEquationSolverImpl implements QuadraticEquationsSolver {
    @Override
    public EquationSolution solveEquation(double a, double b, double c) throws RemoteException {
        if (a == 0) {
            return new EquationSolution(a, b, c, 0, new double[]{},
                    "This equation is not quadratic!");
        }

        double discriminant = b * b - 4 * a * c;
        double[] roots;
        String message;

        if (discriminant > 0) {
            double root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots = new double[]{root1, root2};
            message = "Quadratic equation with two real roots";
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            roots = new double[]{root};
            message = "Quadratic equation with one real root";
        } else {
            roots = new double[]{};
            message = "Quadratic equation without real roots";
        }

        return new EquationSolution(a, b, c, discriminant, roots, message);
    }
}
