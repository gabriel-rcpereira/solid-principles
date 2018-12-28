package com.solid.coupling.service;

import com.solid.coupling.dao.NotaFiscalDao;
import com.solid.coupling.model.Fatura;
import com.solid.coupling.model.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalService {

    private final ImpostoDecorator impostoDecorator;

    private List<NotaFiscalObserver> notaFiscalObservers;

    public NotaFiscalService(ImpostoDecorator impostoDecorator) {
        this.impostoDecorator = impostoDecorator;

        this.notaFiscalObservers = new ArrayList<>();
    }

    public void addObserver(NotaFiscalObserver notaFiscalObserver){
        this.notaFiscalObservers.add(notaFiscalObserver);
    }

    public NotaFiscal create(Fatura fatura) {
        NotaFiscal notafiscal = createNotaFiscal(fatura);
        executeObservers(notafiscal);
        return notafiscal;
    }

    private void executeObservers(NotaFiscal notaFiscal) {
        this.notaFiscalObservers.forEach(notaFiscalObserver -> notaFiscalObserver.executa(notaFiscal));
    }

    private NotaFiscal createNotaFiscal(Fatura fatura) {
        return new NotaFiscal.Builder()
                    .withId(1)
                    .withValorBruto(fatura.getValorMensal())
                    .withImpostos(impostoDecorator.calculaImposto(fatura))
                    .build();
    }
}
