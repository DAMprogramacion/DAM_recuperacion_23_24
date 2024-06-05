package RA2_y_RA6;

import java.time.LocalDate;
import java.time.Period;

public class Helper {
    public static int calcularEdad (LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        LocalDate fechaNacimiento = LocalDate.of(2014, 9, 3);
        System.out.println(calcularEdad(fechaNacimiento));
    }
}
