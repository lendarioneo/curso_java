package br.com.lendarioneo.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datas {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date y1 = dateFormat.parse("25/06/2018");
        Date y2 = dateFormat2.parse("25/06/2018 15:06:02");
        Date x1 = new Date();
        Date x2 = new Date(System.currentTimeMillis());
        Date x3 = new Date(0L);

        System.out.println("Y1: " + dateFormat.format(y1));
        System.out.println("Y2: " + dateFormat2.format(y2));
        System.out.println("X1: " + dateFormat2.format(x1));
        System.out.println("X2: " + dateFormat2.format(x2));
        System.out.println("X3: " + dateFormat2.format(x3));
    }
}
