package com.pb.khyl.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private JTextField jTextField;
    private JTextArea jTextArea;



    public ClientWindow() {
        try {
            clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jTextArea);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Send");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jTextField = new JTextField("Enter a message: ");
        bottomPanel.add(jTextField, BorderLayout.CENTER);

        jbSendMessage.addActionListener(e -> {

            if (!jTextField.getText().trim().isEmpty()) {
                sendMsg();
                jTextField.grabFocus();
            }
        });

        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setText("");
            }
        });


        new Thread(() -> {
            try {
                while (true) {
                    if (inMessage.hasNext()) {
                        String inMes = inMessage.nextLine();
                        jTextArea.append(inMes);
                        jTextArea.append("\n");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = jTextField.getText();
        outMessage.println(messageStr);
        outMessage.flush();
        jTextField.setText("");
    }
}