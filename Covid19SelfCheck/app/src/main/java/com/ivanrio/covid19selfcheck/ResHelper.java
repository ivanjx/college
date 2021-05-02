package com.ivanrio.covid19selfcheck;

public final class ResHelper {
    private static MainActivity _activity;

    public static void inject(MainActivity activity) {
        _activity = activity;
    }

    public static String getRes(String name) {
        if (name == null) {
            return "";
        }

        return _activity.getString(_activity.getResources().getIdentifier(name, "string", _activity.getPackageName()));
    }

    public static int getColor(String name) {
        if (name == null) {
            return 0;
        }

        return _activity.getColor(_activity.getResources().getIdentifier(name, "color", _activity.getPackageName()));
    }
}
