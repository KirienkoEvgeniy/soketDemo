package org.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Client {

    public Client() {
    }

    public static void main(String[] args) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");
        System.out.println("Client connected to server");

        byte[] sendData;
        byte[] receiveData = new byte[1024];
        System.out.print("Enter message: ");
        String messageUser = inFromUser.readLine();
        sendData = messageUser.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9094);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String message = new String(receivePacket.getData());
        System.out.println(message);
        clientSocket.close();

    }

}