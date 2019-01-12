package com.solid.lsp.service;

import com.solid.lsp.contract.OperacaoConta;
import com.solid.lsp.model.Conta;

public class OperacaoContaEstudanteService implements OperacaoConta {

    private Conta conta;
    private OperacaoConta operacaoConta;

    public OperacaoContaEstudanteService(Conta conta) {
        this.conta = conta;
        this.operacaoConta = new OperacaoContaComumService(this.conta);
    }

    @Override
    public void deposita(double valor) {
        this.setMilhasConta(getMilhasIncrementada(valor));
        this.operacaoConta.deposita(valor);
    }

    @Override
    public void saca(double valor) {
        this.operacaoConta.saca(valor);
    }

    @Override
    public void rende() {
        throw new RuntimeException("Não pode render");
    }

    private double getMilhasIncrementada(double valor) {
        return this.conta.getMilhas() + valor;
    }

    private void setMilhasConta(double valor) {
        this.conta.setMilhas(valor);
    }
}
