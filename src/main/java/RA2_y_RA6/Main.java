package RA2_y_RA6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Alumnos alumnos = new Alumnos(TipoClase.ASIR);
        String nombre = "joaquin";
        String fecha  = "30-2-2000"; //no valida
        String dni    = "12345678a";
        if (Helper.validarDNI(dni) && Helper.obtenerFechas(fecha) != null)
            alumnos.addPersona(new Persona(nombre, Helper.obtenerFechas(fecha), dni));
        nombre = "luisa";
        fecha  = "10-2-2010";
        dni    = "12345678";  //no valido
        if (Helper.validarDNI(dni) && Helper.obtenerFechas(fecha) != null)
            alumnos.addPersona(new Persona(nombre, Helper.obtenerFechas(fecha), dni));
        nombre = "esperanza";
        fecha  = "10-2-1990";
        dni    = "12345678b";
        if (Helper.validarDNI(dni) && Helper.obtenerFechas(fecha) != null)
            alumnos.addPersona(new Persona(nombre, Helper.obtenerFechas(fecha), dni));
        nombre = "esther";
        fecha  = "10-2-2022";
        dni    = "12345678c";
        if (Helper.validarDNI(dni) && Helper.obtenerFechas(fecha) != null)
            alumnos.addPersona(new Persona(nombre, Helper.obtenerFechas(fecha), dni));
        nombre = "mateo";
        fecha  = "10-2-2011";
        dni    = "12345678n";
        if (Helper.validarDNI(dni) && Helper.obtenerFechas(fecha) != null)
            alumnos.addPersona(new Persona(nombre, Helper.obtenerFechas(fecha), dni));

        alumnos.getPersonas().forEach(System.out::println);
        alumnos.cambiarNombreAlumno("12345678b", "camilo");
        alumnos.getPersonas().forEach(System.out::println);
        Persona[] personas = alumnos.obtenerPersonaMayorYPersonaMenor();
        System.out.println(Arrays.toString(personas));
        System.out.printf("Edad media: %.2f%n", alumnos.obtenerEdadMedia());
        System.out.println("Mayores de edad: " + alumnos.obtenerCantidadMayoresEdad());


    }
}
