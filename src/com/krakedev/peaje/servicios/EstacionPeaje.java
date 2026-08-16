package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

public class EstacionPeaje {
    private int codigoEstacion = 500;
    private double tarifaLiviano = 1.00;
    private double tarifaPesado = 2.50;

    public  EstacionPeaje() {}

    public int getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(int codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public double getTarifaLiviano() {
        return tarifaLiviano;
    }

    public void setTarifaLiviano(double tarifaLiviano) {
        this.tarifaLiviano = tarifaLiviano;
    }

    public double getTarifaPesado() {
        return tarifaPesado;
    }

    public void setTarifaPesado(double tarifaPesado) {
        this.tarifaPesado = tarifaPesado;
    }

    //METODOS
    public Vehiculo registrarVehiculo(String placa, String tipo, Conductor propietario, String idTag) {
        if (ValidadorUtil.esTipoValido(tipo)) {
            Vehiculo vehiculo = new Vehiculo(placa);
            vehiculo.setTipo(tipo);
            vehiculo.setPropietario(propietario);

            TagElectronico tag = new TagElectronico(idTag);
            vehiculo.setTag(tag);

            return vehiculo;
        } else {
            return null;
        }
    }

    public void recargarTag(TagElectronico tag, double monto) {
        if (ValidadorUtil.esMontoValido(monto)) {
            double nuevoSaldo = tag.getSaldo() + monto;
            tag.setSaldo(nuevoSaldo);
        }
    }

    public void cobrarPeaje(Vehiculo vehiculo) {
        double tarifa = 0;

        if (vehiculo.getTipo() == "L") {
            tarifa = tarifaLiviano;
        } else if (vehiculo.getTipo() == "P") {
            tarifa = tarifaPesado;
        }

        if (vehiculo.getTag().getSaldo() >= tarifa) {
            double nuevoSaldo = vehiculo.getTag().getSaldo() - tarifa;
            vehiculo.getTag().setSaldo(nuevoSaldo);
        }
    }

    public void transferirSaldoTag(TagElectronico origen, TagElectronico destino, double monto) {
        if (ValidadorUtil.esMontoValido(monto)) {
            if (origen.getSaldo() >= monto) {
                origen.setSaldo(origen.getSaldo() - monto);
                destino.setSaldo(destino.getSaldo() + monto);
            }
        }
    }




}
