package com.solid.ocp.dip.service;

import com.solid.ocp.dip.contract.Calculadora;
import com.solid.ocp.dip.contract.Desconto;
import com.solid.ocp.dip.contract.Frete;
import com.solid.ocp.dip.model.Compra;

public class CalculadoraDePrecoService implements Calculadora {

    private Desconto desconto;
    private Frete frete;

    public CalculadoraDePrecoService(Desconto desconto, Frete frete){
        this.desconto = desconto;
        this.frete = frete;
    }

    public double calcular(Compra produto) {
        double descontoCalculado = calcularDesconto(produto);
        double frete = calcularFrete(produto);

        return calcularValorFinal(produto, descontoCalculado, frete);
    }

    private double calcularValorFinal(Compra produto, double descontoCalculado, double frete) {
        return (produto.getValor() * (1-descontoCalculado)) + frete;
    }

    private double calcularFrete(Compra produto) {
        return this.frete.calcular(produto.getEstado());
    }

    private double calcularDesconto(Compra produto) {
        return this.desconto.calcular(produto.getValor());
    }
}
