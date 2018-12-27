package com.solid.srp.service;

import com.solid.srp.model.Funcionario;

public class DezOuVintePorcentoService extends BaseFatorCalculoService {

    protected double getFormulaCalculo(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000.0) {
            return 0.8;
        } else {
            return 0.9;
        }
    }
}
