package org.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {

    private static DatagramSocket serverSocket;

    public Server() {
    }


    public static void main(String[] args) throws Exception {

        serverSocket = new DatagramSocket(9094);
        byte[] receiveData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String clientMessage = new String(receivePacket.getData());
            System.out.println("Client message : " + clientMessage);
        }

    }

}