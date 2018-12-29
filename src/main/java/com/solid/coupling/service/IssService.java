package com.solid.coupling.service;

import com.solid.coupling.base.ImpostoDecorator;
import com.solid.coupling.model.Fatura;

public class IssService extends ImpostoDecorator {

    public IssService() {
    }

    public IssService(ImpostoDecorator impostoDecorator) {
        super(impostoDecorator);
    }

    @Override
    protected double getImpostoCalculado(Fatura fatura) {
        return fatura.getValorMensal() * 0.05;
    }
}
