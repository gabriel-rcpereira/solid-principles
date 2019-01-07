package encapsulation.model;

import com.solid.encapsulation.enums.MeioDePagamento;
import com.solid.encapsulation.model.Fatura;
import com.solid.encapsulation.model.Pagamento;
import org.junit.Assert;
import org.junit.Test;

public class FaturaTest {

    @Test
    public void add_WhenPagamentoIsMakeSplitIsNotEnoughToCloseFatura(){
        Pagamento pagamento1 = new Pagamento.Builder()
                .withForma(MeioDePagamento.BOLETO)
                .withValor(100.0)
                .build();
        Pagamento pagamento2 = new Pagamento.Builder()
                .withForma(MeioDePagamento.CARTAO)
                .withValor(100.0)
                .build();
        Fatura fatura = new Fatura.Builder()
                .withCliente("Cliente 1")
                .withValor(300.0)
                .build();

        fatura.addPagamento(pagamento1);
        fatura.addPagamento(pagamento2);

        Assert.assertFalse(fatura.isPago());
    }

    @Test
    public void add_WhenPagamentoIsMakeSplitAndIsEnoughToCloseFatura(){
        Pagamento pagamento1 = new Pagamento.Builder()
                .withForma(MeioDePagamento.BOLETO)
                .withValor(100.0)
                .build();
        Pagamento pagamento2 = new Pagamento.Builder()
                .withForma(MeioDePagamento.CARTAO)
                .withValor(100.0)
                .build();
        Pagamento pagamento3 = new Pagamento.Builder()
                .withForma(MeioDePagamento.CARTAO)
                .withValor(100.0)
                .build();
        Fatura fatura = new Fatura.Builder()
                .withCliente("Cliente 1")
                .withValor(300.0)
                .build();

        fatura.addPagamento(pagamento1);
        fatura.addPagamento(pagamento2);
        fatura.addPagamento(pagamento3);

        Assert.assertTrue(fatura.isPago());
    }
}
