package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestRegistrarVehiculo {
    public static void main(String[] args) {
        EstacionPeaje estacion = new EstacionPeaje();
        Conductor conductor = new Conductor("1712345678", "Carlos", "Perez");

        Vehiculo vehiculo = estacion.registrarVehiculo("PBA-1234", "L", conductor, "TAG-001");
        ImpresorUtil.imprimir(vehiculo);
    }
}