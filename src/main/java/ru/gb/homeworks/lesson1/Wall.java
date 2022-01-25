package ru.gb.homeworks.lesson1;

public class Wall implements Barrier {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }


    @Override
    public void overcome(Player player) {
        player.jump(this);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Барьер высотой " + height + " метров.";
    }
}
