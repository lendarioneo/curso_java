package br.com.paulowalmeida.interfaces.contratos.view;

import br.com.paulowalmeida.interfaces.contratos.model.entities.Contrato;
import br.com.paulowalmeida.interfaces.contratos.model.entities.Parcela;
import br.com.paulowalmeida.interfaces.contratos.model.services.Pagamento;
import br.com.paulowalmeida.interfaces.contratos.model.services.PayPal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContratoView {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int numero = 892;
        Date dataContrato = simpleDateFormat.parse("12/01/2020");
        double valor = 600.0;
        int qtdParcelas = 3;

        Pagamento pagamento = new PayPal();

        List<Parcela> parcelas = pagamento.pagamentoParcelas(dataContrato, qtdParcelas, valor);
        Contrato contrato = new Contrato(numero, dataContrato, valor, parcelas);
        contrato.exibeInformacoes();
    }
}
