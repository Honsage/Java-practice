package ru.honsage.practice;

import java.rmi.RemoteException;

public class HelloImplementer implements Hello {
    @Override
    public void printMessage() throws RemoteException {
        System.out.println("This is an example of RMI program");
    }
}
