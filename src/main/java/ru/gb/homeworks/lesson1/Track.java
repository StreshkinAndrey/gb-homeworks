package ru.gb.homeworks.lesson1;

public class Track implements Barrier {
    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Player player) {
        player.run(this);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Беговая дорожка длиной " + length + " метров.";
    }
}
