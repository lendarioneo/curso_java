package br.com.lendarioneo.datas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrabalhandoCalendar {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        System.out.println("Data atual: " + simpleDateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        date = calendar.getTime();

        System.out.println("Data Modificada: " + simpleDateFormat.format(date));

        calendar.setTime(new Date());
        System.out.println("Ano: " + calendar.get(Calendar.YEAR));
        System.out.println("Mês: " + calendar.get(Calendar.MONTH) + 1);
        System.out.println("Dia: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hora: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minuto: " + calendar.get(Calendar.MINUTE));
        System.out.println("Segundo: " + calendar.get(Calendar.SECOND));
    }
}
