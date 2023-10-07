package org.example.pruebasAisladas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyTaxesTestClass {

    private MyTaxesClass m;

    @Test
    void demoTestMethod() {
        this.m = new MyTaxesClass();
        //mi test chequea que el resultado de agregarle el iva a 10 sea 11.21
        assertEquals(12.1,m.addIVA(10));
    }

}
