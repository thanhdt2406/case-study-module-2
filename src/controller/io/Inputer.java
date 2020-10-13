package controller.io;

import java.util.Scanner;

public class Inputer {
    private Scanner scanner = new Scanner(System.in);

    public int inputInt(String message) {
        int value = 0;
        boolean check = true;
        System.out.println(message);
        do {
            try {
                value = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("pls input a number!");
                check = true;
            }
        } while (check);
        return value;
    }

    public String inputString(String message) {
        System.out.println(message);
        String str = scanner.nextLine();
        return str;
    }
}
