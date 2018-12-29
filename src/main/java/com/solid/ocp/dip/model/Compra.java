package com.solid.ocp.dip.model;

import com.solid.ocp.dip.enums.Estado;

public class Compra {

    private double valor;
    private Estado estado;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static final class Builder {

        private Compra compra = new Compra();

        public Builder withValor(double valor) {
            compra.setValor(valor);
            return this;
        }

        public Builder withEstado(Estado estado) {
            compra.setEstado(estado);
            return this;
        }

        public Compra build() {
            return compra;
        }
    }
}
