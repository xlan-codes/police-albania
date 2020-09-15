package com.vesa.wazeapi.utils;

public class NotificationServices {
    public static String getMessage(String superType) {
        if (superType.startsWith("HAZARD")){
            return "U Raportua Aksident";
        } else if(superType.startsWith("POLICE")) {
            return "U raportua police";
        } else if(superType.startsWith("TRAFFIC")) {
            return "U raportua qe ka trafik";
        } else if(superType.startsWith("RADAR")) {
            return "U raporta qe ka radar";
        }

        return "";
    }
}
