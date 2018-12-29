package com.solid.ocp.dip.contract;

import com.solid.ocp.dip.enums.Estado;

public interface Frete {

    double calcular(Estado estado);
}