package ru.gb.homeworks.lesson2;

public class App {
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"4", "3", "2", "1"}, {"3", "4", "1", "2"}, {"2", "1", "3", "4"}};
        try {
            try {
                int result = method(arr);
                System.out.println("Результат расчёта: " + result);
            } catch (MyArraySizeException e) {
                System.out.println("Неправильный размер массива!");
            }
            } catch (MyArrayDataException e) {
                System.out.println("Неправильное значение массива!");
                e.printStackTrace();
            }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
            for (String string : strings) {
                try {
                    count = count + Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }

        }
        return count;
    }

}
