package com.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.net.InetAddress;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String message;
    private boolean confirmation;
    private Object object;

    public void createAndConect(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            socket = new Socket(inetAddress.getHostAddress(), 3000);
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
            message = in.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConfirmationFromServer(){
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            confirmation = in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getObjectFromServer(){
        try {
            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            // create a DataInputStream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
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

    public boolean getConfirmation(){
        return confirmation;
    }

    public Object getObject(){
        return object;
    }
}