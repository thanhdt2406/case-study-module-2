package io;

import java.util.Scanner;

public abstract class InputFromKeyBoard implements IInputer {
    Scanner scanner = new Scanner(System.in);

    public abstract boolean input();
}
