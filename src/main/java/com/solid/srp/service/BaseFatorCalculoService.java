package com.solid.srp.service;

import com.solid.srp.model.Funcionario;

public abstract class BaseFatorCalculoService implements FatorCalculo {

    @Override
    public double aplicaCalculo(Funcionario funcionario) {
        return funcionario.getSalarioBase() * getFormulaCalculo(funcionario);
    }

    protected abstract double getFormulaCalculo(Funcionario funcionario);
}
