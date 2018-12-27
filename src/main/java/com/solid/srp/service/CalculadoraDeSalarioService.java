package com.solid.srp.service;

import com.solid.srp.model.Funcionario;

public class CalculadoraDeSalarioService {

    public double calcula(Funcionario funcionario) {
        return funcionario.getCargo().getFatorCalculo().aplicaCalculo(funcionario);
    }
}
