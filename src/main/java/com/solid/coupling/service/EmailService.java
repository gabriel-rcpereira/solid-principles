package com.solid.coupling.service;

import com.solid.coupling.contract.NotaFiscalObserver;
import com.solid.coupling.model.NotaFiscal;

public class EmailService implements NotaFiscalObserver {

    public void executa(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}
