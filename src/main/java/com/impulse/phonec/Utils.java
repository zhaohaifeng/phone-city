package com.impulse.phonec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaohaifeng
 * @since 2015-03-10
 */
public class Utils {

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhone(String mobile) {
        if (isBlank(mobile)) {
            return false;
        }
        Pattern p = Pattern.compile("^(((1\\d{10})|((\\d{3,4}-)?\\d{7,8}))[ ]?)+$");
        Matcher m = p.matcher(mobile);
        return m.find();
    }
}
