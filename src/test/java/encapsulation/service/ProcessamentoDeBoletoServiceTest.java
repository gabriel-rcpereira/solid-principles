package encapsulation.service;

import com.solid.encapsulation.model.Boleto;
import com.solid.encapsulation.model.Fatura;
import com.solid.encapsulation.service.ProcessamentoDeBoletoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProcessamentoDeBoletoServiceTest {

    @Test
    public void processa_WhenMakeTwoPaymentsShouldGenerateTwoPayments(){
        ProcessamentoDeBoletoService processamentoDeBoletoService = new ProcessamentoDeBoletoService();
        List<Boleto> boletos = Arrays.asList(
                CreateBoleto(100.0),
                CreateBoleto(100.0));
        Fatura fatura = new Fatura.Builder()
                .withValor(400.0)
                .withCliente("Cliente 1")
                .build();

        processamentoDeBoletoService.processa(boletos, fatura);

        Assert.assertEquals("Expected two payments",
                2,
                fatura.getCountOfPayments());
    }

    @Test
    public void processa_WhenMakeTwoPaymentsAndTheTotalIsEqualTo200(){
        ProcessamentoDeBoletoService processamentoDeBoletoService = new ProcessamentoDeBoletoService();
        List<Boleto> boletos = Arrays.asList(
                CreateBoleto(100.0),
                CreateBoleto(100.0));
        Fatura fatura = new Fatura.Builder()
                .withValor(400.0)
                .withCliente("Cliente 1")
                .build();

        processamentoDeBoletoService.processa(boletos, fatura);

        Assert.assertTrue("Expected that valor total should be equal to 200.00",
                fatura.getValorPago() == 200.00);
    }

    @Test
    public void processa_WhenMakeTwoPaymentsFaturaShouldBeOpened(){
        ProcessamentoDeBoletoService processamentoDeBoletoService = new ProcessamentoDeBoletoService();
        List<Boleto> boletos = Arrays.asList(
                CreateBoleto(100.0),
                CreateBoleto(100.0));
        Fatura fatura = new Fatura.Builder()
                .withValor(400.0)
                .withCliente("Cliente 1")
                .build();

        processamentoDeBoletoService.processa(boletos, fatura);

        Assert.assertFalse("Expected that Fatura is open still",
                fatura.isPago());
    }

    @Test
    public void processa_WhenMakeThreePaymentsFaturaShouldBeClosed(){
        ProcessamentoDeBoletoService processamentoDeBoletoService = new ProcessamentoDeBoletoService();
        List<Boleto> boletos = Arrays.asList(
                CreateBoleto(100.0),
                CreateBoleto(100.0),
                CreateBoleto(200.0));
        Fatura fatura = new Fatura.Builder()
                .withValor(400.0)
                .withCliente("Cliente 1")
                .build();

        processamentoDeBoletoService.processa(boletos, fatura);

        Assert.assertTrue("Expected that Fatura is close",
                fatura.isPago());
    }

    private Boleto CreateBoleto(double valor) {
        return new Boleto.Builder()
            .withValor(valor)
            .build();
    }
}
