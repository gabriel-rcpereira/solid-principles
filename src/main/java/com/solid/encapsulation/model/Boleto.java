package com.solid.encapsulation.model;

public class Boleto {

    private double valor;

    private Boleto(Builder builder) {
        this.valor = builder.valor;
    }

    public double getValor() {
        return valor;
    }

    public static class Builder {

        private double valor;

        public Builder withValor(double valor){
            this.valor = valor;
            return this;
        }

        public Boleto build() {
            return new Boleto(this);
        }
    }
}
