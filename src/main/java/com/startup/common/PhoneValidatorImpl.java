package com.startup.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidatorImpl implements Validator {
    private static final String REGEX = "^((1-)?)([0-9]{3})((-)?)([0-9]{3})((-)?)([0-9]{4})$";

    @Override
    public boolean validate(String text) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        return m.matches();
    }
}
