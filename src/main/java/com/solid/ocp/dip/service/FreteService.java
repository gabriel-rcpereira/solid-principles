package com.solid.ocp.dip.service;

import com.solid.ocp.dip.contract.Frete;
import com.solid.ocp.dip.contract.FreteEstado;
import com.solid.ocp.dip.enums.Estado;

public class FreteService implements Frete {

    public double calcular(Estado estado) {
        return createFreteEstado(estado).getTaxa();
    }

    private FreteEstado createFreteEstado(Estado estado) {
        FreteEstado freteEstado;
        switch (estado){
            case SP:
                freteEstado = new FreteEstadoSpService();
                break;
            default:
                freteEstado = new FreteEstadoPadraoService();
                break;
        }
        return freteEstado;
    }
}
