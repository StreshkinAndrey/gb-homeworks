package ru.gb.homeworks.lesson1;

public class Human implements Player {

    private boolean play = true;
    private static final int RUN_LIMIT = 100;
    private static final int JUMP_LIMIT = 2;

    @Override
    public void jump(Wall wall) {
        if (isPlay()) {
            if (wall.getHeight() <= JUMP_LIMIT) {
                System.out.println(this + " успешно перепрыгнул " + wall);
            } else {
                System.out.println(this + " не перепрыгнул " + wall);
                play = false;
            }
        }
    }

    @Override
    public boolean isPlay() { return play; }

    @Override
    public void run(Track track) {
        if (isPlay()) {
            if (track.getLength() <= RUN_LIMIT) {
                System.out.println(this + " пробежал " + track);
            } else {
                System.out.println(this + " не пробежал " + track);
                play = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human";
    }
}
