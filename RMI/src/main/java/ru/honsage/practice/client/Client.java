package ru.honsage.practice.client;

import ru.honsage.practice.EquationSolution;
import ru.honsage.practice.QuadraticEquationsSolver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2005);
            QuadraticEquationsSolver stub = (QuadraticEquationsSolver) registry.lookup("QuadraticEquationSolver");

            double[] params = Client.getParameters();
            double a = params[0], b = params[1], c = params[2];

            EquationSolution solution = stub.solveEquation(a, b, c);
            System.out.println(solution);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static double[] getParameters() {
        return new double[]{2.0, -3.0, 0};
    }
}
