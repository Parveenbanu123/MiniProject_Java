package com.mphasis.util;

import java.text.DecimalFormat;

public class FormatterUtil {
	public static DecimalFormat getDecimalFormat() {
        return new DecimalFormat("#0.00");
    }
}
