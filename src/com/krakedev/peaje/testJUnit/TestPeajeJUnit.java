package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestPeajeJUnit {

    @Test
    public void testRegistrarVehiculo() {
        EstacionPeaje estacion = new EstacionPeaje();
        Conductor conductor = new Conductor("1712345678", "Jonathan", "López");

        Vehiculo vehiculo = estacion.registrarVehiculo("PBA-1234", "L", conductor, "TAG-001");

        assertNotNull(vehiculo);
        assertEquals("PBA-1234", vehiculo.getPlaca());
        assertEquals("L", vehiculo.getTipo());
        assertEquals("Jonathan", vehiculo.getPropietario().getNombre());
        assertEquals("López", vehiculo.getPropietario().getApellido());
        assertEquals("TAG-001", vehiculo.getTag().getIdTag());
    }

    @Test
    public void testRecargarTag() {
        EstacionPeaje estacion = new EstacionPeaje();
        TagElectronico tag = new TagElectronico("TAG-001");

        estacion.recargarTag(tag, 15.0);

        assertEquals(15.0, tag.getSaldo());
    }

    @Test
    public void testCobrarPeaje() {
        EstacionPeaje estacion = new EstacionPeaje();
        Conductor conductor = new Conductor("1712345678", "Carlos", "Perez");
        Vehiculo vehiculo = estacion.registrarVehiculo("PBA-1234", "L", conductor, "TAG-001");

        estacion.recargarTag(vehiculo.getTag(), 5.0);
        estacion.cobrarPeaje(vehiculo);

        // Tarifa Liviano = 1.00; Saldo esperado = 4.00
        assertEquals(4.0, vehiculo.getTag().getSaldo());
    }

    @Test
    public void testTransferirSaldoTag() {
        EstacionPeaje estacion = new EstacionPeaje();
        TagElectronico tagOrigen = new TagElectronico("TAG-001");
        TagElectronico tagDestino = new TagElectronico("TAG-002");

        estacion.recargarTag(tagOrigen, 20.0);
        estacion.transferirSaldoTag(tagOrigen, tagDestino, 5.0);

        assertEquals(15.0, tagOrigen.getSaldo());
        assertEquals(5.0, tagDestino.getSaldo());
    }
}

//PROMPT IA
/*
Genera una clase de prueba unitaria con JUnit 5 llamada TestPeajeJUnit para verificar los metodos.
Necesito probar que al registrar un vehículo los datos queden bien guardados, que la recarga de saldo funcione,
que al cobrar peaje descuente el $1.00 de tarifa liviana y que la transferencia pase el saldo de un tag a otro.
Usa assertEquals.

Estas son las clases que se desarrollaron para este proyecto:
- Conductor:
- TagElectronico:
- Vehiculo:
- EstacionPeaje:

Tambien te comparto los test que se desarrollaron para las clases:
- TestCrearConductor:
- TestCrearTag:
- TestCrearVehiculo:
- TestRegistrarVehiculo

IMPORTANTE:
No generes nada extra, no hagas modificaciones a las clases, limitate a usar solo los codigos que te comparti por favor.
*/
