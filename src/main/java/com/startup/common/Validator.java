package com.startup.common;

import java.util.regex.*;

public interface Validator {
    String REGEX = new String();

    boolean validate(String text);
}
