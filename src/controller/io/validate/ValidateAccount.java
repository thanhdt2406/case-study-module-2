package controller.io.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount implements IValidate{
    public ValidateAccount() {

    }

    @Override
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile("^[\\S]\\w{4,29}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
