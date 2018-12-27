package com.solid.srp.model;

import com.solid.srp.enums.Cargo;

import java.time.LocalDate;

public class Funcionario {

    private int id;
    private String nome;
    private Cargo cargo;
    private LocalDate dataDeAdmissao;
    private double salarioBase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public static class Builder {

        private int id;
        private String nome;
        private Cargo cargo;
        private LocalDate dataDeAdmissao;
        private double salarioBase;

        Funcionario funcionario;

        public Builder() {
            this.funcionario = new Funcionario();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withCargo(Cargo cargo) {
            this.cargo = cargo;
            return this;
        }

        public Builder withDataDeAdmissao(LocalDate dataDeAdmissao) {
            this.dataDeAdmissao = dataDeAdmissao;
            return this;
        }

        public Builder withSalarioBase(double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public Funcionario build() {
            this.funcionario.setId(id);
            this.funcionario.setNome(nome);
            this.funcionario.setCargo(cargo);
            this.funcionario.setDataDeAdmissao(dataDeAdmissao);
            this.funcionario.setSalarioBase(salarioBase);
            return this.funcionario;
        }
    }
}
