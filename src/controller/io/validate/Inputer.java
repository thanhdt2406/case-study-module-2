package controller.io.validate;

import java.util.Scanner;

public class Inputer {

    public int inputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean check;
        System.out.println(message);
        do {
            try {
                value = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input error, please try again!!!");
                check = true;
            }
        } while (check);
        return value;
    }

    public String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public int inputPhoneNumber(String message){
        ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();
        boolean isValid;
        String phoneValidate;
        do {
            phoneValidate = inputString(message);
            isValid = validatePhoneNumber.validate(phoneValidate);
        } while (!isValid);
        return Integer.parseInt(phoneValidate);
    }

    public String inputAccount(String message){
        ValidateAccount validateAccount = new ValidateAccount();
        boolean isValid;
        String accountValidate;
        do {
            accountValidate = inputString(message);
            isValid = validateAccount.validate(accountValidate);
        } while (!isValid);
        return accountValidate;
    }
}
