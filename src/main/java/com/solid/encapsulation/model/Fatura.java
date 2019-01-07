package com.solid.encapsulation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatura {
    private String cliente;
    private double valor;
    private List<Pagamento> pagamentos;
    private boolean pago;
    private double valorPago;

    public Fatura() {
        this.pagamentos = new ArrayList<>();
        this.pago = false;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Pagamento> getPagamentos() {
        return Collections.unmodifiableList(pagamentos);
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        pagamentos.forEach(this::addPagamento);
    }

    public boolean isPago() {
        return pago;
    }

    private void setPago() {
        if (this.valorPago >= this.valor){
            this.pago = true;
        }
    }

    public double getValorPago() {
        return valorPago;
    }

    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        this.valorPago += pagamento.getValor();
        setPago();
    }

    public int getCountOfPayments() {
        return this.pagamentos.size();
    }

    public static final class Builder {
        private Fatura fatura = new Fatura();

        public Builder withCliente(String cliente) {
            fatura.setCliente(cliente);
            return this;
        }

        public Builder withValor(double valor) {
            fatura.setValor(valor);
            return this;
        }

        public Fatura build() {
            return fatura;
        }
    }
}
