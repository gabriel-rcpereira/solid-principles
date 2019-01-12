package com.solid.lsp.model;

import com.solid.lsp.enums.TipoConta;

public class Conta {

    private String cliente;
    private double saldo;
    private double milhas;
    private TipoConta tipoConta;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMilhas() {
        return milhas;
    }

    public void setMilhas(double milhas) {
        this.milhas = milhas;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public static final class Builder {

        private Conta conta = new Conta();

        public Builder withCliente(String cliente) {
            conta.setCliente(cliente);
            return this;
        }

        public Builder withSaldo(double saldo) {
            conta.setSaldo(saldo);
            return this;
        }

        public Builder withMilhas(double milhas) {
            conta.setMilhas(milhas);
            return this;
        }

        public Builder withTipoConta(TipoConta tipoConta) {
            conta.setTipoConta(tipoConta);
            return this;
        }

        public Conta build() {
            return conta;
        }
    }
}
