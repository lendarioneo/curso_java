package model.entidades;

import model.exceptions.EntidadesException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Date agora = new Date();

    public Reserva(int numeroQuarto, Date checkin, Date checkout) throws EntidadesException{

        if (checkin.before(agora) || checkout.before(agora)) {
            /*usada para lançar exceções para argumentos inválidos*/
            throw new EntidadesException("A data de check-in ou de check-out não pode ser anterior a hoje!");
        }

        if (checkout.before(checkin)){
            throw new EntidadesException("A data de Check-out não pode ser anterior ao Check-in!");
        }


        this.numeroQuarto = numeroQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public long calcularDuracaoDias(){
        long diferenca = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date checkin, Date checkout) throws EntidadesException {
        if (checkin.before(agora) || checkout.before(agora)) {

            /*usada para lançar exceções para argumentos inválidos*/
            throw new EntidadesException("A data de check-in ou de check-out não pode ser anterior a hoje!");
        }

        if (!checkout.after(checkin)){
            throw new EntidadesException("A data de Check-out não pode ser anterior ao Check-in!");
        }

        else {
            this.checkin = checkin;
            this.checkout = checkout;
        }
    }

    @Override
    public String toString(){
        return "Quarto: " + numeroQuarto +
                "\nCheck-in : " + simpleDateFormat.format(checkin) +
                "\nCheck-out: " + simpleDateFormat.format(checkout) +
                "\nDuracao: " + calcularDuracaoDias() + " dia(s)";
    }
}
