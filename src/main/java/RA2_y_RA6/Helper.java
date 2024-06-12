package RA2_y_RA6;

import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class Helper {
    public static int calcularEdad (LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
    public static boolean validarDNI (String dni) {
        return dni.toLowerCase().matches("[0-9]{8}[a-z]");
    }
    public static LocalDate obtenerFechas (String fecha) {
        boolean valido = fecha.matches("[0-9]{1,2}[-/][0-9]{1,2}[-/][0-9]{3,4}");
        if (valido) {
            try {
                String[] tokens = fecha.split("[-/]");
                int dia = Integer.parseInt(tokens[0]);
                int mes = Integer.parseInt(tokens[1]);
                int anno = Integer.parseInt(tokens[2]);
                return LocalDate.of(anno, mes, dia);
            } catch (DateTimeException e) {
                return null;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        /*System.out.println(LocalDate.now());
        LocalDate fechaNacimiento = LocalDate.of(2014, 9, 3);
        System.out.println(calcularEdad(fechaNacimiento));
        System.out.println("Validar: 12345678a: " + validarDNI("12345678a"));
        System.out.println("Validar: 12345678A: " + validarDNI("12345678A"));
        System.out.println("Validar: 123456789A: " + validarDNI("123456789A"));
        System.out.println("Validar: 123456A: " + validarDNI("123456A"));
        System.out.println("Validar: 12345678AA: " + validarDNI("12345678AA"));
        System.out.println("Validar: 12345678: " + validarDNI("12345678"));*/
        System.out.println("Validar 10-10-2000: " + obtenerFechas("10-10-2000"));
        System.out.println("Validar 100-10-2000: " + obtenerFechas("100-10-2000"));
        System.out.println("Validar 10-10-200: " + obtenerFechas("10-10-200"));
        System.out.println("Validar 10/10/2000: " + obtenerFechas("10/10/2000"));
        System.out.println("Validar 10-2-2000: " + obtenerFechas("10-2-2000"));
        System.out.println("Validar 50-12-2000: " + obtenerFechas("50-12-2000"));
        System.out.println("Validar 30-2-2000: " + obtenerFechas("30-2-2000"));
    }
}
