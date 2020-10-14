package controller.io.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber implements IValidate{
    public ValidatePhoneNumber(){

    }

    @Override
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile("^[0]\\d{9}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
