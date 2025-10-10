package ru.honsage.practice;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

            Hello stub = (Hello) registry.lookup("Hello");
            stub.printMessage();

        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
