package com.solid.coupling.service;

import com.solid.coupling.base.ImpostoDecorator;
import com.solid.coupling.model.Fatura;

public class IcmsService extends ImpostoDecorator {

    public IcmsService() {
    }

    public IcmsService(ImpostoDecorator impostoDecorator) {
        super(impostoDecorator);
    }

    @Override
    protected double getImpostoCalculado(Fatura fatura) {
        return fatura.getValorMensal() * 0.10;
    }
}
