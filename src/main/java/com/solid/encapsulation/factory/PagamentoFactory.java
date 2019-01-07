package com.solid.encapsulation.factory;

import com.solid.encapsulation.enums.MeioDePagamento;
import com.solid.encapsulation.model.Boleto;
import com.solid.encapsulation.model.Pagamento;

public class PagamentoFactory {
    public Pagamento create(Boleto boleto){
        return new Pagamento.Builder()
                .withValor(boleto.getValor())
                .withForma(MeioDePagamento.BOLETO)
                .build();
    }
}
