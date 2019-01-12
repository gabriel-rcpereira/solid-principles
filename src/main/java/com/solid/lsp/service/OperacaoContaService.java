package com.solid.lsp.service;

import com.solid.lsp.contract.OperacaoConta;
import com.solid.lsp.model.Conta;

public class OperacaoContaService implements OperacaoConta {

    private Conta conta;

    public OperacaoContaService(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void deposita(double valor) {
        this.createServiceResponsavel().deposita(valor);
    }

    @Override
    public void saca(double valor) {
        this.createServiceResponsavel().saca(valor);
    }

    @Override
    public void rende() {
        this.createServiceResponsavel().rende();
    }

    private OperacaoConta createServiceResponsavel(){
        OperacaoConta operacaoContaService;
        switch (this.conta.getTipoConta()){
            case ESTUDANTE:
                operacaoContaService = new OperacaoContaEstudanteService(this.conta);
                break;
            default:
                operacaoContaService = new OperacaoContaComumService(this.conta);
                break;
        }
        return operacaoContaService;
    }
}
