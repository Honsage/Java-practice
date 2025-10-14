package ru.honsage.practice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuadraticEquationsSolver extends Remote {
    EquationSolution solveEquation(double a, double b, double c) throws RemoteException;
}
