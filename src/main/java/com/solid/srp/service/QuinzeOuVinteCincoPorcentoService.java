package com.solid.srp.service;

import com.solid.srp.model.Funcionario;

public class QuinzeOuVinteCincoPorcentoService extends BaseFatorCalculoService {

    protected double getFormulaCalculo(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 2000.0) {
            return 0.75;
        } else {
            return 0.85;
        }
    }
}
