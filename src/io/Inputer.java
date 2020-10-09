package io;

public class Inputer extends InputFromKeyBoard{

    @Override
    public boolean input() {
        return false;
    }

    public int inputInt(){
        int value = 0;
        try {
            value = scanner.nextInt();
        }catch (NumberFormatException e){
            System.out.println("pls input a number!");
        }
        return value;
    }

    public String inputString(){
        scanner.nextLine();
        String str = scanner.nextLine();
        System.out.println(str);
        return str;
    }
}
