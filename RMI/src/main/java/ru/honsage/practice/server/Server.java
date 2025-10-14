package ru.honsage.practice.server;

import ru.honsage.practice.QuadraticEquationsSolver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server() {}

    public static void main(String[] args) {
        try {
            QuadraticEquationSolverImpl solver = new QuadraticEquationSolverImpl();

            QuadraticEquationsSolver stub = (QuadraticEquationsSolver) UnicastRemoteObject.exportObject(solver, 0);
            Registry registry = LocateRegistry.createRegistry(2005);

            registry.rebind("QuadraticEquationSolver", stub);
            System.err.println("Server ready");
        } catch(Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
