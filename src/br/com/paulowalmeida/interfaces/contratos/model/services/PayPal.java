package br.com.paulowalmeida.interfaces.contratos.model.services;

import br.com.paulowalmeida.interfaces.contratos.model.entities.Parcela;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PayPal implements Pagamento{

    @Override
    public List<Parcela> pagamentoParcelas(Date dataContrato, int quantidadeParcelas, double valorContrato) {
        List<Parcela> parcelas = new ArrayList<>();
        for(int i = 1; i <= quantidadeParcelas; i++){
            Date dataParcela = this.formatarData(dataContrato, i);
            Double parcela = (valorContrato / quantidadeParcelas);
            Double totalParcela = parcela * 0.01 * 1 + parcela * 0.02;
            parcelas.add(new Parcela(dataParcela, totalParcela));
        }
        return parcelas;
    }

    private Date formatarData(Date dataContrato, int numeroParcela){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataContrato);
        calendar.add(Calendar.MONTH, numeroParcela);
        Date dataParcela = calendar.getTime();
        return dataParcela;
    }
}
