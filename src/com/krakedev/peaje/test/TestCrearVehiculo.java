package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Vehiculo;

public class TestCrearVehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("PBA-1234");
        vehiculo.imprimir();
    }
}