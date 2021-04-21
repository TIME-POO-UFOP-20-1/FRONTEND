package com.GUI;

import com.socket.Client;

import javax.swing.JFrame;

public class Principal extends JFrame{
    private Client client;

    public Principal(String title){
        super(title);
        createGUI();
    }

    private void createGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(1080, 540);
        setContentPane(new Login(this));
        client = new Client();
        client.createAndConect();
    }

    public void sendMessage(String message){
        client.sendStringMessage(message);
    }

    public boolean getConfirmation(){
        client.getConfirmationFromServer();
        return client.getConfirmation();
    }

    public Object getObject(){
        client.getObjectFromServer();
        return client.getObject();
    }

    public void stopConection(){
        client.stopConnection();
    }

}
