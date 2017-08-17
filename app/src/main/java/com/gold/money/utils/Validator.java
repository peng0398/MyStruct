package com.gold.money.utils;

import android.text.TextUtils;

/**
 * Created by Bob.
 */
public class Validator {

    public Validator() {

    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
