package com.coding.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    public static String now() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
