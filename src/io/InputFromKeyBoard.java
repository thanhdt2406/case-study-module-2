package io;

import java.util.Scanner;

public class InputFromKeyBoard {
    Scanner scanner = new Scanner(System.in);

    private int inputInt(){
        int value = 0;
        try {
            value = scanner.nextInt();
        }catch (NumberFormatException e){
            System.out.println("pls input a number!");
        }
        return value;
    }
}
