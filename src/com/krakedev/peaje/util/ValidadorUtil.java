package com.krakedev.peaje.util;

public class ValidadorUtil {
    public static boolean esMontoValido (double monto) {
        if (monto > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean esTipoValido (String tipo) {
        if (tipo == "L" || tipo == "P") {
            return true;
        } else {
            return false;
        }
    }

}
