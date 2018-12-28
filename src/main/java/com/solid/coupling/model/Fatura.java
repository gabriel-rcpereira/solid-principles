package com.solid.coupling.model;

public class Fatura {

    private double valorMensal;
    private String cliente;

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    public static final class Builder {

        private Fatura fatura = new Fatura();

        public Builder withValorMensal(double valorMensal) {
            fatura.setValorMensal(valorMensal);
            return this;
        }

        public Builder withCliente(String cliente) {
            fatura.setCliente(cliente);
            return this;
        }

        public Fatura build() {
            return fatura;
        }
    }
}
