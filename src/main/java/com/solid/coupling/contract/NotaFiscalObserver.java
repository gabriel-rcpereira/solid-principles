package com.solid.coupling.contract;

import com.solid.coupling.model.NotaFiscal;

public interface NotaFiscalObserver {

    void executa(NotaFiscal notaFiscal);
}
