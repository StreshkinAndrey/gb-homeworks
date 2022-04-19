package ru.gb.homeworks.lesson6;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        SRV s = new SRV();
        s.start();
        s.catchClient();
        new Thread() {
            public void run() {
                while (true) {
                    String txt = null;
                    try {
                        txt = s.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (txt != null) {
                        try {
                            s.sendMessage(txt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    s.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class SRV {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    String input;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(1111);
        } catch (IOException e) {
            System.out.println("Не могу открыть порт 1111");
            System.exit(1);
        }
        System.out.println("Сервер запущен, ожидаем подключения...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
        } catch (IOException e) {
            System.out.println("Не могу принять");
            System.exit(1);
        }

        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);

        System.out.println("Ожидание сообщений...");
    }

    void sendMessage(String msg) throws IOException {
        if (msg.equalsIgnoreCase("exit")) close();
        out.println("S ::: " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}
