package ru.gb.homeworks.lesson1;

public class App {
    public static void main(String[] args) {
        Player[] players = {
                new Human(),
                new Robot(),
                new Cat()
        };

        Barrier[] barriers = {
                new Track(4),
                new Wall(2),
                new Track(10),
                new Wall(3)
        };

        for (Barrier barrier : barriers) {
            for (Player player : players) {
                barrier.overcome(player);
            }
        }

        System.out.println("-- Победители --");
        for (Player player : players) {
            if (player.isPlay()) {
                System.out.println(player);
            }
        }
    }
}
