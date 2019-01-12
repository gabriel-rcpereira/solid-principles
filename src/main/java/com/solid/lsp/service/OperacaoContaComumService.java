package com.solid.lsp.service;

import com.solid.lsp.contract.OperacaoConta;
import com.solid.lsp.model.Conta;

public class OperacaoContaComumService implements OperacaoConta {

    private Conta conta;

    public OperacaoContaComumService(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void deposita(double valor) {
        setSaldoNaConta(getSaldoIncrementado(valor));
    }

    @Override
    public void saca(double valor) {
        if (!isSaquePermitido(valor)) {
            throw new IllegalArgumentException();
        }

        setSaldoNaConta(getSaldoDecrementado(valor));
    }

    @Override
    public void rende() {
        double saldoComRendimento = this.conta.getSaldo() * 0.01;
        setSaldoNaConta(getSaldoIncrementado(saldoComRendimento));
    }

    private boolean isSaquePermitido(double valor) {
        return valor <= this.conta.getSaldo();
    }

    private void setSaldoNaConta(double valor){
        this.conta.setSaldo(valor);
    }

    private double getSaldoIncrementado(double valor) {
        return this.conta.getSaldo() + valor;
    }

    private double getSaldoDecrementado(double valor) {
        return this.conta.getSaldo() - valor;
    }
}
