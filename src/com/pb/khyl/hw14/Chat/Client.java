package com.pb.khyl.hw14.Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client {
        private static Socket socket;
        private static BufferedReader inConsole;
        private static BufferedReader in;
        private static PrintWriter out;
        private static String message;
        private static String userName;



    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 1234);
            inConsole = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Введите ник: ");
            userName = inConsole.readLine();
            out.println(userName + " присоединился к беседе");
            new ReadMsg().start();
            new WriteMsg().start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static class ReadMsg extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(in.readLine());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class WriteMsg extends Thread {
        LocalDateTime now;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime;
        @Override
        public void run() {
            while (true) {
                now = LocalDateTime.now();
                currentTime = now.format(df);
                try {
                    out.println(userName + " " + currentTime + ": " + inConsole.readLine());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
