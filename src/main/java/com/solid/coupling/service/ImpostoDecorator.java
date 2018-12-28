package com.solid.coupling.service;

import com.solid.coupling.model.Fatura;

public abstract class ImpostoDecorator {

    private ImpostoDecorator impostoDecorator;

    protected ImpostoDecorator() {

    }

    protected ImpostoDecorator(ImpostoDecorator impostoDecorator) {
        this.impostoDecorator = impostoDecorator;
    }

    public double calculaImposto(Fatura fatura) {
        double impostoCalculado = getImpostoCalculado(fatura);
        if (impostoDecorator != null){
            impostoCalculado += impostoDecorator.getImpostoCalculado(fatura);
        }
        return impostoCalculado;
    }

    protected abstract double getImpostoCalculado(Fatura fatura);
}
