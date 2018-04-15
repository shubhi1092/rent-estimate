package com.startup.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorImpl implements Validator {

    private static final String REGEX = "^([a-zA-z]+)([\\.!?-_0-9a-zA-Z]*)@([a-z]+)((\\.([a-z]{2,})){1,2})$";

    @Override
    public boolean validate(String text) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        return m.matches();
    }
}
