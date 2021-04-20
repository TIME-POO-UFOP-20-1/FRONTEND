package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String message;

    public void createAndConect(){
        try {
            socket = new Socket("192.168.2.3", 3000);
            System.out.println("Connected to server ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendStringMessage( String data) {
        try {
            in = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
            char type = 's'; // s for string
            int length = data.length();
            byte[] dataInBytes = data.getBytes(StandardCharsets.UTF_8);         
            //Sending data in TLV format        
            out.writeChar(type);
            out.writeInt(length);
            out.write(dataInBytes);
            System.out.print(in.toString());
            message = in.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public String getMessage(){
        return message;
    }

}