package com.pb.khyl.hw14.Echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            LocalDateTime now;
            String currentTime;
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
           {
                System.out.println("Подключен новый клиент");

                String clientMessage;

                // цикл ожидания сообщений от клиента
                System.out.println("Ожидаем сообщений");
                while ((clientMessage = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    now = LocalDateTime.now();
                    currentTime = now.format(df);
                    out.println("Сервер " + currentTime + ": " + clientMessage);
                    System.out.println(clientMessage);
                }
           } catch (Exception ex) {
               ex.printStackTrace();
           } finally {
               try {
                   socket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

        }
    }

    public static void main(String[] args) throws Exception {

        int serverPort = 1234;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Старт сервера");

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}