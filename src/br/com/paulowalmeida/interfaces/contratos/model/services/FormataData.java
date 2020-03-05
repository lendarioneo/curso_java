package br.com.paulowalmeida.interfaces.contratos.model.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
    public static String formatar(Date data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }
}
