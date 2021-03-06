package br.com.lendarioneo.interfaces.contratos.model.services;

import br.com.lendarioneo.interfaces.contratos.model.entities.Parcela;

import java.util.Date;
import java.util.List;

public interface Pagamento {
    public List<Parcela> pagamentoParcelas(Date dataContrato, int quantidadeParcelas, double valorContrato);
}
