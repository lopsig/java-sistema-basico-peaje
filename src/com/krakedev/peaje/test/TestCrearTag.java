package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.TagElectronico;

public class TestCrearTag {
    public static void main(String[] args) {
        TagElectronico tag = new TagElectronico("TAG-001");
        tag.imprimir();
    }
}