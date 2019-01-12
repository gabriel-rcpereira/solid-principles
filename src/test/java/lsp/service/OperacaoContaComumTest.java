package lsp.service;

import com.solid.lsp.contract.OperacaoConta;
import com.solid.lsp.enums.TipoConta;
import com.solid.lsp.model.Conta;
import com.solid.lsp.service.OperacaoContaComumService;
import com.solid.lsp.service.OperacaoContaService;
import org.junit.Assert;
import org.junit.Test;

public class OperacaoContaComumTest {

    @Test(expected = IllegalArgumentException.class)
    public void sacar_QuandoContaSemSaldoSuficienteDeveDispararUmaException(){
        Conta conta = new Conta.Builder()
                .withTipoConta(TipoConta.CORRENTE)
                .withCliente("Cliente " + TipoConta.CORRENTE.name())
                .withSaldo(100.0)
                .withMilhas(0)
                .build();
        OperacaoConta operacaoConta = new OperacaoContaService(conta);

        operacaoConta.saca(150.0);
    }

    @Test
    public void sacar_QuandoContaTemSaldoSuficienteDeveDispararUmaException(){
        Conta conta = new Conta.Builder()
                .withTipoConta(TipoConta.CORRENTE)
                .withCliente("Cliente " + TipoConta.CORRENTE.name())
                .withSaldo(150.0)
                .withMilhas(0)
                .build();
        OperacaoConta operacaoConta = new OperacaoContaService(conta);

        operacaoConta.saca(150.0);
    }

    @Test
    public void depositar_QuandoSaldoIgualCemEUsuarioDepositaMaisCemValorDeveSerIgualADuzentos(){
        Conta conta = new Conta.Builder()
                .withTipoConta(TipoConta.CORRENTE)
                .withCliente("Cliente " + TipoConta.CORRENTE.name())
                .withSaldo(100.00)
                .withMilhas(0)
                .build();
        OperacaoConta operacaoConta = new OperacaoContaService(conta);

        operacaoConta.deposita(100.00);

        Assert.assertEquals(200.00, conta.getSaldo(), 0.00);
    }

    @Test
    public void rende_QuandoSaldoIgualCemEUsuarioDepositaMaisCemValorRendimentoDeveSerIgualDois(){
        Conta conta = new Conta.Builder()
                .withTipoConta(TipoConta.CORRENTE)
                .withCliente("Cliente " + TipoConta.CORRENTE.name())
                .withSaldo(100.00)
                .withMilhas(0)
                .build();
        OperacaoConta operacaoConta = new OperacaoContaService(conta);

        operacaoConta.deposita(100.00);
        operacaoConta.rende();

        Assert.assertEquals(202.00, conta.getSaldo(), 0.00);
    }
}
