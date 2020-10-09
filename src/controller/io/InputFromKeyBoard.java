package controller.io;

import java.util.Scanner;

public abstract class InputFromKeyBoard{
    Scanner scanner = new Scanner(System.in);

    public InputFromKeyBoard() {
    }

    public abstract boolean input();

}
