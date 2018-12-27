package com.solid.srp.enums;

import com.solid.srp.service.DezOuVintePorcentoService;
import com.solid.srp.service.FatorCalculo;
import com.solid.srp.service.QuinzeOuVinteCincoPorcentoService;

public enum Cargo {

    DESENVOLVEDOR(new DezOuVintePorcentoService()),
    DBA(new QuinzeOuVinteCincoPorcentoService()),
    TESTER(new QuinzeOuVinteCincoPorcentoService());

    private FatorCalculo fatorCalculo;

    Cargo(FatorCalculo fatorCalculo) {
        this.fatorCalculo = fatorCalculo;
    }

    public FatorCalculo getFatorCalculo() {
        return fatorCalculo;
    }
}
