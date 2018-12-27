package com.solid.srp;

import com.solid.srp.enums.Cargo;
import com.solid.srp.model.Funcionario;
import com.solid.srp.service.CalculadoraDeSalarioService;

import java.time.LocalDate;

public class SrpMain {
    public static void main(String[] args){
        Funcionario funcionario1 = new Funcionario.Builder()
                .withId(1)
                .withCargo(Cargo.DESENVOLVEDOR)
                .withDataDeAdmissao(LocalDate.now())
                .withNome("Func Developer")
                .withSalarioBase(1000L)
                .build();
        System.out.println(Cargo.DESENVOLVEDOR.name());
        System.out.println(new CalculadoraDeSalarioService().calcula(funcionario1));

        Funcionario funcionario2 = new Funcionario.Builder()
                .withId(2)
                .withCargo(Cargo.DBA)
                .withDataDeAdmissao(LocalDate.now())
                .withNome("Func DBA")
                .withSalarioBase(2000L)
                .build();
        System.out.println(Cargo.DBA.name());
        System.out.println(new CalculadoraDeSalarioService().calcula(funcionario2));

        Funcionario funcionario3 = new Funcionario.Builder()
                .withId(3)
                .withCargo(Cargo.TESTER)
                .withDataDeAdmissao(LocalDate.now())
                .withNome("Func TESTER")
                .withSalarioBase(3000L)
                .build();
        System.out.println(Cargo.TESTER.name());
        System.out.println(new CalculadoraDeSalarioService().calcula(funcionario3));
    }
}
