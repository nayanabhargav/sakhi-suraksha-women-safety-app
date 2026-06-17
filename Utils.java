package com.Sakhii.Suraksha;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final String PREFS = "wsafe_prefs";
    private static final String KEY_CONTACTS = "contacts";

    public static void addEmergencyContact(Context ctx, String number) {
        SharedPreferences p = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String cur = p.getString(KEY_CONTACTS, "");
        String next = cur.isEmpty() ? number : cur + "," + number;
        p.edit().putString(KEY_CONTACTS, next).apply();
    }

    public static List<String> getEmergencyContacts(Context ctx) {
        SharedPreferences p = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String cur = p.getString(KEY_CONTACTS, "");
        if (cur.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(cur.split(",")));
    }
}
