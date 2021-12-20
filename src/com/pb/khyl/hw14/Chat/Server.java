package com.pb.khyl.hw14.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 1234;
    public static LinkedList<ServConnection> servConnections = new LinkedList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                        servConnections.add(new ServConnection(socket));
                } catch (Exception e) {
                         socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ServConnection extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ServConnection(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            start();
        }

        @Override
        public void run() {
            String message;
            try {

                while (true) {
                    message = in.readLine();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        for (ServConnection sc : Server.servConnections) {
                            sc.out.println(message);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
