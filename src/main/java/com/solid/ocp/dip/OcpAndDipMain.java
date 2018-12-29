package com.solid.ocp.dip;

import com.solid.ocp.dip.contract.Calculadora;
import com.solid.ocp.dip.contract.Desconto;
import com.solid.ocp.dip.contract.Frete;
import com.solid.ocp.dip.enums.Estado;
import com.solid.ocp.dip.model.Compra;
import com.solid.ocp.dip.service.CalculadoraDePrecoService;
import com.solid.ocp.dip.service.FreteService;
import com.solid.ocp.dip.service.TabelaDePrecoPadraoService;

import java.util.Arrays;
import java.util.List;

public class OcpAndDipMain {

    public static void main(String[] args){
        List<Desconto> descontos = Arrays.asList(new TabelaDePrecoPadraoService());
        Frete frete = new FreteService();

        Compra compra = new Compra.Builder()
                .withEstado(Estado.SP)
                .withValor(1000.01)
                .build();

        Calculadora calculadoraDePrecoService = new CalculadoraDePrecoService(descontos, frete);
        System.out.println(calculadoraDePrecoService.calcular(compra));
    }
}
