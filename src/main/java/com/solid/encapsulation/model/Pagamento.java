package com.solid.encapsulation.model;

import com.solid.encapsulation.enums.MeioDePagamento;

public class Pagamento {
    private double valor;
    private MeioDePagamento forma;

    public Pagamento(Builder builder) {
        this.valor = builder.valor;
        this.forma = builder.forma;
    }

    public double getValor() {
        return valor;
    }

    public MeioDePagamento getForma() {
        return forma;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pagamento)) {
            return false;
        }
        Pagamento outro = (Pagamento) obj;
        if (forma != outro.forma ||
                Double.doubleToLongBits(valor) != Double.doubleToLongBits(outro.valor)) {
            return false;
        }

        return true;
    }

    public static final class Builder {
        private double valor;
        private MeioDePagamento forma;

        public Builder withValor(double valor) {
            this.valor = valor;
            return this;
        }

        public Builder withForma(MeioDePagamento forma) {
            this.forma = forma;
            return this;
        }

        public Pagamento build() {
            return new Pagamento(this);
        }
    }
}
