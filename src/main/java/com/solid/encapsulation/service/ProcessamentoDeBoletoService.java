package com.solid.encapsulation.service;

import com.solid.encapsulation.contract.ProcessamentoDeBoleto;
import com.solid.encapsulation.factory.PagamentoFactory;
import com.solid.encapsulation.model.Boleto;
import com.solid.encapsulation.model.Fatura;

import java.util.List;

public class ProcessamentoDeBoletoService implements ProcessamentoDeBoleto {
    private PagamentoFactory pagamentoFactory;

    public ProcessamentoDeBoletoService() {
        this.pagamentoFactory = new PagamentoFactory();
    }

    public void processa(List<Boleto> boletos, Fatura fatura) {
        for(Boleto boleto : boletos) {
            fatura.addPagamento(this.pagamentoFactory.create(boleto));
        }
    }
}
