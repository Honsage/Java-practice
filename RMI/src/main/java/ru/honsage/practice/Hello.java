package ru.honsage.practice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    void printMessage() throws RemoteException;
}
