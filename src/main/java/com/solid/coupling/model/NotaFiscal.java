package com.solid.coupling.model;

public class NotaFiscal {

    private int id;
    private double valorBruto;
    private double impostos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getImpostos() {
        return impostos;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public static final class Builder {

        private NotaFiscal notaFiscal = new NotaFiscal();

        public Builder withId(int id) {
            notaFiscal.setId(id);
            return this;
        }

        public Builder withValorBruto(double valorBruto) {
            notaFiscal.setValorBruto(valorBruto);
            return this;
        }

        public Builder withImpostos(double impostos) {
            notaFiscal.setImpostos(impostos);
            return this;
        }

        public NotaFiscal build() {
            return notaFiscal;
        }
    }
}
