package io;

import java.util.Scanner;

public abstract class InputFromKeyBoard implements IInputer {
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

    public abstract boolean input();

}
