package com.solid.coupling;

import com.solid.coupling.base.ImpostoDecorator;
import com.solid.coupling.dao.NotaFiscalDao;
import com.solid.coupling.model.Fatura;
import com.solid.coupling.model.NotaFiscal;
import com.solid.coupling.service.*;

public class CouplingMain {

    public static void main(String[] args){
        Fatura fatura = new Fatura.Builder()
                .withCliente("Cliente 1")
                .withValorMensal(1000.00)
                .build();

        ImpostoDecorator issAndIcms = new IssService(new IcmsService());

        NotaFiscalService notaFiscalService = new NotaFiscalService(issAndIcms);
        notaFiscalService.addObserver(new EmailService());
        notaFiscalService.addObserver(new NotaFiscalDao());
        NotaFiscal notaFiscal = notaFiscalService.create(fatura);

        System.out.println("Valor impostos:");
        System.out.println(notaFiscal.getImpostos());

        System.out.println("Valor bruto:");
        System.out.println(notaFiscal.getValorBruto());
    }
}
