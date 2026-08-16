package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
    public static void imprimirVehiculo(Vehiculo vehiculo) {
    }

    public static void imprimir(Vehiculo vehiculo){
        String mensaje = "Placa: " + vehiculo.getPlaca() +
                "\nTipo: " + vehiculo.getTipo() +
                "\nCI Propietario: " + vehiculo.getPropietario().getCedula() +
                "\nNombre Propietario: " + vehiculo.getPropietario().getNombre() + "" + vehiculo.getPropietario().getApellido() +
                "\nID Tag: " + vehiculo.getTag().getIdTag() +
                "\nSaldo Tag: " + vehiculo.getTag().getSaldo() +
                "\nEstado Tag: " + vehiculo.getTag().getActivo();

        System.out.println(mensaje);

    }
}
