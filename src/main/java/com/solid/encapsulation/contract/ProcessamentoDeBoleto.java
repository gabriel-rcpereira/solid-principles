package com.solid.encapsulation.contract;

import com.solid.encapsulation.model.Boleto;
import com.solid.encapsulation.model.Fatura;

import java.util.List;

public interface ProcessamentoDeBoleto {
    void processa(List<Boleto> boletos, Fatura fatura);
}
