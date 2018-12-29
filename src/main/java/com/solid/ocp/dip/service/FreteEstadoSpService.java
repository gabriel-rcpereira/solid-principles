package com.solid.ocp.dip.service;

import com.solid.ocp.dip.contract.FreteEstado;

public class FreteEstadoSpService implements FreteEstado {

    @Override
    public double getTaxa() {
        return 15;
    }
}
