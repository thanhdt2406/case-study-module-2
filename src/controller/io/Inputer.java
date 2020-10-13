package controller.io;

import java.util.Scanner;

public class Inputer{
     private Scanner scanner = new Scanner(System.in);

    public int inputInt(){
        int value = 0;
        boolean check =true;
        do {
            try {
                value = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (NumberFormatException e){
                System.out.println("pls input a number!");
                check = true;
            }
        }while (check);

        return value;
    }

    public String inputString(){
        //scanner.nextLine();
        String str = scanner.nextLine();
        System.out.println(str);
        return str;
    }
}
