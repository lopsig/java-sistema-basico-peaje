package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;

public class TestCrearConductor {
    public static void main(String[] args) {
        Conductor conductor = new Conductor("1712345678", "Jonathan", "López");
        conductor.imprimir();
    }
}