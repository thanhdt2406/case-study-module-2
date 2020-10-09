package controller.io;

public class Inputer extends InputFromKeyBoard{

    @Override
    public boolean input() {
        return false;
    }

    public int inputInt(){
        int value = 0;
        boolean check =true;
        do {
            try {
                value = scanner.nextInt();
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
