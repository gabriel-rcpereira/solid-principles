package com.solid.srp.base;

import com.solid.srp.contract.FatorCalculo;
import com.solid.srp.model.Funcionario;

public abstract class BaseFatorCalculoService implements FatorCalculo {

    @Override
    public double aplicaCalculo(Funcionario funcionario) {
        return funcionario.getSalarioBase() * getFormulaCalculo(funcionario);
    }

    protected abstract double getFormulaCalculo(Funcionario funcionario);
}
