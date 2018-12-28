package com.solid.coupling.dao;

import com.solid.coupling.model.NotaFiscal;
import com.solid.coupling.service.NotaFiscalObserver;

public class NotaFiscalDao implements NotaFiscalObserver {

    public void executa(NotaFiscal nf) {
        System.out.println("salva nf no banco");
    }
}
